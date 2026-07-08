package com.banking.common.logging;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix="logging.app")
public class LoggingProperties {

    private boolean enabled=true;

    private boolean requestBody=false;

    private boolean responseBody=false;

}
