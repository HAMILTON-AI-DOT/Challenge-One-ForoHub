package com.foroHub.api.controller;

import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.repository.UsuarioRepository;
import com.foroHub.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    public void crearUsuario(@RequestBody Usuario datosUsuario){
        usuarioService.crearUsuario(datosUsuario);
    }


    @DeleteMapping("/{id}")
    public void borrarUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }
}
