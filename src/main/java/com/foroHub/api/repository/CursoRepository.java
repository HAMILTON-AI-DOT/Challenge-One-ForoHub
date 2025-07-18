package com.foroHub.api.repository;

import com.foroHub.api.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
