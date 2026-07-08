package com.banking.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {
    private UUID id;

    private String email;

    private String fullName;

    private String phoneNumber;

    private Set<String> roles;

    private String accessToken;

    private String refreshToken;

    private String tokenType;

}
