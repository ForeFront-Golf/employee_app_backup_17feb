package com.rhinoactive.foreorder_golf_employee.handlers;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;
import com.rhinoactive.foreorder_golf_employee.events.NotificationReceivedEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by sungwook on 2018-05-15.
 */

public class OneSignalNotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
    @Override
    public void notificationReceived(OSNotification notification) {
        EventBus.getDefault().post(new NotificationReceivedEvent());
    }
}
