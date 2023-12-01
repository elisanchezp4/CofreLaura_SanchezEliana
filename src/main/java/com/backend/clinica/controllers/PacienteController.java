package com.backend.clinica.controllers;
import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.models.entities.Turno;
import com.backend.clinica.services.IOdontologoService;
import com.backend.clinica.services.IPacienteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paciente")
@AllArgsConstructor
public class PacienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteController.class);

    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) {
        LOGGER.info("Se guardo exitosamente el paciente" + paciente.toString());
        return new ResponseEntity<>(pacienteService.agregar(paciente), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> buscarPaciente() {
        return new ResponseEntity<>(pacienteService.listar(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente, @PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.modificar(paciente, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        LOGGER.info("Se elimino exitosamente el paciente con id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Paciente> obtenerPorId(@PathVariable Long Id) {
        Paciente paciente = pacienteService.buscarPorId(Id);
        LOGGER.info("Se encontro exitosamente el turno" + paciente.toString());
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

}
