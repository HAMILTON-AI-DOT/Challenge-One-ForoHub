package com.foroHub.api.domain.topico;

import java.time.LocalDate;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        String autorNombre,
        String cursoNombre
) {
    public DatosListaTopico(Topico topico) {
        this(
                topico.getTopico_id(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
