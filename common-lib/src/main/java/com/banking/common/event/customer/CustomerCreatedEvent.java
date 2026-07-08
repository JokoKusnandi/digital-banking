package com.banking.common.event.customer;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreatedEvent extends BaseEvent {

    private Long customerId;

    private String cif;

    private String fullName;

}
