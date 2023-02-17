package com.rhinoactive.foreorder_golf_employee.utils;

import com.rhinoactive.foreorder_golf_employee.models.Order;

import java.util.Comparator;

/**
 * Created by sungwook on 2018-05-15.
 */

public class OrderComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderId().compareTo(o2.getOrderId());
    }
}
