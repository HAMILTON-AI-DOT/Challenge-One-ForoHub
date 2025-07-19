package com.foroHub.api.domain.topico;

import java.time.LocalDate;

public record TodosLosTopicos(
        String titulo,
        String mensaje,
        String autorNombre,
        String cursoNombre,
        LocalDate fechaDeCreacion,
        Boolean status
) {
    public TodosLosTopicos(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre(),
                topico.getFechaDeCreacion(),
                topico.getStatus()
        );
    }
}
