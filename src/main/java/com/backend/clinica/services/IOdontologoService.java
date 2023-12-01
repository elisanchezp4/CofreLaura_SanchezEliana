package com.backend.clinica.services;

import com.backend.clinica.models.entities.Odontologo;

import java.util.List;


public interface IOdontologoService {
    List<Odontologo> listar();
    Odontologo agregar(Odontologo odontologo);
    void eliminar(Long id);
    Odontologo modificar(Odontologo odontologo, Long id);
    Odontologo buscarPorId(Long id);
}
