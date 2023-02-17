package com.rhinoactive.foreorder_golf_employee.models;

import com.rhinoactive.foreorder_library_android.utils.Constants;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class ClubMenus extends RealmObject {

    @PrimaryKey
    @Getter
    private Integer clubMenusId;
    @Getter
    private Club club;
    @Getter
    private RealmList<MenuOrders> listOfMenuOrders = new RealmList<>();

    //Realm requires a default public constructor
    public ClubMenus() {}

    public ClubMenus(Club club) {
        this.clubMenusId = club.getClubId();
        this.club = club;
    }

    public void removeOrderFromCurrentClubMenu(Order orderToRemove) {
        for (MenuOrders menuOrders : listOfMenuOrders) {
            if (orderToRemove.getMenuId().equals(menuOrders.getMenu().getMenuId())) {
                removeOrderFromMenuOrder(menuOrders, orderToRemove);
                break;
            }
        }
    }

    public void updateOrderFromCurrentClubMenu(Order orderToUpdate) {
        for (MenuOrders menuOrders : listOfMenuOrders) {
            if (orderToUpdate.getMenuId().equals(menuOrders.getMenu().getMenuId())) {
                updateOrderFromMenuOrder(menuOrders, orderToUpdate);
                break;
            }
        }
    }

    private void updateOrderFromMenuOrder(MenuOrders menuOrders, Order orderToUpdate) {
        int indexOfOrder = -1;
        Order matchingOrder = null;
        for (Order order : menuOrders.getOrders()) {
            if (order.getOrderId().equals(orderToUpdate.getOrderId())) {
                matchingOrder = order;
                indexOfOrder = menuOrders.getOrders().indexOf(order);
                break;
            }
        }
        if (matchingOrder != null && indexOfOrder != -1) {
            matchingOrder.setCurrentState(Constants.RECEIVED);
            menuOrders.getOrders().set(indexOfOrder, matchingOrder);
        }
    }

    private void removeOrderFromMenuOrder(MenuOrders menuOrders, Order orderToRemove) {
        Order matchingOrder = null;
        for (Order order : menuOrders.getOrders()) {
            if (order.getOrderId().equals(orderToRemove.getOrderId())) {
                matchingOrder = order;
                break;
            }
        }
        if (matchingOrder != null) {
            menuOrders.getOrders().remove(matchingOrder);
        }
    }
}
