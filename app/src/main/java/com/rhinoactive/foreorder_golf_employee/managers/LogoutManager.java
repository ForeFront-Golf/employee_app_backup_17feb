package com.rhinoactive.foreorder_golf_employee.managers;

import androidx.appcompat.app.AppCompatActivity;

import com.rhinoactive.foreorder_golf_employee.activities.LoginActivity;
import com.rhinoactive.foreorder_golf_employee.utils.OneSignalUtils;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAndAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;
import com.rhinodesktop.locationutilities.newlocationupdates.utils.LocationServiceUtils;

import io.realm.Realm;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class LogoutManager {

    public static void logout(AppCompatActivity activity) {
        LocationServiceUtils.getInstance().stopService(activity);
        OneSignalUtils.sendLogoutUserToOneSignal();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.deleteAll();
                }
            });
        }

        ActivityAndAnimateManager.Builder builder = new ActivityAndAnimateManager.Builder(activity, LoginActivity.class, AnimationType.FADE_IN);
        builder.clearStack();
        builder.buildActivityAndTransition();
    }
}
