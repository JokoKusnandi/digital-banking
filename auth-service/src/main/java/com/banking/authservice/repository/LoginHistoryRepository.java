package com.banking.authservice.repository;

import com.banking.authservice.entity.LoginHistory;
import com.banking.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, UUID> {

    List<LoginHistory> findByUserOrderByLoginTimeDesc(User user);

    List<LoginHistory> findByStatus(String status);
}
