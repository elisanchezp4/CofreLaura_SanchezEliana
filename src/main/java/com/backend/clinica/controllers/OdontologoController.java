package com.backend.clinica.controllers;

import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.services.IOdontologoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
@AllArgsConstructor
public class OdontologoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoController.class);

    private IOdontologoService odontologoService;

    @GetMapping("/{odontologoId}")
    public ResponseEntity<Odontologo> obtenerOdontologoPorId(@PathVariable Long odontologoId){
        Odontologo odontologo = odontologoService.buscarPorId(odontologoId);
        LOGGER.info("Se encontro exitosamente el odontologo" + odontologo.toString());
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return new ResponseEntity<>(odontologoService.agregar(odontologo), HttpStatus.CREATED);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<Odontologo>> buscarOdontologo(){
        return new ResponseEntity<>(odontologoService.listar(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo, @PathVariable Long id){
        return new ResponseEntity<>(odontologoService.modificar(odontologo, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        odontologoService.eliminar(id);
        LOGGER.info("Se elimino exitosamente el odontologo con id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
