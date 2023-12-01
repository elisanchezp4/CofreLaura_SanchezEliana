package com.backend.clinica.services;

import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.models.entities.Turno;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface ITurnoService {
    Turno asignarTurnoPaciente(Long odontologoId, Long pacienteId, LocalDateTime fechaTurno);

    List<Turno> listar();

    void eliminar(Long id);

    Turno modificar(Turno turno, Long turnoId, Long pacienteId, Long odontologoId);

    Turno buscarPorId(Long id);
}

