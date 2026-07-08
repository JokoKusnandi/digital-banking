package com.banking.authservice.service;

import com.banking.authservice.config.JwtProperties;
import com.banking.authservice.entity.Roles;
import com.banking.authservice.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtProperties jwtProperties;

    public String generateAccessToken(User user) {
        return generateToken(
                user,
                jwtProperties.getAccessExpiration(),
                "ACCESS"
        );

    }

    public String generateRefreshToken(User user) {

        return generateToken(
                user,
                jwtProperties.getRefreshExpiration(),
                "REFRESH"
        );

    }

    public String generateToken(  User user,
                                  long expiration,
                                  String tokenType) {

        Date now = new Date();

        Date expiry = new Date(now.getTime() + (expiration * 1000));

        return Jwts.builder()
                .subject(user.getEmail())
                .issuer(jwtProperties.getIssuer())
                .audience()
                    .add(jwtProperties.getAudience())
                    .and()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim(
                        "role",
                        user.getRoles()
                                .stream()
                                .findFirst()
                                .map(Roles::getName)
                                .orElse("CUSTOMER")
                )
                .claim("type", tokenType)
                .id(UUID.randomUUID().toString())
                .issuedAt(now)
                .expiration(expiry)
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception ex) {

            return false;

        }

    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public <T> T extractClaim(
            String token,
            Function<Claims, T> resolver
    ) {

        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return resolver.apply(claims);

    }

    public String extractRole(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("role", String.class);

    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }
}
