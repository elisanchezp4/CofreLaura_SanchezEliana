package com.backend.clinica.services;

import com.backend.clinica.models.entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listar();
    Paciente agregar(Paciente paciente);
    void eliminar(Long id);
    Paciente modificar(Paciente paciente, Long id);
    Paciente buscarPorId(Long id);
}
