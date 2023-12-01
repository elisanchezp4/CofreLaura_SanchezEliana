package com.backend.clinica.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotEmpty(message = "El nombre no debe ser vacio")
    @NotBlank(message = "Debe especificarse el nombre del paciente")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El apellido del paciente no puede ser nulo")
    @NotEmpty(message = "El apellido no debe ser vacio")
    @NotBlank(message = "Debe especificarse el apellido del paciente")
    @Column(name = "apellido")
    private String apellido;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @NotEmpty(message = "El domicilio no debe ser vacio")
    @NotBlank(message = "Debe especificarse el domicilio del paciente")
    @Column(name = "domicilio")
    private String domicilio;

    @Positive
    @Column(name = "dni")
    private int dni;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}
