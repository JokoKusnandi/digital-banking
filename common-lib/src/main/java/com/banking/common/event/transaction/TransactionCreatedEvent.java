package com.banking.common.event.transaction;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreatedEvent extends BaseEvent {

    private Long transactionId;

    private BigDecimal amount;

    private String accountNumber;

}
