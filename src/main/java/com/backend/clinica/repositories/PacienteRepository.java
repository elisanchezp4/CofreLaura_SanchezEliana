package com.backend.clinica.repositories;

import com.backend.clinica.models.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long > {
}
