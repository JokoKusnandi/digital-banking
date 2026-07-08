package com.banking.common.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenGenerator {

    private final JwtProvider keyProvider;

    private final JwtProperties properties;

}
/*

Method yang akan dibuat

generateAccessToken()

generateRefreshToken()

generateClaims()*/
