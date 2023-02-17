package com.rhinoactive.foreorder_golf_employee.callbacks;

import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.StandardCallback;
import com.rhinoactive.jsonparsercallback.StandardParser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import timber.log.Timber;

/**
 * Created by hunter on 2018-03-12.
 */

public class NoContentCallback extends StandardCallback {

    public NoContentCallback(StandardParser parser) {
        super(parser);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.code() == Constants.NO_CONTENT) {
            Timber.d("No Content available from the server.");
        } else {
            super.onResponse(call, response);
        }
    }
}
