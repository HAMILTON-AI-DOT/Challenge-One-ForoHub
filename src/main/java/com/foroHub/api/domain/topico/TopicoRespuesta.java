package com.foroHub.api.domain.topico;

import java.time.LocalDate;
        public record TopicoRespuesta(
        Long id,
        String titulo,
        String mensaje,
        String autorNombre,
        String cursoNombre,
        LocalDate fechaDeCreacion,
        Boolean status
) {}

