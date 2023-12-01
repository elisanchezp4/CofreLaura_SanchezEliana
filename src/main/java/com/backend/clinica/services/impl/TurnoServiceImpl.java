package com.backend.clinica.services.impl;

import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.models.entities.Turno;
import com.backend.clinica.repositories.OdontologoRepository;
import com.backend.clinica.repositories.PacienteRepository;
import com.backend.clinica.repositories.TurnoRepository;
import com.backend.clinica.services.IPacienteService;
import com.backend.clinica.services.ITurnoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoServiceImpl implements ITurnoService {

    private TurnoRepository turnoRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    @Override
    public Turno asignarTurnoPaciente(Long odontologoId, Long pacienteId, LocalDateTime fechaTurno) {
        Odontologo odontologoEncontrado = odontologoRepository
                .findById(odontologoId).orElseThrow(() ->
                        new ResourceNotFoundException("El odontologo con id: " + odontologoId + " no se encontro"));

        Paciente pacienteEncontrado = pacienteRepository.findById(pacienteId).orElseThrow(() ->
                new ResourceNotFoundException("El Paciente con id: " + pacienteId + " no se encontro"));

        Turno turnoCreado =
                Turno
                        .builder()
                        .odontologo(odontologoEncontrado)
                        .paciente(pacienteEncontrado)
                        .fechaTurno(fechaTurno)
                        .build();

        return turnoRepository.save(turnoCreado);
    }

    @Override
    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno modificar(Turno turno, Long turnoId, Long pacienteId, Long odontologoId) {
        Turno turnoEncontrado = turnoRepository.findById(turnoId).orElseThrow(() ->
                new ResourceNotFoundException("El turno con Id: " + turnoId + "no se encontro"));

        Paciente pacienteEncontrado = pacienteRepository.findById(pacienteId).orElseThrow(() ->
                new ResourceNotFoundException("El Paciente con id: " + pacienteId + " no se encontro"));

        Odontologo odontologoEncontrado = odontologoRepository.findById(odontologoId).orElseThrow(() ->
                new ResourceNotFoundException("El odontologo con id: " + odontologoId+ " no se encontro"));


        turnoEncontrado.setFechaTurno(turno.getFechaTurno());
        turnoEncontrado.setOdontologo(odontologoEncontrado);
        turnoEncontrado.setPaciente(pacienteEncontrado);

        return turnoRepository.save(turnoEncontrado);
    }

    @Override
    public Turno buscarPorId(Long id) {
        return turnoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El paciente con Id: " + id + " no se encontro"));
    }
}
