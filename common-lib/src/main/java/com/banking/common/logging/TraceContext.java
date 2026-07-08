package com.banking.common.logging;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraceContext {

    private String correlationId;

    private String traceId;

    private Long userId;

    private String username;

}
