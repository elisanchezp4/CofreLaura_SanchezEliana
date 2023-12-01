package com.backend.clinica.services.impl;

import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.models.entities.Paciente;
import com.backend.clinica.repositories.PacienteRepository;
import com.backend.clinica.services.IOdontologoService;
import com.backend.clinica.services.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements IPacienteService {

    private PacienteRepository pacienteRepository;
    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente agregar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente modificar(Paciente paciente, Long id) {
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El Paciente con id: " + id + " no se encontro"));
        pacienteEncontrado.setApellido(paciente.getApellido());
        pacienteEncontrado.setNombre(paciente.getNombre());
        pacienteEncontrado.setDomicilio(paciente.getDomicilio());
        pacienteEncontrado.setDni(paciente.getDni());
        pacienteEncontrado.setFechaCreacion(LocalDateTime.now());
        return pacienteRepository.save(pacienteEncontrado);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El Paciente con id: " + id + " no se encontro"));
    }
}
