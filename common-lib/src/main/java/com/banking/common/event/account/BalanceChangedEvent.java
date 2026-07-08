package com.banking.common.event.account;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceChangedEvent extends BaseEvent {

    private Long accountId;

    private BigDecimal oldBalance;

    private BigDecimal newBalance;

}
