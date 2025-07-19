package com.foroHub.api.service;

import com.foroHub.api.domain.curso.Curso;
import com.foroHub.api.domain.curso.DatosCurso;
import com.foroHub.api.domain.topico.Topico;
import com.foroHub.api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {



    @Autowired
    CursoRepository cursoRepository;




    public List<Curso> listarCursos(){
      return  cursoRepository.findAll();
    }

    public Curso crearCurso(DatosCurso datosCurso){
     Curso curso = new Curso(datosCurso);
        return cursoRepository.save(curso);
    }


}
