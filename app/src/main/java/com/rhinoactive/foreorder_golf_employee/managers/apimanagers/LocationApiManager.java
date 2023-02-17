package com.rhinoactive.foreorder_golf_employee.managers.apimanagers;

import com.rhinoactive.foreorder_golf_employee.callbacks.NoContentCallback;
import com.rhinoactive.foreorder_golf_employee.callbacks.UnauthorizedCallback;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.parsers.UserLocationsParser;
import com.rhinoactive.foreorder_golf_employee.utils.ApiRequests;
import com.rhinoactive.jsonparsercallback.StandardCallback;

import java.util.List;

import io.realm.Realm;
import okhttp3.Call;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

public class LocationApiManager {

    public static void updateCurrentUserLocationOnServer(User user) {
        UnauthorizedCallback callback = new UnauthorizedCallback();
        try {
            Call call = ApiRequests.getInstance().updateCurrentUserLocation(user);
            call.enqueue(callback);
        } catch (Exception ex) {
            callback.handleFailure(ex);
        }
    }

    public static void getLocationsOfUsersAtClub(ClubMenus clubMenus) {
        Realm realm = Realm.getDefaultInstance();
        ClubMenus clubMenu = realm.copyFromRealm(clubMenus);
        realm.close();
        List<MenuOrders> menuOrdersList = clubMenu.getListOfMenuOrders();
        UserLocationsParser userLocationsParser = new UserLocationsParser(menuOrdersList);
        try {
            StandardCallback callback = new NoContentCallback(userLocationsParser);
            Call call = ApiRequests.getInstance().getUserLocations(clubMenu);
            call.enqueue(callback);
        } catch (Exception ex) {
            userLocationsParser.handleError(ex);
        }
    }
}
