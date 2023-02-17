package com.rhinoactive.foreorder_golf_employee.managers.apimanagers;

import com.rhinoactive.foreorder_golf_employee.callbacks.LogoutCallback;
import com.rhinoactive.foreorder_golf_employee.callbacks.ValidateSessionCallback;
import com.rhinoactive.foreorder_golf_employee.parsers.LoginParser;
import com.rhinoactive.foreorder_golf_employee.utils.ApiRequests;
import com.rhinoactive.jsonparsercallback.StandardCallback;

import okhttp3.Call;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class AccountApiManager {

    public static void checkValidityOfCurrentSession() {
        ValidateSessionCallback validateSessionCallback = new ValidateSessionCallback();
        try {
            Call call = ApiRequests.getInstance().validateSession();
            call.enqueue(validateSessionCallback);
        } catch (Exception ex) {
            validateSessionCallback.handleFailure(ex);
        }
    }

    public static void invalidateCurrentUserSession(int userId) {
        LogoutCallback callback = new LogoutCallback();
        try {
            Call call = ApiRequests.getInstance().invalidateSession(userId);
            call.enqueue(callback);
        } catch (Exception ex) {
            callback.handleFailure(ex);
        }
    }

    public static void loginUser(String email, String password) {
        LoginParser loginParser = new LoginParser();
        try {
            StandardCallback callback = new StandardCallback(loginParser);
            Call call = ApiRequests.getInstance().login(email, password);
            call.enqueue(callback);
        } catch (Exception ex) {
            loginParser.handleError(ex);
        }
    }
}
