package com.banking.common.event.audit;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditEvent extends BaseEvent {

    private Long userId;

    private String username;

    private String action;

    private String description;

}
