package com.banking.common.event.account;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent extends BaseEvent {

    private Long accountId;

    private String accountNumber;

    private Long customerId;

}
