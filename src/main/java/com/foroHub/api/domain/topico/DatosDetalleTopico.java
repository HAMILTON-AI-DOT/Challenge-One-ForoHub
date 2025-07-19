package com.foroHub.api.domain.topico;

import java.time.LocalDate;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        LocalDate fechaDeCreacion,
        Boolean status,
        String autorNombre,
        String cursoNombre
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}

