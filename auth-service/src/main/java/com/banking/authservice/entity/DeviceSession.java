package com.banking.authservice.entity;

import com.banking.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "device_sessions",
        schema = "user_db",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_device_sessions_user_device",
                        columnNames = {"user_id", "device_id"}
                )
        },
        indexes = {
                @Index(name = "idx_device_sessions_user", columnList = "user_id"),
                @Index(name = "idx_device_sessions_device", columnList = "device_id"),
                @Index(name = "idx_device_sessions_active", columnList = "active"),
                @Index(name = "idx_device_sessions_last_access", columnList = "last_access")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceSession extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "device_id", nullable = false, length = 255)
    private String deviceId;

    @Column(name = "refresh_token", nullable = false, length = 500)
    private String refreshToken;

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    @Column(name = "last_access", nullable = false)
    @Builder.Default
    private LocalDateTime lastAccess = LocalDateTime.now();

    @Column(length = 100)
    private String platform;
}
