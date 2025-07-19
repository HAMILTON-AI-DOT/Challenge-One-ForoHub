package com.foroHub.api.domain.topico;

public record DatosCrearTopico(
        String titulo,
        String mensaje,
        Long autorId,
        Long cursoId
) {
}
