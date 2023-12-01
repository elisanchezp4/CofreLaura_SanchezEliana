package com.backend.clinica.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "odontologos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "La matricula del odontólogo no puede ser nula")
    @NotEmpty(message = "La matricula no debe ser vacia")
    @NotBlank(message = "Debe especificarse la matricula del odontólogo")
    @Column(name = "matricula")
    private String matricula;

    @NotNull(message = "El nombre de odontólogo no puede ser nulo")
    @NotEmpty(message = "El nombre de odontologo no debe ser vacio")
    @NotBlank(message = "Debe especificarse el nombre del odontólogo")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El apellido de odontólogo no puede ser nulo")
    @NotEmpty(message = "El apellido de odontologo no debe ser vacio")
    @NotBlank(message = "Debe especificarse el apellido del odontólogo")
    @Column(name = "apellido")
    private String apellido;
}
