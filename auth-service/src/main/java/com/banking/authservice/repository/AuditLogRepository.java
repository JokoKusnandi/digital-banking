package com.banking.authservice.repository;

import com.banking.authservice.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {

    List<AuditLog> findByUserIdOrderByCreatedDateDesc(UUID userId);

    List<AuditLog> findByAction(String action);

}
