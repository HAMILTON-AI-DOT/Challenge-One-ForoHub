package com.foroHub.api.controller;

import com.foroHub.api.domain.usuario.DatosAutenticacion;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.security.DatosTokenJWT;
import com.foroHub.api.security.TokenService;
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
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;



    @PostMapping
    public ResponseEntity iniciarSesion ( @RequestBody @Validated DatosAutenticacion datosAtenticacion){
        var token = new UsernamePasswordAuthenticationToken(datosAtenticacion.correoElectronico(),datosAtenticacion.contrasena());
        var autenticacionToken = manager.authenticate(token);

        var tokenJWT = tokenService.generarToken((Usuario) autenticacionToken.getPrincipal());


        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }


}
