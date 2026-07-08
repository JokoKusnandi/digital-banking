package com.banking.authservice.repository;

import com.banking.authservice.entity.DeviceSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeviceSessionRepository
        extends JpaRepository<DeviceSession, UUID> {

    List<DeviceSession> findByUserId(UUID userId);

    List<DeviceSession> findByUserIdAndActiveTrue(UUID userId);

    Optional<DeviceSession> findByRefreshToken(String refreshToken);

    Optional<DeviceSession> findByUserIdAndDeviceId(UUID userId, String deviceId);

    void deleteByRefreshToken(String refreshToken);

    void deleteByUserId(UUID userId);
}