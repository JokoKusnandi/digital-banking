package com.banking.common.security.jwt;

public final class JwtConstants {

    private JwtConstants(){}

    public static final String ISSUER = "DIGITAL-BANK";

    public static final String AUDIENCE = "DIGITAL-BANK-CLIENT";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER = "Authorization";

    public static final long ACCESS_TOKEN_EXPIRE = 15 * 60;

    public static final long REFRESH_TOKEN_EXPIRE = 7 * 24 * 60 * 60;

}
