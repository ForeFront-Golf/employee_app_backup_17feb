package com.rhinoactive.foreorder_golf_employee.callbacks;

import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderToastUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class LogoutCallback implements Callback {

    public void handleFailure(Exception ex) {
        Timber.e(ex.getMessage());
        ForeOrderToastUtils.getInstance().displayToastFromMainThreadLong(Constants.ERROR_OCCURRED);
    }

    @Override
    public void onFailure(Call call, IOException ex) {
        handleFailure(ex);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.code() == 200) {

        }
        response.body().close();
    }
}