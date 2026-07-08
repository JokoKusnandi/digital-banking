package com.banking.common.logging;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestLog {

    private String method;

    private String uri;

    private String ip;

    private String correlationId;

    private String traceId;

    private String username;

    private LocalDateTime requestTime;

}
