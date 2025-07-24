package com.foroHub.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.foroHub.api.domain.usuario.Usuario;
import com.foroHub.api.exceptions.JwtGenerationException;
import com.foroHub.api.exceptions.JwtVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;


    public String generarToken(Usuario usuario) {
        try {
            if (usuario.getCorreoElectronico() == null) {
                throw new IllegalArgumentException("el email no puede estar vacio!!");
            }

            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Foro-Hub")
                    .withSubject(usuario.getCorreoElectronico())
                    .withExpiresAt(fechaDeExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException ex) {
            throw new JwtGenerationException("Error al generar token", ex);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Foro-Hub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new JwtVerificationException("Token inválido o expirado");
        }
    }

    private Instant fechaDeExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }



    }


