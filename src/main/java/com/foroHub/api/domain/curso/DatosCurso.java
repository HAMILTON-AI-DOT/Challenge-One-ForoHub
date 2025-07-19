package com.foroHub.api.domain.curso;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosCurso(
        @NotNull
        String nombre,
        @NotNull
        String categoria
) {
}
