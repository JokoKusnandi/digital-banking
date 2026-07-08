package com.banking.common.event.transfer;

import com.banking.common.event.base.BaseEvent;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferCompletedEvent extends BaseEvent {

    private Long transferId;

    private String referenceNumber;

    private BigDecimal amount;

}
