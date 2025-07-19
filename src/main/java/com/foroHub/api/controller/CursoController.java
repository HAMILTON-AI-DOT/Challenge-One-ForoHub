package com.foroHub.api.controller;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.curso.DatosCurso;
import com.foroHub.api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    public CursoService cursoService;


    @PostMapping("/crear")
    public ResponseEntity<Curso> crearCurso(@RequestBody DatosCurso datosCurso){
        var curso = cursoService.crearCurso(datosCurso);
         return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }


    @GetMapping
    public List<Curso> listarCursos(){
        return cursoService.listarCursos();
    }






}
