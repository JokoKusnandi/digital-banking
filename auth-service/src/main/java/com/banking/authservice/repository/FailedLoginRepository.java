package com.banking.authservice.repository;

import com.banking.authservice.entity.FailedLogin;
import com.banking.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FailedLoginRepository extends JpaRepository<FailedLogin, UUID>{
    Optional<FailedLogin> findByUser(User user);

    Optional<FailedLogin> findByUserId(UUID userId);
}
