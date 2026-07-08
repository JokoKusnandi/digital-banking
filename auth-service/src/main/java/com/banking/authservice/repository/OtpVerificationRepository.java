package com.banking.authservice.repository;

import com.banking.authservice.entity.OtpPurpose;
import com.banking.authservice.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OtpVerificationRepository
        extends JpaRepository<OtpVerification, UUID> {

    Optional<OtpVerification> findTopByUserIdAndPurposeAndVerifiedFalseOrderByExpiredAtDesc(
            UUID userId,
            OtpPurpose purpose
    );

    List<OtpVerification> findByUserId(UUID userId);

    void deleteByUserId(UUID userId);
}
