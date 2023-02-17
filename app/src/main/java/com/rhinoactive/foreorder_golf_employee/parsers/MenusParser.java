package com.rhinoactive.foreorder_golf_employee.parsers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.rhinoactive.foreorder_golf_employee.events.MenusDownloadedEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Menu;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.JsonArrayParser;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-04.
 */

public class MenusParser extends JsonArrayParser<Menu> {

    private ClubMenus clubMenus;

    public MenusParser(ClubMenus clubMenus) {
        this.clubMenus = clubMenus;
    }

    public void handleError(Exception ex) {
        Timber.e(ex.getMessage());
        notifyObservers();
    }

    @Override
    protected String getJsonKey() {
        return Constants.MENU_TABLE;
    }

    @Override
    protected Menu parseSingleElement(JsonElement menuElement, GsonBuilder builder) {
        Menu menu = builder.create().fromJson(menuElement, Menu.class);
        Realm realm = Realm.getDefaultInstance();
        ClubMenus currentClubMenus = realm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(ForeOrderApp.getAppContext()))
                .findFirst();
        addOrUpdateMenu(menu, currentClubMenus);
        realm.close();
        return menu;
    }

    @Override
    protected void postSuccessfulParsingLogic(List<Menu> menus) {
        saveToRealm(menus);
        notifyObservers();
        OrderApiManager.getOrdersForMenus(clubMenus);
    }

    private void saveToRealm(final List<Menu> menus) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(menus);
                }
            });
        }
    }

    private void addOrUpdateMenu(final Menu newMenu, final ClubMenus currentClubMenus) {
        final MenuOrders existingMenuOrders = OrderDataUtils.getExistingMenuOrders(currentClubMenus, newMenu);
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    if (existingMenuOrders != null) {
                        RealmList<Order> orders = existingMenuOrders.getOrders();
                        currentClubMenus.getListOfMenuOrders().remove(existingMenuOrders);
                        currentClubMenus.getListOfMenuOrders().add(new MenuOrders(newMenu, orders));
                    } else {
                        currentClubMenus.getListOfMenuOrders().add(new MenuOrders(newMenu));
                    }
                }
            });
        }
    }

    private void notifyObservers() {
        EventBus.getDefault().post(new MenusDownloadedEvent());
    }
}
