package com.rhinoactive.foreorder_golf_employee.parsers;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.rhinoactive.foreorder_golf_employee.events.CompleteOrderEvent;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.jsonparsercallback.JsonObjectParser;

import org.greenrobot.eventbus.EventBus;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by sungwook on 2018-03-28.
 */

public class OrderCompleteParser extends JsonObjectParser<Order> {
    @Override
    public void handleError(Exception ex) {
        Timber.e(ex.getMessage());
        broadcastEvent(false);
    }

    @Override
    protected String getJsonKey() {
        return Constants.ORDER_TABLE;
    }

    @Override
    protected Order handleSuccessfulParse(JsonObject orderElement, GsonBuilder builder) {
        return builder.create().fromJson(orderElement, Order.class);
    }

    @Override
    protected void postSuccessfulParsingLogic(final Order order) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.where(Order.class).equalTo("orderId", order.getOrderId()).findFirst().deleteFromRealm();
                }
            });
        }

        broadcastEvent(true);
    }

    private void broadcastEvent(boolean successful) {
        EventBus.getDefault().post(new CompleteOrderEvent(successful));
    }
}
