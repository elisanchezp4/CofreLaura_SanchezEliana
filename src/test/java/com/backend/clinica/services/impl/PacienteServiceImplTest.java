package com.backend.clinica.services.impl;

import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.repositories.PacienteRepository;
import com.backend.clinica.services.IPacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceImplTest {

    @Autowired
    private IPacienteService pacienteService;
    @Mock
    private PacienteRepository pacienteRepository;
    private Paciente paciente;

    @BeforeEach
    void setUp(){
        paciente = Paciente.builder()
                .id(1L)
                .apellido("Perez")
                .dni(2413)
                .domicilio("calle 90- 25")
                .nombre("Pepito")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    @Test
    void listaVaciaPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        assertTrue(pacientes.isEmpty());
    }

    @Test
    void agregarPacienteOK() {
        Paciente pacienteGuardado = pacienteService.agregar(paciente);
        assertFalse(pacienteGuardado == null);
    }

    @Test
    void buscaPaciente() {
        Paciente pacienteGuardado = pacienteService.agregar(paciente);
        Paciente pacienteBuscado = pacienteService.buscarPorId(1L);

        assertEquals(pacienteBuscado.getNombre(), pacienteGuardado.getNombre());

    }
}