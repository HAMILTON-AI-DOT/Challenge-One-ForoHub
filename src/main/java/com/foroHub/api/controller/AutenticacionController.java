package com.foroHub.api.controller;

import com.foroHub.api.domain.usuario.DatosAutenticacion;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {


    @Autowired
    private AuthenticationManager manager;



    @PostMapping
    public ResponseEntity iniciarSesion ( @RequestBody @Validated DatosAutenticacion datosAtenticacion){
        var token = new UsernamePasswordAuthenticationToken(datosAtenticacion.correoElectronico(),datosAtenticacion.contrasena());
        var autenticacion = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }


}
