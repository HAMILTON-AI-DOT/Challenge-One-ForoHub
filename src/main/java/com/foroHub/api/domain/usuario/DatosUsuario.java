package com.foroHub.api.domain.usuario;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosUsuario(
        @NotNull
         String nombre,
         @NotNull
         String correoElectronico,
        @NotNull
        Long contrasena

) {
}
