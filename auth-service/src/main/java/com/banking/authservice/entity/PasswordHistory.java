package com.banking.authservice.entity;

import com.banking.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "password_history",
        schema = "user_db",
        indexes = {
                @Index(name = "idx_password_history_user", columnList = "user_id"),
                @Index(name = "idx_password_history_changed_date", columnList = "changed_date")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "changed_date", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime changedDate = LocalDateTime.now();
}
