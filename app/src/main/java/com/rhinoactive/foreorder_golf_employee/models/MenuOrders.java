package com.rhinoactive.foreorder_golf_employee.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-04.
 */

public class MenuOrders extends RealmObject {

    @PrimaryKey
    @Getter
    private Integer menuOrdersId;
    @Getter
    private Menu menu;
    @Getter
    private RealmList<Order> orders = new RealmList<>();

    //Realm requires a default public constructor
    public MenuOrders() {}

    public MenuOrders(Menu menu) {
        this.menuOrdersId = menu.getMenuId();
        this.menu = menu;
    }

    public MenuOrders(Menu menu, RealmList<Order> orders) {
        this.menuOrdersId = menu.getMenuId();
        this.menu = menu;
        this.orders = orders;
    }
}
