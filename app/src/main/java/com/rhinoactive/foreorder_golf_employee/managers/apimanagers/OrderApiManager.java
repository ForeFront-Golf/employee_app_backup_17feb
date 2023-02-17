package com.rhinoactive.foreorder_golf_employee.managers.apimanagers;

import com.rhinoactive.foreorder_golf_employee.callbacks.NoContentCallback;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.parsers.MenusParser;
import com.rhinoactive.foreorder_golf_employee.parsers.OrderCompleteParser;
import com.rhinoactive.foreorder_golf_employee.parsers.OrderReceivedParser;
import com.rhinoactive.foreorder_golf_employee.parsers.OrdersParser;
import com.rhinoactive.foreorder_golf_employee.utils.ApiRequests;
import com.rhinoactive.jsonparsercallback.StandardCallback;

import java.util.List;

import io.realm.Realm;
import okhttp3.Call;
import okhttp3.Callback;

/**
 * Created by Hunter Andrin on 2017-05-02.
 */

public class OrderApiManager {

    public static void getMenusForCurrentClub(int id) {
        Realm realm = Realm.getDefaultInstance();
        ClubMenus currentClubMenus = realm.where(ClubMenus.class)
                .equalTo("clubMenusId", id)
                .findFirst();
        ClubMenus clubMenus = realm.copyFromRealm(currentClubMenus);
        MenusParser menusParser = new MenusParser(clubMenus);
        try {
            Callback callback = new NoContentCallback(menusParser);
            Call call = ApiRequests.getInstance().getMenusForClub(currentClubMenus);
            call.enqueue(callback);
        } catch (Exception ex) {
            menusParser.handleError(ex);
        }
        realm.close();
    }

    public static void getOrdersForMenus(ClubMenus clubMenus) {
        Realm realm = Realm.getDefaultInstance();
        List<MenuOrders> listOfMenuOrders = clubMenus.getListOfMenuOrders();
        OrdersParser ordersParser = new OrdersParser(listOfMenuOrders);
        try {
            int clubId = clubMenus.getClub().getClubId();
            Callback callback = new NoContentCallback(ordersParser);
            Call call = ApiRequests.getInstance().getOrdersForMenus(clubId, listOfMenuOrders);
            call.enqueue(callback);
        } catch (Exception ex) {
            ordersParser.handleError(ex);
        }
        realm.close();
    }

    public static void markOrderComplete(Order order) {
        OrderCompleteParser orderCompleteParser = new OrderCompleteParser();
        try {
            StandardCallback callback = new StandardCallback(orderCompleteParser);
            Call call = ApiRequests.getInstance().markOrderComplete(order);
            call.enqueue(callback);
        } catch (Exception ex) {
            orderCompleteParser.handleError(ex);
        }
    }

    public static void markOrderReceived(Order order) {
        OrderReceivedParser orderReceivedParser = new OrderReceivedParser();
        try {
            StandardCallback callback = new StandardCallback(orderReceivedParser);
            Call call = ApiRequests.getInstance().markOrderReceived(order);
            call.enqueue(callback);
        } catch (Exception ex) {
            orderReceivedParser.handleError(ex);
        }
    }
}
