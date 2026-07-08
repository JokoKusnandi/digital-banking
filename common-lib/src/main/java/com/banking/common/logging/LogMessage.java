package com.banking.common.logging;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage {

    private RequestLog request;

    private ResponseLog response;

}
