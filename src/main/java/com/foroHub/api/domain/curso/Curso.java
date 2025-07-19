package com.foroHub.api.domain.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;
    private String categoria;


    public Curso(DatosCurso datosCurso) {
        this.categoria = datosCurso.categoria();
        this.nombre = datosCurso.nombre();
    }
}
