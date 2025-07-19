package com.foroHub.api.service;

import com.foroHub.api.domain.perfiles.Perfiles;
import com.foroHub.api.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilesService {



    @Autowired
    PerfilesRepository perfilesRepository;


    public Optional<Perfiles> getPerfilPorId(Long id){
         return perfilesRepository.findById(id);
    }


}
