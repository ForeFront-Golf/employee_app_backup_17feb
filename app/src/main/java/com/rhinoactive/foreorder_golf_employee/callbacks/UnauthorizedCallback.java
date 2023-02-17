package com.rhinoactive.foreorder_golf_employee.callbacks;

import android.content.Intent;

import com.rhinoactive.foreorder_golf_employee.activities.LoginActivity;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderToastUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OneSignalUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinodesktop.locationutilities.newlocationupdates.utils.LocationServiceUtils;

import java.io.IOException;

import io.realm.Realm;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import timber.log.Timber;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

//TODO: use this callback for all api calls
public class UnauthorizedCallback implements Callback {

    public void handleFailure(Exception ex) {
        Timber.e(ex.getMessage());
    }

    @Override
    public void onFailure(Call call, IOException ex) {
        handleFailure(ex);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.code() == Constants.UNAUTHORIZED) {
            logOut();
        }
        response.body().close();
    }

    private void logOut() {
        LocationServiceUtils.getInstance().stopService(ForeOrderApp.getAppContext());
        OneSignalUtils.sendLogoutUserToOneSignal();

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.deleteAll();
                }
            });
        }

        ForeOrderToastUtils.getInstance().displayToastFromMainThreadLong(Constants.SESSION_EXPIRED);

        Intent intent = new Intent(ForeOrderApp.getAppContext(), LoginActivity.class);
        intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        ForeOrderApp.getAppContext().startActivity(intent);
    }
}
