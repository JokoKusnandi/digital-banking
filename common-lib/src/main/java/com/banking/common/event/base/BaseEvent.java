package com.banking.common.event.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEvent {

    private EventType type;

    private EventMetadata metadata;

}
