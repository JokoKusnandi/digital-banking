package com.banking.authservice.repository;

import com.banking.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String Email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String Email);
}
