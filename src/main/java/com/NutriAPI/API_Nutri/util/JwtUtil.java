package com.NutriAPI.API_Nutri.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

public class JwtUtil {
    private final String SECRET_KEY = "sua_chave_secreta"; // Substitua por uma chave segura

    public String gerarToken(String cpf) {
        return Jwts.builder().setSubject(cpf).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validade
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public String extractCpf(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
}
