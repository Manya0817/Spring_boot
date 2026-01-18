package com.maheshwari.manya.module1intoduction.impl;

import com.maheshwari.manya.module1intoduction.NotificationService;
import com.sun.nio.sctp.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsNotif")
//@ConditionalOnProperty(name="notification.type", havingValue ="sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sms sending ... "+message);
    }
}
