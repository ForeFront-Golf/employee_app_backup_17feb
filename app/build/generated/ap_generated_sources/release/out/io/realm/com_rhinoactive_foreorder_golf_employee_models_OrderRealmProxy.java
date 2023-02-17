package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.Order
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface {

    static final class OrderColumnInfo extends ColumnInfo {
        long orderIdColKey;
        long userColKey;
        long currentStateColKey;
        long orderNumColKey;
        long clubIdColKey;
        long menuIdColKey;
        long deliveryColKey;
        long fulfilledColKey;
        long priceTotalColKey;
        long priceTotalWithTaxColKey;
        long taxAmountColKey;
        long quantityColKey;
        long userIdColKey;
        long createdAtColKey;
        long modifiedAtColKey;
        long memberCodeColKey;
        long orderItemsColKey;

        OrderColumnInfo(OsSchemaInfo schemaInfo) {
            super(17);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Order");
            this.orderIdColKey = addColumnDetails("orderId", "orderId", objectSchemaInfo);
            this.userColKey = addColumnDetails("user", "user", objectSchemaInfo);
            this.currentStateColKey = addColumnDetails("currentState", "currentState", objectSchemaInfo);
            this.orderNumColKey = addColumnDetails("orderNum", "orderNum", objectSchemaInfo);
            this.clubIdColKey = addColumnDetails("clubId", "clubId", objectSchemaInfo);
            this.menuIdColKey = addColumnDetails("menuId", "menuId", objectSchemaInfo);
            this.deliveryColKey = addColumnDetails("delivery", "delivery", objectSchemaInfo);
            this.fulfilledColKey = addColumnDetails("fulfilled", "fulfilled", objectSchemaInfo);
            this.priceTotalColKey = addColumnDetails("priceTotal", "priceTotal", objectSchemaInfo);
            this.priceTotalWithTaxColKey = addColumnDetails("priceTotalWithTax", "priceTotalWithTax", objectSchemaInfo);
            this.taxAmountColKey = addColumnDetails("taxAmount", "taxAmount", objectSchemaInfo);
            this.quantityColKey = addColumnDetails("quantity", "quantity", objectSchemaInfo);
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.createdAtColKey = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
            this.memberCodeColKey = addColumnDetails("memberCode", "memberCode", objectSchemaInfo);
            this.orderItemsColKey = addColumnDetails("orderItems", "orderItems", objectSchemaInfo);
        }

        OrderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new OrderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final OrderColumnInfo src = (OrderColumnInfo) rawSrc;
            final OrderColumnInfo dst = (OrderColumnInfo) rawDst;
            dst.orderIdColKey = src.orderIdColKey;
            dst.userColKey = src.userColKey;
            dst.currentStateColKey = src.currentStateColKey;
            dst.orderNumColKey = src.orderNumColKey;
            dst.clubIdColKey = src.clubIdColKey;
            dst.menuIdColKey = src.menuIdColKey;
            dst.deliveryColKey = src.deliveryColKey;
            dst.fulfilledColKey = src.fulfilledColKey;
            dst.priceTotalColKey = src.priceTotalColKey;
            dst.priceTotalWithTaxColKey = src.priceTotalWithTaxColKey;
            dst.taxAmountColKey = src.taxAmountColKey;
            dst.quantityColKey = src.quantityColKey;
            dst.userIdColKey = src.userIdColKey;
            dst.createdAtColKey = src.createdAtColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
            dst.memberCodeColKey = src.memberCodeColKey;
            dst.orderItemsColKey = src.orderItemsColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private OrderColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.Order> proxyState;
    private RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsRealmList;

    com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OrderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.Order>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$orderId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.orderIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.orderIdColKey);
    }

    @Override
    public void realmSet$orderId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'orderId' cannot be changed after object was created.");
    }

    @Override
    public com.rhinoactive.foreorder_golf_employee.models.User realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.rhinoactive.foreorder_golf_employee.models.User.class, proxyState.getRow$realm().getLink(columnInfo.userColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$user(com.rhinoactive.foreorder_golf_employee.models.User value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("user")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$currentState() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.currentStateColKey);
    }

    @Override
    public void realmSet$currentState(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.currentStateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.currentStateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.currentStateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.currentStateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$orderNum() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.orderNumColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.orderNumColKey);
    }

    @Override
    public void realmSet$orderNum(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.orderNumColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.orderNumColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.orderNumColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.orderNumColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$clubId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.clubIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.clubIdColKey);
    }

    @Override
    public void realmSet$clubId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.clubIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.clubIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.clubIdColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.clubIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$menuId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.menuIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.menuIdColKey);
    }

    @Override
    public void realmSet$menuId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.menuIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.menuIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.menuIdColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.menuIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$delivery() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.deliveryColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.deliveryColKey);
    }

    @Override
    public void realmSet$delivery(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deliveryColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.deliveryColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deliveryColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.deliveryColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$fulfilled() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.fulfilledColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.fulfilledColKey);
    }

    @Override
    public void realmSet$fulfilled(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fulfilledColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.fulfilledColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fulfilledColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.fulfilledColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$priceTotal() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.priceTotalColKey)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.priceTotalColKey);
    }

    @Override
    public void realmSet$priceTotal(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.priceTotalColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.priceTotalColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.priceTotalColKey);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.priceTotalColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$priceTotalWithTax() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.priceTotalWithTaxColKey)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.priceTotalWithTaxColKey);
    }

    @Override
    public void realmSet$priceTotalWithTax(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.priceTotalWithTaxColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.priceTotalWithTaxColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.priceTotalWithTaxColKey);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.priceTotalWithTaxColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$taxAmount() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.taxAmountColKey)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.taxAmountColKey);
    }

    @Override
    public void realmSet$taxAmount(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.taxAmountColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.taxAmountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.taxAmountColKey);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.taxAmountColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$quantity() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.quantityColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.quantityColKey);
    }

    @Override
    public void realmSet$quantity(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.quantityColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.quantityColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.quantityColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.quantityColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.userIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.userIdColKey);
    }

    @Override
    public void realmSet$userId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.userIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.userIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.createdAtColKey)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.createdAtColKey);
    }

    @Override
    public void realmSet$createdAt(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDate(columnInfo.createdAtColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtColKey);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.createdAtColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$modifiedAt() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.modifiedAtColKey)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.modifiedAtColKey);
    }

    @Override
    public void realmSet$modifiedAt(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.modifiedAtColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDate(columnInfo.modifiedAtColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.modifiedAtColKey);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.modifiedAtColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$memberCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.memberCodeColKey);
    }

    @Override
    public void realmSet$memberCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.memberCodeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.memberCodeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.memberCodeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.memberCodeColKey, value);
    }

    @Override
    public RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> realmGet$orderItems() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (orderItemsRealmList != null) {
            return orderItemsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.orderItemsColKey);
            orderItemsRealmList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class, osList, proxyState.getRealm$realm());
            return orderItemsRealmList;
        }
    }

    @Override
    public void realmSet$orderItems(RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("orderItems")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> original = value;
                value = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>();
                for (com.rhinoactive.foreorder_golf_employee.models.OrderItem item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.orderItemsColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Order", false, 17, 0);
        builder.addPersistedProperty(NO_ALIAS, "orderId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "user", RealmFieldType.OBJECT, "User");
        builder.addPersistedProperty(NO_ALIAS, "currentState", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "orderNum", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "clubId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "menuId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "delivery", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "fulfilled", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "priceTotal", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "priceTotalWithTax", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "taxAmount", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "quantity", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "userId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "createdAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "memberCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "orderItems", RealmFieldType.LIST, "OrderItem");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static OrderColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new OrderColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Order";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Order";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.Order createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.rhinoactive.foreorder_golf_employee.models.Order obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
            OrderColumnInfo columnInfo = (OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
            long pkColumnKey = columnInfo.orderIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("orderId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("orderId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("user")) {
                excludeFields.add("user");
            }
            if (json.has("orderItems")) {
                excludeFields.add("orderItems");
            }
            if (json.has("orderId")) {
                if (json.isNull("orderId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Order.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Order.class, json.getInt("orderId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'orderId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) obj;
        if (json.has("user")) {
            if (json.isNull("user")) {
                objProxy.realmSet$user(null);
            } else {
                com.rhinoactive.foreorder_golf_employee.models.User userObj = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("user"), update);
                objProxy.realmSet$user(userObj);
            }
        }
        if (json.has("currentState")) {
            if (json.isNull("currentState")) {
                objProxy.realmSet$currentState(null);
            } else {
                objProxy.realmSet$currentState((String) json.getString("currentState"));
            }
        }
        if (json.has("orderNum")) {
            if (json.isNull("orderNum")) {
                objProxy.realmSet$orderNum(null);
            } else {
                objProxy.realmSet$orderNum((int) json.getInt("orderNum"));
            }
        }
        if (json.has("clubId")) {
            if (json.isNull("clubId")) {
                objProxy.realmSet$clubId(null);
            } else {
                objProxy.realmSet$clubId((int) json.getInt("clubId"));
            }
        }
        if (json.has("menuId")) {
            if (json.isNull("menuId")) {
                objProxy.realmSet$menuId(null);
            } else {
                objProxy.realmSet$menuId((int) json.getInt("menuId"));
            }
        }
        if (json.has("delivery")) {
            if (json.isNull("delivery")) {
                objProxy.realmSet$delivery(null);
            } else {
                objProxy.realmSet$delivery((boolean) json.getBoolean("delivery"));
            }
        }
        if (json.has("fulfilled")) {
            if (json.isNull("fulfilled")) {
                objProxy.realmSet$fulfilled(null);
            } else {
                objProxy.realmSet$fulfilled((boolean) json.getBoolean("fulfilled"));
            }
        }
        if (json.has("priceTotal")) {
            if (json.isNull("priceTotal")) {
                objProxy.realmSet$priceTotal(null);
            } else {
                objProxy.realmSet$priceTotal((float) json.getDouble("priceTotal"));
            }
        }
        if (json.has("priceTotalWithTax")) {
            if (json.isNull("priceTotalWithTax")) {
                objProxy.realmSet$priceTotalWithTax(null);
            } else {
                objProxy.realmSet$priceTotalWithTax((float) json.getDouble("priceTotalWithTax"));
            }
        }
        if (json.has("taxAmount")) {
            if (json.isNull("taxAmount")) {
                objProxy.realmSet$taxAmount(null);
            } else {
                objProxy.realmSet$taxAmount((float) json.getDouble("taxAmount"));
            }
        }
        if (json.has("quantity")) {
            if (json.isNull("quantity")) {
                objProxy.realmSet$quantity(null);
            } else {
                objProxy.realmSet$quantity((int) json.getInt("quantity"));
            }
        }
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((int) json.getInt("userId"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                objProxy.realmSet$createdAt(null);
            } else {
                Object timestamp = json.get("createdAt");
                if (timestamp instanceof String) {
                    objProxy.realmSet$createdAt(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$createdAt(new Date(json.getLong("createdAt")));
                }
            }
        }
        if (json.has("modifiedAt")) {
            if (json.isNull("modifiedAt")) {
                objProxy.realmSet$modifiedAt(null);
            } else {
                Object timestamp = json.get("modifiedAt");
                if (timestamp instanceof String) {
                    objProxy.realmSet$modifiedAt(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$modifiedAt(new Date(json.getLong("modifiedAt")));
                }
            }
        }
        if (json.has("memberCode")) {
            if (json.isNull("memberCode")) {
                objProxy.realmSet$memberCode(null);
            } else {
                objProxy.realmSet$memberCode((String) json.getString("memberCode"));
            }
        }
        if (json.has("orderItems")) {
            if (json.isNull("orderItems")) {
                objProxy.realmSet$orderItems(null);
            } else {
                objProxy.realmGet$orderItems().clear();
                JSONArray array = json.getJSONArray("orderItems");
                for (int i = 0; i < array.length(); i++) {
                    com.rhinoactive.foreorder_golf_employee.models.OrderItem item = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$orderItems().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.Order createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.Order obj = new com.rhinoactive.foreorder_golf_employee.models.Order();
        final com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("orderId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orderId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$orderId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.rhinoactive.foreorder_golf_employee.models.User userObj = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("currentState")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$currentState((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$currentState(null);
                }
            } else if (name.equals("orderNum")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orderNum((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$orderNum(null);
                }
            } else if (name.equals("clubId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clubId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clubId(null);
                }
            } else if (name.equals("menuId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$menuId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$menuId(null);
                }
            } else if (name.equals("delivery")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$delivery((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$delivery(null);
                }
            } else if (name.equals("fulfilled")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fulfilled((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fulfilled(null);
                }
            } else if (name.equals("priceTotal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$priceTotal((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$priceTotal(null);
                }
            } else if (name.equals("priceTotalWithTax")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$priceTotalWithTax((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$priceTotalWithTax(null);
                }
            } else if (name.equals("taxAmount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$taxAmount((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$taxAmount(null);
                }
            } else if (name.equals("quantity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$quantity((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$quantity(null);
                }
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$createdAt(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$createdAt(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$createdAt(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("modifiedAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$modifiedAt(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$modifiedAt(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$modifiedAt(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("memberCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$memberCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$memberCode(null);
                }
            } else if (name.equals("orderItems")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$orderItems(null);
                } else {
                    objProxy.realmSet$orderItems(new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rhinoactive.foreorder_golf_employee.models.OrderItem item = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$orderItems().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'orderId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Order copyOrUpdate(Realm realm, OrderColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Order object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.Order) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.Order realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
            long pkColumnKey = columnInfo.orderIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, value.longValue());
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Order copy(Realm realm, OrderColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Order newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.Order) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.orderIdColKey, unmanagedSource.realmGet$orderId());
        builder.addString(columnInfo.currentStateColKey, unmanagedSource.realmGet$currentState());
        builder.addInteger(columnInfo.orderNumColKey, unmanagedSource.realmGet$orderNum());
        builder.addInteger(columnInfo.clubIdColKey, unmanagedSource.realmGet$clubId());
        builder.addInteger(columnInfo.menuIdColKey, unmanagedSource.realmGet$menuId());
        builder.addBoolean(columnInfo.deliveryColKey, unmanagedSource.realmGet$delivery());
        builder.addBoolean(columnInfo.fulfilledColKey, unmanagedSource.realmGet$fulfilled());
        builder.addFloat(columnInfo.priceTotalColKey, unmanagedSource.realmGet$priceTotal());
        builder.addFloat(columnInfo.priceTotalWithTaxColKey, unmanagedSource.realmGet$priceTotalWithTax());
        builder.addFloat(columnInfo.taxAmountColKey, unmanagedSource.realmGet$taxAmount());
        builder.addInteger(columnInfo.quantityColKey, unmanagedSource.realmGet$quantity());
        builder.addInteger(columnInfo.userIdColKey, unmanagedSource.realmGet$userId());
        builder.addDate(columnInfo.createdAtColKey, unmanagedSource.realmGet$createdAt());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());
        builder.addString(columnInfo.memberCodeColKey, unmanagedSource.realmGet$memberCode());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.rhinoactive.foreorder_golf_employee.models.User userObj = unmanagedSource.realmGet$user();
        if (userObj == null) {
            managedCopy.realmSet$user(null);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.User cacheuser = (com.rhinoactive.foreorder_golf_employee.models.User) cache.get(userObj);
            if (cacheuser != null) {
                managedCopy.realmSet$user(cacheuser);
            } else {
                managedCopy.realmSet$user(com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class), userObj, update, cache, flags));
            }
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsUnmanagedList = unmanagedSource.realmGet$orderItems();
        if (orderItemsUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsManagedList = managedCopy.realmGet$orderItems();
            orderItemsManagedList.clear();
            for (int i = 0; i < orderItemsUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsUnmanagedItem = orderItemsUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.OrderItem cacheorderItems = (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cache.get(orderItemsUnmanagedItem);
                if (cacheorderItems != null) {
                    orderItemsManagedList.add(cacheorderItems);
                } else {
                    orderItemsManagedList.add(com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class), orderItemsUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Order object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long pkColumnKey = columnInfo.orderIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.User userObj = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userColKey, objKey, cacheuser, false);
        }
        String realmGet$currentState = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$currentState();
        if (realmGet$currentState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentStateColKey, objKey, realmGet$currentState, false);
        }
        Number realmGet$orderNum = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderNum();
        if (realmGet$orderNum != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderNumColKey, objKey, realmGet$orderNum.longValue(), false);
        }
        Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$clubId();
        if (realmGet$clubId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
        }
        Number realmGet$menuId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$menuId();
        if (realmGet$menuId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.menuIdColKey, objKey, realmGet$menuId.longValue(), false);
        }
        Boolean realmGet$delivery = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$delivery();
        if (realmGet$delivery != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveryColKey, objKey, realmGet$delivery, false);
        }
        Boolean realmGet$fulfilled = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$fulfilled();
        if (realmGet$fulfilled != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.fulfilledColKey, objKey, realmGet$fulfilled, false);
        }
        Float realmGet$priceTotal = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotal();
        if (realmGet$priceTotal != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalColKey, objKey, realmGet$priceTotal, false);
        }
        Float realmGet$priceTotalWithTax = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotalWithTax();
        if (realmGet$priceTotalWithTax != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, realmGet$priceTotalWithTax, false);
        }
        Float realmGet$taxAmount = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$taxAmount();
        if (realmGet$taxAmount != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.taxAmountColKey, objKey, realmGet$taxAmount, false);
        }
        Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$quantity();
        if (realmGet$quantity != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
        }
        Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
        }
        java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        String realmGet$memberCode = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$memberCode();
        if (realmGet$memberCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.memberCodeColKey, objKey, realmGet$memberCode, false);
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderItems();
        if (orderItemsList != null) {
            OsList orderItemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderItemsColKey);
            for (com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem : orderItemsList) {
                Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                if (cacheItemIndexorderItems == null) {
                    cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insert(realm, orderItemsItem, cache);
                }
                orderItemsOsList.addRow(cacheItemIndexorderItems);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long pkColumnKey = columnInfo.orderIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Order object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Order) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.User userObj = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insert(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userColKey, objKey, cacheuser, false);
            }
            String realmGet$currentState = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$currentState();
            if (realmGet$currentState != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentStateColKey, objKey, realmGet$currentState, false);
            }
            Number realmGet$orderNum = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderNum();
            if (realmGet$orderNum != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.orderNumColKey, objKey, realmGet$orderNum.longValue(), false);
            }
            Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$clubId();
            if (realmGet$clubId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
            }
            Number realmGet$menuId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$menuId();
            if (realmGet$menuId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.menuIdColKey, objKey, realmGet$menuId.longValue(), false);
            }
            Boolean realmGet$delivery = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$delivery();
            if (realmGet$delivery != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveryColKey, objKey, realmGet$delivery, false);
            }
            Boolean realmGet$fulfilled = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$fulfilled();
            if (realmGet$fulfilled != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.fulfilledColKey, objKey, realmGet$fulfilled, false);
            }
            Float realmGet$priceTotal = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotal();
            if (realmGet$priceTotal != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalColKey, objKey, realmGet$priceTotal, false);
            }
            Float realmGet$priceTotalWithTax = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotalWithTax();
            if (realmGet$priceTotalWithTax != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, realmGet$priceTotalWithTax, false);
            }
            Float realmGet$taxAmount = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$taxAmount();
            if (realmGet$taxAmount != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.taxAmountColKey, objKey, realmGet$taxAmount, false);
            }
            Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$quantity();
            if (realmGet$quantity != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
            }
            Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
            }
            java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
            String realmGet$memberCode = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$memberCode();
            if (realmGet$memberCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.memberCodeColKey, objKey, realmGet$memberCode, false);
            }

            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderItems();
            if (orderItemsList != null) {
                OsList orderItemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderItemsColKey);
                for (com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem : orderItemsList) {
                    Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                    if (cacheItemIndexorderItems == null) {
                        cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insert(realm, orderItemsItem, cache);
                    }
                    orderItemsOsList.addRow(cacheItemIndexorderItems);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Order object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long pkColumnKey = columnInfo.orderIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.User userObj = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userColKey, objKey, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userColKey, objKey);
        }
        String realmGet$currentState = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$currentState();
        if (realmGet$currentState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentStateColKey, objKey, realmGet$currentState, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.currentStateColKey, objKey, false);
        }
        Number realmGet$orderNum = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderNum();
        if (realmGet$orderNum != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderNumColKey, objKey, realmGet$orderNum.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.orderNumColKey, objKey, false);
        }
        Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$clubId();
        if (realmGet$clubId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clubIdColKey, objKey, false);
        }
        Number realmGet$menuId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$menuId();
        if (realmGet$menuId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.menuIdColKey, objKey, realmGet$menuId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.menuIdColKey, objKey, false);
        }
        Boolean realmGet$delivery = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$delivery();
        if (realmGet$delivery != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveryColKey, objKey, realmGet$delivery, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deliveryColKey, objKey, false);
        }
        Boolean realmGet$fulfilled = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$fulfilled();
        if (realmGet$fulfilled != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.fulfilledColKey, objKey, realmGet$fulfilled, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fulfilledColKey, objKey, false);
        }
        Float realmGet$priceTotal = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotal();
        if (realmGet$priceTotal != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalColKey, objKey, realmGet$priceTotal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceTotalColKey, objKey, false);
        }
        Float realmGet$priceTotalWithTax = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotalWithTax();
        if (realmGet$priceTotalWithTax != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, realmGet$priceTotalWithTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, false);
        }
        Float realmGet$taxAmount = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$taxAmount();
        if (realmGet$taxAmount != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.taxAmountColKey, objKey, realmGet$taxAmount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taxAmountColKey, objKey, false);
        }
        Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$quantity();
        if (realmGet$quantity != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.quantityColKey, objKey, false);
        }
        Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, objKey, false);
        }
        java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        String realmGet$memberCode = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$memberCode();
        if (realmGet$memberCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.memberCodeColKey, objKey, realmGet$memberCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.memberCodeColKey, objKey, false);
        }

        OsList orderItemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderItemsColKey);
        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderItems();
        if (orderItemsList != null && orderItemsList.size() == orderItemsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = orderItemsList.size();
            for (int i = 0; i < objectCount; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem = orderItemsList.get(i);
                Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                if (cacheItemIndexorderItems == null) {
                    cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, orderItemsItem, cache);
                }
                orderItemsOsList.setRow(i, cacheItemIndexorderItems);
            }
        } else {
            orderItemsOsList.removeAll();
            if (orderItemsList != null) {
                for (com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem : orderItemsList) {
                    Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                    if (cacheItemIndexorderItems == null) {
                        cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, orderItemsItem, cache);
                    }
                    orderItemsOsList.addRow(cacheItemIndexorderItems);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        long pkColumnKey = columnInfo.orderIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Order object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Order) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderId());
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.User userObj = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userColKey, objKey, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userColKey, objKey);
            }
            String realmGet$currentState = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$currentState();
            if (realmGet$currentState != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentStateColKey, objKey, realmGet$currentState, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.currentStateColKey, objKey, false);
            }
            Number realmGet$orderNum = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderNum();
            if (realmGet$orderNum != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.orderNumColKey, objKey, realmGet$orderNum.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.orderNumColKey, objKey, false);
            }
            Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$clubId();
            if (realmGet$clubId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.clubIdColKey, objKey, false);
            }
            Number realmGet$menuId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$menuId();
            if (realmGet$menuId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.menuIdColKey, objKey, realmGet$menuId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.menuIdColKey, objKey, false);
            }
            Boolean realmGet$delivery = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$delivery();
            if (realmGet$delivery != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.deliveryColKey, objKey, realmGet$delivery, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deliveryColKey, objKey, false);
            }
            Boolean realmGet$fulfilled = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$fulfilled();
            if (realmGet$fulfilled != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.fulfilledColKey, objKey, realmGet$fulfilled, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fulfilledColKey, objKey, false);
            }
            Float realmGet$priceTotal = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotal();
            if (realmGet$priceTotal != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalColKey, objKey, realmGet$priceTotal, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.priceTotalColKey, objKey, false);
            }
            Float realmGet$priceTotalWithTax = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$priceTotalWithTax();
            if (realmGet$priceTotalWithTax != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, realmGet$priceTotalWithTax, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.priceTotalWithTaxColKey, objKey, false);
            }
            Float realmGet$taxAmount = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$taxAmount();
            if (realmGet$taxAmount != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.taxAmountColKey, objKey, realmGet$taxAmount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.taxAmountColKey, objKey, false);
            }
            Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$quantity();
            if (realmGet$quantity != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.quantityColKey, objKey, false);
            }
            Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, objKey, false);
            }
            java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
            String realmGet$memberCode = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$memberCode();
            if (realmGet$memberCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.memberCodeColKey, objKey, realmGet$memberCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.memberCodeColKey, objKey, false);
            }

            OsList orderItemsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderItemsColKey);
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) object).realmGet$orderItems();
            if (orderItemsList != null && orderItemsList.size() == orderItemsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = orderItemsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem = orderItemsList.get(i);
                    Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                    if (cacheItemIndexorderItems == null) {
                        cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, orderItemsItem, cache);
                    }
                    orderItemsOsList.setRow(i, cacheItemIndexorderItems);
                }
            } else {
                orderItemsOsList.removeAll();
                if (orderItemsList != null) {
                    for (com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem : orderItemsList) {
                        Long cacheItemIndexorderItems = cache.get(orderItemsItem);
                        if (cacheItemIndexorderItems == null) {
                            cacheItemIndexorderItems = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, orderItemsItem, cache);
                        }
                        orderItemsOsList.addRow(cacheItemIndexorderItems);
                    }
                }
            }

        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Order createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.Order realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.Order unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.Order();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.Order) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.Order) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$orderId(realmSource.realmGet$orderId());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$currentState(realmSource.realmGet$currentState());
        unmanagedCopy.realmSet$orderNum(realmSource.realmGet$orderNum());
        unmanagedCopy.realmSet$clubId(realmSource.realmGet$clubId());
        unmanagedCopy.realmSet$menuId(realmSource.realmGet$menuId());
        unmanagedCopy.realmSet$delivery(realmSource.realmGet$delivery());
        unmanagedCopy.realmSet$fulfilled(realmSource.realmGet$fulfilled());
        unmanagedCopy.realmSet$priceTotal(realmSource.realmGet$priceTotal());
        unmanagedCopy.realmSet$priceTotalWithTax(realmSource.realmGet$priceTotalWithTax());
        unmanagedCopy.realmSet$taxAmount(realmSource.realmGet$taxAmount());
        unmanagedCopy.realmSet$quantity(realmSource.realmGet$quantity());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());
        unmanagedCopy.realmSet$memberCode(realmSource.realmGet$memberCode());

        // Deep copy of orderItems
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$orderItems(null);
        } else {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> managedorderItemsList = realmSource.realmGet$orderItems();
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> unmanagedorderItemsList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>();
            unmanagedCopy.realmSet$orderItems(unmanagedorderItemsList);
            int nextDepth = currentDepth + 1;
            int size = managedorderItemsList.size();
            for (int i = 0; i < size; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem item = com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createDetachedCopy(managedorderItemsList.get(i), nextDepth, maxDepth, cache);
                unmanagedorderItemsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.Order update(Realm realm, OrderColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Order realmObject, com.rhinoactive.foreorder_golf_employee.models.Order newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.orderIdColKey, realmObjectSource.realmGet$orderId());

        com.rhinoactive.foreorder_golf_employee.models.User userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            builder.addNull(columnInfo.userColKey);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.User cacheuser = (com.rhinoactive.foreorder_golf_employee.models.User) cache.get(userObj);
            if (cacheuser != null) {
                builder.addObject(columnInfo.userColKey, cacheuser);
            } else {
                builder.addObject(columnInfo.userColKey, com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class), userObj, true, cache, flags));
            }
        }
        builder.addString(columnInfo.currentStateColKey, realmObjectSource.realmGet$currentState());
        builder.addInteger(columnInfo.orderNumColKey, realmObjectSource.realmGet$orderNum());
        builder.addInteger(columnInfo.clubIdColKey, realmObjectSource.realmGet$clubId());
        builder.addInteger(columnInfo.menuIdColKey, realmObjectSource.realmGet$menuId());
        builder.addBoolean(columnInfo.deliveryColKey, realmObjectSource.realmGet$delivery());
        builder.addBoolean(columnInfo.fulfilledColKey, realmObjectSource.realmGet$fulfilled());
        builder.addFloat(columnInfo.priceTotalColKey, realmObjectSource.realmGet$priceTotal());
        builder.addFloat(columnInfo.priceTotalWithTaxColKey, realmObjectSource.realmGet$priceTotalWithTax());
        builder.addFloat(columnInfo.taxAmountColKey, realmObjectSource.realmGet$taxAmount());
        builder.addInteger(columnInfo.quantityColKey, realmObjectSource.realmGet$quantity());
        builder.addInteger(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addDate(columnInfo.createdAtColKey, realmObjectSource.realmGet$createdAt());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());
        builder.addString(columnInfo.memberCodeColKey, realmObjectSource.realmGet$memberCode());

        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsUnmanagedList = realmObjectSource.realmGet$orderItems();
        if (orderItemsUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem> orderItemsManagedCopy = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>();
            for (int i = 0; i < orderItemsUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderItem orderItemsItem = orderItemsUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.OrderItem cacheorderItems = (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cache.get(orderItemsItem);
                if (cacheorderItems != null) {
                    orderItemsManagedCopy.add(cacheorderItems);
                } else {
                    orderItemsManagedCopy.add(com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class), orderItemsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.orderItemsColKey, orderItemsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.orderItemsColKey, new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderItem>());
        }

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Order = proxy[");
        stringBuilder.append("{orderId:");
        stringBuilder.append(realmGet$orderId() != null ? realmGet$orderId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "User" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currentState:");
        stringBuilder.append(realmGet$currentState() != null ? realmGet$currentState() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orderNum:");
        stringBuilder.append(realmGet$orderNum() != null ? realmGet$orderNum() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clubId:");
        stringBuilder.append(realmGet$clubId() != null ? realmGet$clubId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{menuId:");
        stringBuilder.append(realmGet$menuId() != null ? realmGet$menuId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{delivery:");
        stringBuilder.append(realmGet$delivery() != null ? realmGet$delivery() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fulfilled:");
        stringBuilder.append(realmGet$fulfilled() != null ? realmGet$fulfilled() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{priceTotal:");
        stringBuilder.append(realmGet$priceTotal() != null ? realmGet$priceTotal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{priceTotalWithTax:");
        stringBuilder.append(realmGet$priceTotalWithTax() != null ? realmGet$priceTotalWithTax() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taxAmount:");
        stringBuilder.append(realmGet$taxAmount() != null ? realmGet$taxAmount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{quantity:");
        stringBuilder.append(realmGet$quantity() != null ? realmGet$quantity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{memberCode:");
        stringBuilder.append(realmGet$memberCode() != null ? realmGet$memberCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orderItems:");
        stringBuilder.append("RealmList<OrderItem>[").append(realmGet$orderItems().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy aOrder = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aOrder.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOrder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aOrder.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
