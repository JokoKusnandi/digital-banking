package com.banking.common.event.base;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventMetadata {

    private String eventId;

    private String correlationId;

    private String traceId;

    private String sourceService;

    private LocalDateTime createdDate;

    private EventStatus status;

}
