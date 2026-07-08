package com.banking.common.logging;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLog {

    private Integer status;

    private Long executionTime;

    private LocalDateTime responseTime;

}
