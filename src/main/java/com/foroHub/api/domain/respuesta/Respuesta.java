package com.foroHub.api.domain.respuesta;

import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.domain.topico.Topico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private Topico topico;
    private LocalDate fechaDeCreacion;
    private Usuario autor;
    private String solucion;
}
