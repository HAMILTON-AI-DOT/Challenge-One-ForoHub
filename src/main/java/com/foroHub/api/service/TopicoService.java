package com.foroHub.api.service;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.topico.*;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.repository.CursoRepository;
import com.foroHub.api.repository.TopicoRepository;
import com.foroHub.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private PerfilesService perfilesService;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;






    public TopicoRespuesta crearTopico(DatosCrearTopico datos) {
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico nuevo = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        Topico guardado = topicoRepository.save(nuevo);

        return new TopicoRespuesta(
                guardado.getTopico_id(),
                guardado.getTitulo(),
                guardado.getMensaje(),
                autor.getNombre(),
                curso.getNombre(),
                guardado.getFechaDeCreacion(),
                guardado.getStatus()
        );
    }




    public DatosDetalleTopico buscarPorId(Long id) {
        return topicoRepository.findById(id)
                .map(DatosDetalleTopico::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));
    }


    public Optional<DatosDetalleTopico> actualizarTopico(Long id, DatosActualizarTopico datos) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();

            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());

            topicoRepository.save(topico);

            return Optional.of(new DatosDetalleTopico(topico));
        }

        return Optional.empty();
    }



    public boolean eliminarTopico(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return true;
        }

        return false;
    }










}
