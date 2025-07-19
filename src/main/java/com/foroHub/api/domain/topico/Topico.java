package com.foroHub.api.domain.topico;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.perfiles.Perfiles;
import com.foroHub.api.domain.respuesta.DatosRespuesta;
import com.foroHub.api.domain.respuesta.Respuesta;
import com.foroHub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topico_id;


    private String titulo;
    private String mensaje;
    private LocalDate fechaDeCreacion;
    private Boolean status;


    @ManyToOne
    private Usuario autor;


    @ManyToOne
    private Curso curso;


    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();


    public Topico(Topico datos, Optional<Curso> curso, Optional<Perfiles> autor) {
    }

    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.fechaDeCreacion = LocalDate.now();
        this.status = true;
    }

}

