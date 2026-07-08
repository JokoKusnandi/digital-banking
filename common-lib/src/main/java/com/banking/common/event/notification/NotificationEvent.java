package com.banking.common.event.notification;

import com.banking.common.enums.NotificationType;
import com.banking.common.event.base.BaseEvent;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent extends BaseEvent {

    private Long userId;

    private String title;

    private String message;

    private NotificationType notificationType;

}
