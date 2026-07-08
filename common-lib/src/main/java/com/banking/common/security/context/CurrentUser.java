package com.banking.common.security.context;

import com.banking.common.security.principal.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentUser {

    private CurrentUser(){}

    public static UserPrincipal get(){

        Authentication auth =

                SecurityContextHolder

                        .getContext()

                        .getAuthentication();

        return (UserPrincipal) auth.getPrincipal();

    }

}
