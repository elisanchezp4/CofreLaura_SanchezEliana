package com.backend.clinica.controllers;

import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.models.entities.Turno;
import com.backend.clinica.services.ITurnoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/turno")
@AllArgsConstructor
public class TurnoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurnoController.class);

    private ITurnoService turnoService;
    @PostMapping("/asignar/{odontologoId}/{pacienteId}")
    public ResponseEntity<Turno> asignarTurnoPaciente(@PathVariable Long odontologoId, @PathVariable Long pacienteId,
                                                      @RequestParam LocalDateTime fechaTurno) {
        LOGGER.info("Se creo exitosamente el turno");
        return new ResponseEntity<>(turnoService.asignarTurnoPaciente(odontologoId, pacienteId, fechaTurno), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Turno>> buscarTurno() {
        return new ResponseEntity<>(turnoService.listar(), HttpStatus.OK);
    }

    @PutMapping("/{turnoId}")
    public ResponseEntity<Turno> modificarTurno(@RequestBody Turno turno, @PathVariable Long turnoId,
                                                @RequestParam Long pacienteId, @RequestParam Long odontologoId) {
        return new ResponseEntity<>(turnoService.modificar(turno, turnoId, pacienteId,odontologoId),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        turnoService.eliminar(id);
        LOGGER.info("Se elimino exitosamente el turno con id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Turno> obtenerTurnoPorId(@PathVariable Long Id){
        Turno turno = turnoService.buscarPorId(Id);
        LOGGER.info("Se encontro exitosamente el turno" + turno.toString());
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }
}
