package com.springBootLearning.spring_boot_0_1.Security;

import com.springBootLearning.spring_boot_0_1.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecret;

    private SecretKey getSecretKey(){
    return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generate(User user){
       return  Jwts.builder()
                .setSubject(user.getUserId().toString())
                .claim("email",user.getEmail())
                .claim("roles", Set.of("ADMIN","USER"))
                .setIssuedAt(new Date())
                .signWith(getSecretKey())
                .compact();
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token) // Use parseClaimsJws for signed tokens
                .getBody();
        return Long.valueOf(claims.getSubject());
    }




}
