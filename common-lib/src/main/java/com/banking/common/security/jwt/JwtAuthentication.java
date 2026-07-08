package com.banking.common.security.jwt;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtAuthentication {

    private String token;

    private JwtClaims claims;

}
