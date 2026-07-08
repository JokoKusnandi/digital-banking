package com.banking.common.security.principal;

import com.banking.common.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserPrincipal {

    private Long id;

    private String username;

    private String email;

    private Role role;

    private List<String> authorities;

}
