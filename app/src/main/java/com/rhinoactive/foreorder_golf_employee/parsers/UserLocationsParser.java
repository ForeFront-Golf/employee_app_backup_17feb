package com.rhinoactive.foreorder_golf_employee.parsers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.rhinoactive.foreorder_golf_employee.events.UserLocationsUpdateEvent;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.models.UserLocation;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.JsonArrayParser;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

public class UserLocationsParser extends JsonArrayParser<UserLocation> {

    private List<MenuOrders> menuOrdersList;

    public UserLocationsParser(List<MenuOrders> menuOrdersList) {
        this.menuOrdersList = menuOrdersList;
    }

    public void handleError(Exception ex) {
        Timber.e(ex.getMessage());
    }

    @Override
    protected String getJsonKey() {
        return Constants.USER_LOCATION_TABLE;
    }

    @Override
    protected UserLocation parseSingleElement(JsonElement userLocationElement, GsonBuilder builder) {
        UserLocation userLocation = builder.create().fromJson(userLocationElement, UserLocation.class);
        updateUserLocation(userLocation);
        return userLocation;
    }

    @Override
    protected void postSuccessfulParsingLogic(List<UserLocation> parsedObject) {
        Timber.d("User locations downloaded");
        notifyObservers();
    }

    private void updateUserLocation(UserLocation userLocation) {
        for (MenuOrders menuOrders : menuOrdersList) {
            for (Order order : menuOrders.getOrders()) {
                if (order.getUser().getUserId().equals(userLocation.getUserId())) {
                    order.getUser().setUserLocationF(userLocation, null);
                }
            }
        }
    }

    private void notifyObservers() {
        EventBus.getDefault().post(new UserLocationsUpdateEvent(menuOrdersList));
    }
}
