package com.rhinoactive.foreorder_golf_employee.events;

import com.rhinoactive.foreorder_golf_employee.models.Order;

import lombok.Getter;

/**
 * Created by sungwook on 2018-04-18.
 */

public class ReceivedOrderEvent {

    @Getter
    private boolean successful;
    @Getter
    private Order order;

    public ReceivedOrderEvent(boolean successful, Order order) {
        this.successful = successful;
        this.order = order;
    }
}
