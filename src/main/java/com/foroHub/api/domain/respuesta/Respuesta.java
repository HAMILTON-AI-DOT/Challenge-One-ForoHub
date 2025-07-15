package com.foroHub.api.domain.respuesta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Respuesta {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;


    @ManyToOne
    private Topico topico;


    private LocalDate fechaDeCreacion;

    @ManyToOne
    private Usuario autor;
    private Boolean solucion = false;
}
