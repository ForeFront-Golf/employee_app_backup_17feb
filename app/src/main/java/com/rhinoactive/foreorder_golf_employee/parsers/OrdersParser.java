package com.rhinoactive.foreorder_golf_employee.parsers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.rhinoactive.foreorder_golf_employee.events.OrdersUpdatedEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.LocationApiManager;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.JsonArrayParser;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-02.
 */

public class OrdersParser extends JsonArrayParser<Order> {

    private List<MenuOrders> listOfMenuOrders;

    public OrdersParser(List<MenuOrders> listOfMenuOrders) {
        this.listOfMenuOrders = listOfMenuOrders;
    }

    public void handleError(Exception ex) {
        Timber.e(ex.getMessage());
    }

    @Override
    protected String getJsonKey() {
        return Constants.ORDER_TABLE;
    }

    @Override
    protected Order parseSingleElement(JsonElement orderElement, GsonBuilder builder) {
        Order order = builder.create().fromJson(orderElement, Order.class);
        addOrUpdateOrder(order);
        return order;
    }

    @Override
    protected void postSuccessfulParsingLogic(final List<Order> orders) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(orders);
                }
            });
        }
        notifyObservers();
    }

    private void addOrUpdateOrder(final Order newOrder) {
        if (!newOrder.getCurrentState().equals(Constants.COMPLETED)) {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        MenuOrders menuOrder = realm.where(MenuOrders.class).equalTo("menuOrdersId", newOrder.getMenuId()).findFirst();
                        boolean shouldAdd = true;
                        List<Order> refOrderList = menuOrder.getOrders();
                        for (int i = 0; i < refOrderList.size(); i++) {
                            if (refOrderList.get(i).getOrderId().equals(newOrder.getOrderId())) {
                                shouldAdd = false;
                            }
                        }
                        if (shouldAdd) {
                            menuOrder.getOrders().add(newOrder);
                        }
                    }
                });
            }
        }
    }

    private void notifyObservers() {
        //Update location of users when new orders come through
        Realm realm = Realm.getDefaultInstance();
        ClubMenus currentClubMenu = realm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(ForeOrderApp.getAppContext()))
                .findFirst();
        LocationApiManager.getLocationsOfUsersAtClub(currentClubMenu);
        realm.close();
        EventBus.getDefault().post(new OrdersUpdatedEvent());
    }
}
