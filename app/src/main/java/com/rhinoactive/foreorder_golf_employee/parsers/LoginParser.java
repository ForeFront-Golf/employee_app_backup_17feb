package com.rhinoactive.foreorder_golf_employee.parsers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rhinoactive.foreorder_golf_employee.events.LoginEvent;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Session;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderToastUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OneSignalUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.StandardParser;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class LoginParser extends StandardParser {

    public void handleError(Exception ex) {
        Timber.e(ex.getMessage());
        handleError(Constants.ERROR_OCCURRED);
    }

    @Override
    protected void parseJsonData(JsonObject obj, GsonBuilder builder) {
        JsonObject usrObj = obj.getAsJsonObject(Constants.USER_TABLE);
        User user = builder.create().fromJson(usrObj, User.class);
        if (user != null) {
            handleSuccessfulLogin(user, obj, builder);
        } else {
            handleFailedLogin(obj, builder);
        }
    }

    @Override
    protected void errorParsingResponse(Exception ex) {
        handleError(ex);
    }

    @Override
    protected void requestFailed(Exception ex) {
        handleError(ex);
    }

    private void handleSuccessfulLogin(final User user, JsonObject obj, GsonBuilder builder) {
        final List<Club> clubs = getListOfEmployerClubs(obj, builder);
        if (clubs.size() > 0) {
            JsonObject sessionObj = obj.getAsJsonObject(Constants.SESSION_TABLE);
            final Session session = builder.create().fromJson(sessionObj, Session.class);
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.deleteAll();
                        realm.insert(user);
                        realm.insert(session);
                        realm.insert(clubs);
                        for (Club club : clubs) {
                            realm.insertOrUpdate(new ClubMenus(club));
                        }
                    }
                });
            }
            ForeOrderSharedPrefUtils.setCurrentUserId(ForeOrderApp.getAppContext(), user.getUserId());
            OneSignalUtils.sendUserEmailToOneSignal(user);
            broadcastLoginEvent(true);
        } else {
            userIsNotAnEmployee();
        }
    }

    private void handleFailedLogin(JsonObject obj, GsonBuilder builder) {
        Timber.e(obj.toString());
        Timber.e("Failed to log the user in.");
        handleError(Constants.LOGIN_FAILED);
    }

    private void userIsNotAnEmployee() {
        handleError(Constants.NO_PERMISSIONS);
    }

    private void handleError(String toastMsg) {
        ForeOrderToastUtils.getInstance().displayToastFromMainThreadLong(toastMsg);
        broadcastLoginEvent(false);
    }

    private List<Club> getListOfEmployerClubs(JsonObject obj, GsonBuilder builder) {
        List<Club> clubs = new ArrayList<>();
        JsonArray permissionsArray = obj.get(Constants.USER_TABLE).getAsJsonObject().get(Constants.PERMISSIONS).getAsJsonArray();
        for (JsonElement permissionJson : permissionsArray) {
            JsonObject clubJson = permissionJson.getAsJsonObject().get(Constants.CLUB_TABLE).getAsJsonObject();
            Club club = builder.create().fromJson(clubJson, Club.class);
            clubs.add(club);
        }
        return clubs;
    }

    private void broadcastLoginEvent(boolean successful) {
        EventBus.getDefault().post(new LoginEvent(successful));
    }
}
