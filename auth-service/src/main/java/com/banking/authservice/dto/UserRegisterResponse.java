package com.banking.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {
    private UUID id;
    private String email;
    private String fullName;
    private String phoneNumber;
    private Set<String> roles;
    private LocalDateTime createdAt;
}
