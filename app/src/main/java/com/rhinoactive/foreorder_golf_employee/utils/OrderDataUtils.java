package com.rhinoactive.foreorder_golf_employee.utils;

import androidx.annotation.Nullable;

import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Menu;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hunter Andrin on 2017-05-03.
 */

public class OrderDataUtils {

    @Nullable
    public static MenuOrders getExistingMenuOrders(ClubMenus existingClubMenus, Menu newMenu) {
        MenuOrders existingMenuOrders = null;
        for (MenuOrders menuOrders : existingClubMenus.getListOfMenuOrders()) {
            if (menuOrders.getMenu().getMenuId().equals(newMenu.getMenuId())) {
                existingMenuOrders = menuOrders;
                break;
            }
        }
        return existingMenuOrders;
    }

    @Nullable
    public static Order getExistingOrder(List<Order> existingOrders, Order newOrder) {
        Order existingOrder = null;
        for (Order order : existingOrders) {
            if (order.getOrderId().equals(newOrder.getOrderId())) {
                existingOrder = order;
                break;
            }
        }
        return existingOrder;
    }

    public static long getLastModifiedMenuTime(List<MenuOrders> listOfMenuOrders) {
        long lastModifiedTime = 0;
        for (MenuOrders menuOrders : listOfMenuOrders) {
            if (menuOrders.getMenu().getModifiedAt() == null) {
                continue;
            }
            long orderModifiedTime = menuOrders.getMenu().getModifiedAt().getTime() / 1000; // Convert to seconds
            if (orderModifiedTime > lastModifiedTime) {
                lastModifiedTime = orderModifiedTime;
            }
        }
        return lastModifiedTime + 1; // Add 1 so we don't re-download the club with the current timestamp
    }

    public static long getLastModifiedOrderTime(List<MenuOrders> listOfMenuOrders) {
        long lastModifiedTime = 0;
        for (MenuOrders menuOrders : listOfMenuOrders) {
            for (Order order : menuOrders.getOrders()) {
                long orderModifiedTime = order.getModifiedAt().getTime() / 1000; // Convert to seconds
                if (orderModifiedTime > lastModifiedTime) {
                    lastModifiedTime = orderModifiedTime;
                }
            }
        }
        return lastModifiedTime + 1; // Add 1 so we don't re-download the club with the current timestamp
    }

    public static int getTimeSinceOrder(Order order) {
        long orderCreatedTime = order.getCreatedAt().getTime();
        long currentTime = new Date().getTime();
        return (int) (((currentTime - orderCreatedTime) / 1000) / 60); // Convert to minutes
    }

    public static boolean menusHaveOrders(List<MenuOrders> listOfMenuOrders) {
        boolean containsOrders = false;
        for (MenuOrders menuOrders : listOfMenuOrders) {
            if (menuOrders.getOrders().size() > 0) {
                containsOrders = true;
                break;
            }
        }
        return containsOrders;
    }

    @Nullable
    public static MenuOrders getMenuOrdersFromList(List<MenuOrders> menuOrdersList, Order order) {
        MenuOrders matchingMenuOrders = null;
        for (MenuOrders menuOrders : menuOrdersList) {
            if (order.getMenuId().equals(menuOrders.getMenu().getMenuId())) {
                matchingMenuOrders = menuOrders;
                break;
            }
        }
        return matchingMenuOrders;
    }

    public static List<MenuOrders> getSelectedMenus(ClubMenus clubMenus) {
        List<MenuOrders> selectedMenuOrders = new ArrayList<>();
        for (MenuOrders menuOrders : clubMenus.getListOfMenuOrders()) {
            if (menuOrders.getMenu().getSelected()) {
                selectedMenuOrders.add(menuOrders);
            }
        }
        return selectedMenuOrders;
    }
}
