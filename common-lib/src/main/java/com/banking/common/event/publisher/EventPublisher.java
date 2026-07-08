package com.banking.common.event.publisher;

import com.banking.common.event.base.BaseEvent;

public interface EventPublisher {

    void publish(BaseEvent event);

}
