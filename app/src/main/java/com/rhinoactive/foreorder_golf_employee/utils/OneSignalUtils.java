package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;

import com.onesignal.OneSignal;
import com.rhinoactive.foreorder_golf_employee.handlers.OneSignalNotificationReceivedHandler;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Locale;

/**
 * Created by Hunter Andrin on 2017-08-22.
 */

public class OneSignalUtils {

    public static void initOneSignal(Context appContext) {
        OneSignal.startInit(appContext)
                .setNotificationReceivedHandler(new OneSignalNotificationReceivedHandler())
                .setNotificationOpenedHandler(new OneSignalNotificationOpenedHandler())
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }

    public static void sendUserEmailToOneSignal(User user) {
        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effectiveness of OneSignal's "best-time" notification scheduling feature.
        OneSignal.setEmail(user.getEmail());
        OneSignal.sendTag(Constants.EMAIL, user.getEmail());
        OneSignal.sendTag(Constants.EMPLOYEE, "true");
    }

    public static void sendClubToOneSignal(Club club) {
        OneSignal.sendTag(Constants.CLUB_ID, String.format(Locale.ENGLISH, "%d", club.getClubId()));
    }

    public static void sendLogoutUserToOneSignal() {
        OneSignal.sendTag(Constants.EMAIL, "");
        OneSignal.logoutEmail();
    }
}
