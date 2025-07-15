package com.foroHub.api.domain.topico;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.respuesta.Respuesta;
import com.foroHub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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




}
