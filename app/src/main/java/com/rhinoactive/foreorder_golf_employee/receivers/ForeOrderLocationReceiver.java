package com.rhinoactive.foreorder_golf_employee.receivers;

import android.location.Location;

import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.LocationApiManager;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinodesktop.locationutilities.newlocationupdates.receivers.LocationReceiver;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by hunter on 2018-03-22.
 */

public class ForeOrderLocationReceiver extends LocationReceiver {

    @Override
    protected void handleNewLocation(final Location location) {
        Timber.d("Location updated. Lat: %f, Lon: %f", location.getLatitude(), location.getLongitude());
        try (Realm realm = Realm.getDefaultInstance()) {
            final User currentUser = realm.where(User.class).findFirst();
            if (currentUser != null) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        currentUser.setUserLocationF(location, realm);
                    }
                });
                LocationApiManager.updateCurrentUserLocationOnServer(currentUser);
                //This gets the new list of orders and in turn gets the locations for the users who have outstanding orders
                ClubMenus clubMenus = realm.where(ClubMenus.class)
                        .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(ForeOrderApp.getAppContext()))
                        .findFirst();
                if (clubMenus != null && clubMenus.getClub() != null) {
                    OrderApiManager.getOrdersForMenus(clubMenus);
                    LocationApiManager.getLocationsOfUsersAtClub(clubMenus);
                }
            }
        }
    }
}
