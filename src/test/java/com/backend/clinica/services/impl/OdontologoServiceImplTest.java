package com.backend.clinica.services.impl;

import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.repositories.OdontologoRepository;
import com.backend.clinica.services.IOdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OdontologoServiceImplTest {
    @Autowired
    private IOdontologoService odontologoService;
    @Mock
    private OdontologoRepository odontologoRepository;
    private Odontologo odontologo;

    @BeforeEach
    void setUp(){
        odontologo = Odontologo.builder()
                .id(1L)
                .apellido("Rodriguez")
                .nombre("Juanito")
                .matricula("1234j")
                .build();
    }


    @Test
    void listarOdontologo() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        assertTrue(odontologos.isEmpty());
    }


    @Test
    void modificar() {
        Odontologo odontologoModificado = Odontologo.builder()
                .id(1L)
                .apellido("Perez")
                .nombre("Ana")
                .matricula("SFT")
                .build();
        Odontologo odontologoActual = odontologoService.agregar(odontologoModificado);
        assertEquals("Perez", odontologoActual.getApellido());
    }

    @Test
    void buscarPorId() {
    Odontologo odontologoGuardado = odontologoService.agregar(odontologo);
    Odontologo odontologoBuscado = odontologoService.buscarPorId(odontologoGuardado.getId());

    assertEquals(odontologoBuscado.getId(),odontologoGuardado.getId());
    }
}