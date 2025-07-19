package com.foroHub.api.controller;


import com.foroHub.api.domain.usuario.DatosUsuario;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    public void crearUsuario(@RequestBody Usuario datosUsuario){
        usuarioService.crearUsuario(datosUsuario);
    }
}
