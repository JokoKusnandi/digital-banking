package com.banking.common.security.jwt;

import com.banking.common.enums.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtClaims {

    private Long userId;

    private String username;

    private String email;

    private Role role;

    private List<String> permissions;

    private String deviceId;

    private String sessionId;

    private Integer tokenVersion;

    private String ipAddress;

}
