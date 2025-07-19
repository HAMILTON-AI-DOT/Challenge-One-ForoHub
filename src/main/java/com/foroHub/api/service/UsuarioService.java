package com.foroHub.api.service;

import com.foroHub.api.domain.perfiles.Perfiles;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.repository.PerfilesRepository;
import com.foroHub.api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {




    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
   private PerfilesRepository perfilesRepository;




    public Usuario buscarUsuarioPorId(Long id){
       return usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new );
    }




  public String crearUsuario(Usuario usuario){

      Perfiles perfiles = perfilesRepository.save(new Perfiles(usuario.getId(), usuario.getNombre()));
      usuarioRepository.save(usuario);
      return "sexo";

  }
}
