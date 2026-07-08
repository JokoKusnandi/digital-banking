package com.banking.common.security.jwt;

/*public interface JwtProvider {

    JwtToken generate(JwtClaims claims);

    boolean validate(String token);

    JwtClaims parse(String token);

}*/


import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtProvider {

    private final JwtProperties properties;

    public JwtProvider(JwtProperties properties){

        this.properties = properties;

    }

    public SecretKey getSigningKey(){

        return Keys.hmacShaKeyFor(

                properties.getSecret()

                        .getBytes(StandardCharsets.UTF_8)

        );

    }

}