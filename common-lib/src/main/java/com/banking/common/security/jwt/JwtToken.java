package com.banking.common.security.jwt;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {

    private String accessToken;

    private String refreshToken;

    private LocalDateTime expiresAt;

}
