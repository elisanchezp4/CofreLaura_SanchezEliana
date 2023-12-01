package com.backend.clinica.services.impl;

import com.backend.clinica.exceptions.ResourceNotFoundException;
import com.backend.clinica.models.entities.Odontologo;
import com.backend.clinica.repositories.OdontologoRepository;
import com.backend.clinica.services.IOdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OdontologoServiceImpl implements IOdontologoService {

    private OdontologoRepository odontologoRepository;
    @Override
    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminar(Long id) {

        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo, Long id) {
        Odontologo odontologoEncontrado = odontologoRepository
                .findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("El odontologo con id: " + id + " no se encontro"));

        odontologoEncontrado.setApellido(odontologo.getApellido());
        odontologoEncontrado.setNombre(odontologo.getNombre());
        odontologoEncontrado.setMatricula(odontologo.getMatricula());
        return odontologoRepository.save(odontologoEncontrado);
    }

    @Override
    public Odontologo buscarPorId(Long id) {
        return odontologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
    }
}
