package com.banking.common.security.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordUtil {

    private static final BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();

    private PasswordUtil(){}

    public static String encode(String password){

        return encoder.encode(password);

    }

    public static boolean matches(

            String raw,

            String encoded){

        return encoder.matches(raw,encoded);

    }

}
