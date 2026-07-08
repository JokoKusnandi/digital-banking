package com.banking.common.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenParser {

    private final JwtProvider keyProvider;

}
/*

Method

parse()

extractUsername()

extractRole()

extractExpiration()

extractClaims()*/
