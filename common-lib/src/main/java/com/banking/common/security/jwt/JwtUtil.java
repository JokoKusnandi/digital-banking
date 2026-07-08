package com.banking.common.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtTokenGenerator generator;

    private final JwtTokenParser parser;

//    generateAccessToken()
//
//    generateRefreshToken()
//
//    parseClaims()
//
//    validate()
//
//    extractUsername()
//
//    extractRole()
//
//    extractExpiration()
//
//    isExpired()

}
