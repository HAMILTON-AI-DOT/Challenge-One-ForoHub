package com.foroHub.api.controller;
import com.foroHub.api.domain.topico.*;
import com.foroHub.api.repository.TopicoRepository;
import com.foroHub.api.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    public TopicoRepository topicoRepository;


    @Autowired
    private TopicoService topicoService;


    @PostMapping
    public ResponseEntity<TopicoRespuesta> crear(@RequestBody DatosCrearTopico datos) {
        TopicoRespuesta respuesta = topicoService.crearTopico(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }


    @GetMapping
    public ResponseEntity<Page<TodosLosTopicos>> listarTopicos(
            @PageableDefault(size = 10, sort = "fechaDeCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {

        return ResponseEntity.ok(
                topicoRepository.findByStatusTrue(paginacion).map(TodosLosTopicos::new)
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> buscarTopicoPorId(@PathVariable Long id) {
        DatosDetalleTopico detalle = topicoService.buscarPorId(id);
        return ResponseEntity.ok(detalle);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datos) {
        return topicoService.actualizarTopico(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        boolean eliminado = topicoService.eliminarTopico(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }











}