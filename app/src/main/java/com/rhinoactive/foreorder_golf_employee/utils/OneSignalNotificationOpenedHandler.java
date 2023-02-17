package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Intent;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;
import com.rhinoactive.foreorder_golf_employee.activities.LoginActivity;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sungwook on 2018-04-26.
 */

public class OneSignalNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
    @Override
    public void notificationOpened(OSNotificationOpenResult result) {
        JSONObject data = result.notification.payload.additionalData;
        JSONObject order = null;
        try {
            order = data.getJSONObject(Constants.ORDER_TABLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (order != null) {
            String clubId = order.optString(Constants.CLUB_ID);
            Intent intent = new Intent(ForeOrderApp.getAppContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Constants.CLUB_ID, clubId);
            ForeOrderApp.getAppContext().startActivity(intent);
        }
    }
}
