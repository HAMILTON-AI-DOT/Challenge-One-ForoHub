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

    public Respuesta(DatosRespuesta datosRespuesta) {
        this.id = null;
        this.mensaje = datosRespuesta.mensaje();
        this.fechaDeCreacion = LocalDate.now();
        this.autor = getAutor();
        this.solucion = solucion;
    }
}
