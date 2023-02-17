package com.rhinoactive.foreorder_golf_employee.events;

import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;

import java.util.List;

import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-11.
 */

public class UserLocationsUpdateEvent {
    @Getter
    private List<MenuOrders> menuOrdersList;

    public UserLocationsUpdateEvent(List<MenuOrders> menuOrdersList) {
        this.menuOrdersList = menuOrdersList;
    }
}
