package com.backend.clinica.repositories;

import com.backend.clinica.models.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno,Long > {
}
