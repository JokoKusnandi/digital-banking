package com.banking.common.event.payment;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCompletedEvent extends BaseEvent {

    private Long paymentId;

    private BigDecimal amount;

    private String biller;

}
