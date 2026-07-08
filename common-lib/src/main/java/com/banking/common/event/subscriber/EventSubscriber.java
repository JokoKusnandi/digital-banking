package com.banking.common.event.subscriber;

import com.banking.common.event.base.BaseEvent;

public interface EventSubscriber {

    void consume(BaseEvent event);

}
