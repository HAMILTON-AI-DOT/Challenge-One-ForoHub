package com.foroHub.api.domain.topico;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.usuario.Usuario;
import org.antlr.v4.runtime.misc.NotNull;

public record DatosTopico(
        String titulo,
        String mensaje,
        Long autorId,
        Long cursoId
){
    public DatosTopico(String titulo, String mensaje, Long autorId, Long cursoId) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autorId = autorId;
        this.cursoId = cursoId;
    }
}
