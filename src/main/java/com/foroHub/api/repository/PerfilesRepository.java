package com.foroHub.api.repository;

import com.foroHub.api.domain.perfiles.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Long> {
}
