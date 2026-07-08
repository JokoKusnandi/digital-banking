package com.banking.authservice.repository;

import com.banking.authservice.entity.PasswordHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, UUID> {

    List<PasswordHistory> findTop5ByUserIdOrderByChangedDateDesc(UUID userId);

    void deleteByUserId(UUID userId);
}
