package com.backend.clinica.services.impl;

import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.models.entities.Turno;
import com.backend.clinica.repositories.OdontologoRepository;
import com.backend.clinica.repositories.PacienteRepository;
import com.backend.clinica.repositories.TurnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TurnoServiceImplTest {

    @Mock
    private TurnoRepository turnoRepository;
    @Mock
    private PacienteRepository pacienteRepository;
    @Mock
    private OdontologoRepository odontologoRepository;

    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    void setUp() {
        odontologo = Odontologo.builder()
                .id(1L)
                .apellido("Rodriguez")
                .nombre("Juanito")
                .matricula("1234j")
                .build();

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
    public void asignarTurnoExitoso() {

        Turno turno = Turno.builder()
                .id(1L)
                .fechaTurno(LocalDateTime.now())
                .paciente(paciente)
                .odontologo(odontologo)
                .build();
        Turno turnoGuardado = turnoRepository.save(turno);
        when(turnoRepository.save(turno)).thenReturn(turnoGuardado);
        verify(turnoRepository, times(1)).save(turno);
    }

    @Test
    void listar(){

        Turno turno = Turno.builder()
                .id(1L)
                .fechaTurno(LocalDateTime.now())
                .paciente(pacienteRepository.save(paciente))
                .odontologo(odontologoRepository.save(odontologo))
                .build();
        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno);

        when(turnos.size()).thenReturn(1);
        assertTrue(turnos.size() == 1);
    }
}