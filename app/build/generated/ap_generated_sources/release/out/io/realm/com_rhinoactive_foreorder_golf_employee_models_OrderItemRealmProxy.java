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
public class com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.OrderItem
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface {

    static final class OrderItemColumnInfo extends ColumnInfo {
        long orderItemIdColKey;
        long menuItemIdColKey;
        long modifiedAtColKey;
        long orderIdColKey;
        long nameColKey;
        long orderOptionsColKey;
        long priceColKey;
        long specialRequestColKey;
        long quantityColKey;
        long validColKey;

        OrderItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("OrderItem");
            this.orderItemIdColKey = addColumnDetails("orderItemId", "orderItemId", objectSchemaInfo);
            this.menuItemIdColKey = addColumnDetails("menuItemId", "menuItemId", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
            this.orderIdColKey = addColumnDetails("orderId", "orderId", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.orderOptionsColKey = addColumnDetails("orderOptions", "orderOptions", objectSchemaInfo);
            this.priceColKey = addColumnDetails("price", "price", objectSchemaInfo);
            this.specialRequestColKey = addColumnDetails("specialRequest", "specialRequest", objectSchemaInfo);
            this.quantityColKey = addColumnDetails("quantity", "quantity", objectSchemaInfo);
            this.validColKey = addColumnDetails("valid", "valid", objectSchemaInfo);
        }

        OrderItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new OrderItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final OrderItemColumnInfo src = (OrderItemColumnInfo) rawSrc;
            final OrderItemColumnInfo dst = (OrderItemColumnInfo) rawDst;
            dst.orderItemIdColKey = src.orderItemIdColKey;
            dst.menuItemIdColKey = src.menuItemIdColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
            dst.orderIdColKey = src.orderIdColKey;
            dst.nameColKey = src.nameColKey;
            dst.orderOptionsColKey = src.orderOptionsColKey;
            dst.priceColKey = src.priceColKey;
            dst.specialRequestColKey = src.specialRequestColKey;
            dst.quantityColKey = src.quantityColKey;
            dst.validColKey = src.validColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private OrderItemColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.OrderItem> proxyState;
    private RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsRealmList;

    com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OrderItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.OrderItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$orderItemId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.orderItemIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.orderItemIdColKey);
    }

    @Override
    public void realmSet$orderItemId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'orderItemId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$menuItemId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.menuItemIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.menuItemIdColKey);
    }

    @Override
    public void realmSet$menuItemId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.menuItemIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.menuItemIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.menuItemIdColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.menuItemIdColKey, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.orderIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.orderIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.orderIdColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.orderIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    @Override
    public RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> realmGet$orderOptions() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (orderOptionsRealmList != null) {
            return orderOptionsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.orderOptionsColKey);
            orderOptionsRealmList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class, osList, proxyState.getRealm$realm());
            return orderOptionsRealmList;
        }
    }

    @Override
    public void realmSet$orderOptions(RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("orderOptions")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> original = value;
                value = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>();
                for (com.rhinoactive.foreorder_golf_employee.models.OrderOption item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.orderOptionsColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderOption linkedObject = value.get(i);
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
                com.rhinoactive.foreorder_golf_employee.models.OrderOption linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.priceColKey)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.priceColKey);
    }

    @Override
    public void realmSet$price(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.priceColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.priceColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.priceColKey);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.priceColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$specialRequest() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.specialRequestColKey);
    }

    @Override
    public void realmSet$specialRequest(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.specialRequestColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.specialRequestColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.specialRequestColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.specialRequestColKey, value);
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
    public Boolean realmGet$valid() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.validColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.validColKey);
    }

    @Override
    public void realmSet$valid(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.validColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.validColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.validColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.validColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "OrderItem", false, 10, 0);
        builder.addPersistedProperty(NO_ALIAS, "orderItemId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "menuItemId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "orderId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "orderOptions", RealmFieldType.LIST, "OrderOption");
        builder.addPersistedProperty(NO_ALIAS, "price", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "specialRequest", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "quantity", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "valid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static OrderItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new OrderItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "OrderItem";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "OrderItem";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.OrderItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.rhinoactive.foreorder_golf_employee.models.OrderItem obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
            OrderItemColumnInfo columnInfo = (OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
            long pkColumnKey = columnInfo.orderItemIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("orderItemId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("orderItemId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("orderOptions")) {
                excludeFields.add("orderOptions");
            }
            if (json.has("orderItemId")) {
                if (json.isNull("orderItemId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class, json.getInt("orderItemId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'orderItemId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) obj;
        if (json.has("menuItemId")) {
            if (json.isNull("menuItemId")) {
                objProxy.realmSet$menuItemId(null);
            } else {
                objProxy.realmSet$menuItemId((int) json.getInt("menuItemId"));
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
        if (json.has("orderId")) {
            if (json.isNull("orderId")) {
                objProxy.realmSet$orderId(null);
            } else {
                objProxy.realmSet$orderId((int) json.getInt("orderId"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("orderOptions")) {
            if (json.isNull("orderOptions")) {
                objProxy.realmSet$orderOptions(null);
            } else {
                objProxy.realmGet$orderOptions().clear();
                JSONArray array = json.getJSONArray("orderOptions");
                for (int i = 0; i < array.length(); i++) {
                    com.rhinoactive.foreorder_golf_employee.models.OrderOption item = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$orderOptions().add(item);
                }
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                objProxy.realmSet$price(null);
            } else {
                objProxy.realmSet$price((float) json.getDouble("price"));
            }
        }
        if (json.has("specialRequest")) {
            if (json.isNull("specialRequest")) {
                objProxy.realmSet$specialRequest(null);
            } else {
                objProxy.realmSet$specialRequest((String) json.getString("specialRequest"));
            }
        }
        if (json.has("quantity")) {
            if (json.isNull("quantity")) {
                objProxy.realmSet$quantity(null);
            } else {
                objProxy.realmSet$quantity((int) json.getInt("quantity"));
            }
        }
        if (json.has("valid")) {
            if (json.isNull("valid")) {
                objProxy.realmSet$valid(null);
            } else {
                objProxy.realmSet$valid((boolean) json.getBoolean("valid"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.OrderItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.OrderItem obj = new com.rhinoactive.foreorder_golf_employee.models.OrderItem();
        final com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("orderItemId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orderItemId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$orderItemId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("menuItemId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$menuItemId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$menuItemId(null);
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
            } else if (name.equals("orderId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$orderId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$orderId(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("orderOptions")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$orderOptions(null);
                } else {
                    objProxy.realmSet$orderOptions(new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rhinoactive.foreorder_golf_employee.models.OrderOption item = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$orderOptions().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("price")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$price((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$price(null);
                }
            } else if (name.equals("specialRequest")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$specialRequest((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$specialRequest(null);
                }
            } else if (name.equals("quantity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$quantity((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$quantity(null);
                }
            } else if (name.equals("valid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$valid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$valid(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'orderItemId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderItem copyOrUpdate(Realm realm, OrderItemColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.OrderItem realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
            long pkColumnKey = columnInfo.orderItemIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderItem copy(Realm realm, OrderItemColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.orderItemIdColKey, unmanagedSource.realmGet$orderItemId());
        builder.addInteger(columnInfo.menuItemIdColKey, unmanagedSource.realmGet$menuItemId());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());
        builder.addInteger(columnInfo.orderIdColKey, unmanagedSource.realmGet$orderId());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addFloat(columnInfo.priceColKey, unmanagedSource.realmGet$price());
        builder.addString(columnInfo.specialRequestColKey, unmanagedSource.realmGet$specialRequest());
        builder.addInteger(columnInfo.quantityColKey, unmanagedSource.realmGet$quantity());
        builder.addBoolean(columnInfo.validColKey, unmanagedSource.realmGet$valid());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsUnmanagedList = unmanagedSource.realmGet$orderOptions();
        if (orderOptionsUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsManagedList = managedCopy.realmGet$orderOptions();
            orderOptionsManagedList.clear();
            for (int i = 0; i < orderOptionsUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsUnmanagedItem = orderOptionsUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.OrderOption cacheorderOptions = (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cache.get(orderOptionsUnmanagedItem);
                if (cacheorderOptions != null) {
                    orderOptionsManagedList.add(cacheorderOptions);
                } else {
                    orderOptionsManagedList.add(com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class), orderOptionsUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.OrderItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long tableNativePtr = table.getNativePtr();
        OrderItemColumnInfo columnInfo = (OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long pkColumnKey = columnInfo.orderItemIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Number realmGet$menuItemId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$menuItemId();
        if (realmGet$menuItemId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.menuItemIdColKey, objKey, realmGet$menuItemId.longValue(), false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        Number realmGet$orderId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderId();
        if (realmGet$orderId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderIdColKey, objKey, realmGet$orderId.longValue(), false);
        }
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderOptions();
        if (orderOptionsList != null) {
            OsList orderOptionsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderOptionsColKey);
            for (com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem : orderOptionsList) {
                Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                if (cacheItemIndexorderOptions == null) {
                    cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insert(realm, orderOptionsItem, cache);
                }
                orderOptionsOsList.addRow(cacheItemIndexorderOptions);
            }
        }
        Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
        }
        String realmGet$specialRequest = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$specialRequest();
        if (realmGet$specialRequest != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.specialRequestColKey, objKey, realmGet$specialRequest, false);
        }
        Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$quantity();
        if (realmGet$quantity != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long tableNativePtr = table.getNativePtr();
        OrderItemColumnInfo columnInfo = (OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long pkColumnKey = columnInfo.orderItemIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.OrderItem object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.OrderItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Number realmGet$menuItemId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$menuItemId();
            if (realmGet$menuItemId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.menuItemIdColKey, objKey, realmGet$menuItemId.longValue(), false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
            Number realmGet$orderId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderId();
            if (realmGet$orderId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.orderIdColKey, objKey, realmGet$orderId.longValue(), false);
            }
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }

            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderOptions();
            if (orderOptionsList != null) {
                OsList orderOptionsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderOptionsColKey);
                for (com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem : orderOptionsList) {
                    Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                    if (cacheItemIndexorderOptions == null) {
                        cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insert(realm, orderOptionsItem, cache);
                    }
                    orderOptionsOsList.addRow(cacheItemIndexorderOptions);
                }
            }
            Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
            }
            String realmGet$specialRequest = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$specialRequest();
            if (realmGet$specialRequest != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.specialRequestColKey, objKey, realmGet$specialRequest, false);
            }
            Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$quantity();
            if (realmGet$quantity != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.OrderItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long tableNativePtr = table.getNativePtr();
        OrderItemColumnInfo columnInfo = (OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long pkColumnKey = columnInfo.orderItemIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
        }
        cache.put(object, objKey);
        Number realmGet$menuItemId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$menuItemId();
        if (realmGet$menuItemId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.menuItemIdColKey, objKey, realmGet$menuItemId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.menuItemIdColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        Number realmGet$orderId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderId();
        if (realmGet$orderId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderIdColKey, objKey, realmGet$orderId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.orderIdColKey, objKey, false);
        }
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }

        OsList orderOptionsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderOptionsColKey);
        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderOptions();
        if (orderOptionsList != null && orderOptionsList.size() == orderOptionsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = orderOptionsList.size();
            for (int i = 0; i < objectCount; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem = orderOptionsList.get(i);
                Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                if (cacheItemIndexorderOptions == null) {
                    cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, orderOptionsItem, cache);
                }
                orderOptionsOsList.setRow(i, cacheItemIndexorderOptions);
            }
        } else {
            orderOptionsOsList.removeAll();
            if (orderOptionsList != null) {
                for (com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem : orderOptionsList) {
                    Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                    if (cacheItemIndexorderOptions == null) {
                        cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, orderOptionsItem, cache);
                    }
                    orderOptionsOsList.addRow(cacheItemIndexorderOptions);
                }
            }
        }

        Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceColKey, objKey, false);
        }
        String realmGet$specialRequest = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$specialRequest();
        if (realmGet$specialRequest != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.specialRequestColKey, objKey, realmGet$specialRequest, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.specialRequestColKey, objKey, false);
        }
        Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$quantity();
        if (realmGet$quantity != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.quantityColKey, objKey, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long tableNativePtr = table.getNativePtr();
        OrderItemColumnInfo columnInfo = (OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        long pkColumnKey = columnInfo.orderItemIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.OrderItem object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.OrderItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderItemId());
            }
            cache.put(object, objKey);
            Number realmGet$menuItemId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$menuItemId();
            if (realmGet$menuItemId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.menuItemIdColKey, objKey, realmGet$menuItemId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.menuItemIdColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
            Number realmGet$orderId = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderId();
            if (realmGet$orderId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.orderIdColKey, objKey, realmGet$orderId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.orderIdColKey, objKey, false);
            }
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }

            OsList orderOptionsOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.orderOptionsColKey);
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsList = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$orderOptions();
            if (orderOptionsList != null && orderOptionsList.size() == orderOptionsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = orderOptionsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem = orderOptionsList.get(i);
                    Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                    if (cacheItemIndexorderOptions == null) {
                        cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, orderOptionsItem, cache);
                    }
                    orderOptionsOsList.setRow(i, cacheItemIndexorderOptions);
                }
            } else {
                orderOptionsOsList.removeAll();
                if (orderOptionsList != null) {
                    for (com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem : orderOptionsList) {
                        Long cacheItemIndexorderOptions = cache.get(orderOptionsItem);
                        if (cacheItemIndexorderOptions == null) {
                            cacheItemIndexorderOptions = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, orderOptionsItem, cache);
                        }
                        orderOptionsOsList.addRow(cacheItemIndexorderOptions);
                    }
                }
            }

            Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.priceColKey, objKey, false);
            }
            String realmGet$specialRequest = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$specialRequest();
            if (realmGet$specialRequest != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.specialRequestColKey, objKey, realmGet$specialRequest, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.specialRequestColKey, objKey, false);
            }
            Number realmGet$quantity = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$quantity();
            if (realmGet$quantity != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, realmGet$quantity.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.quantityColKey, objKey, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderItem createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.OrderItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.OrderItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.OrderItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.OrderItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$orderItemId(realmSource.realmGet$orderItemId());
        unmanagedCopy.realmSet$menuItemId(realmSource.realmGet$menuItemId());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());
        unmanagedCopy.realmSet$orderId(realmSource.realmGet$orderId());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());

        // Deep copy of orderOptions
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$orderOptions(null);
        } else {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> managedorderOptionsList = realmSource.realmGet$orderOptions();
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> unmanagedorderOptionsList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>();
            unmanagedCopy.realmSet$orderOptions(unmanagedorderOptionsList);
            int nextDepth = currentDepth + 1;
            int size = managedorderOptionsList.size();
            for (int i = 0; i < size; i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderOption item = com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createDetachedCopy(managedorderOptionsList.get(i), nextDepth, maxDepth, cache);
                unmanagedorderOptionsList.add(item);
            }
        }
        unmanagedCopy.realmSet$price(realmSource.realmGet$price());
        unmanagedCopy.realmSet$specialRequest(realmSource.realmGet$specialRequest());
        unmanagedCopy.realmSet$quantity(realmSource.realmGet$quantity());
        unmanagedCopy.realmSet$valid(realmSource.realmGet$valid());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.OrderItem update(Realm realm, OrderItemColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderItem realmObject, com.rhinoactive.foreorder_golf_employee.models.OrderItem newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.orderItemIdColKey, realmObjectSource.realmGet$orderItemId());
        builder.addInteger(columnInfo.menuItemIdColKey, realmObjectSource.realmGet$menuItemId());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());
        builder.addInteger(columnInfo.orderIdColKey, realmObjectSource.realmGet$orderId());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());

        RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsUnmanagedList = realmObjectSource.realmGet$orderOptions();
        if (orderOptionsUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption> orderOptionsManagedCopy = new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>();
            for (int i = 0; i < orderOptionsUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.OrderOption orderOptionsItem = orderOptionsUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.OrderOption cacheorderOptions = (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cache.get(orderOptionsItem);
                if (cacheorderOptions != null) {
                    orderOptionsManagedCopy.add(cacheorderOptions);
                } else {
                    orderOptionsManagedCopy.add(com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class), orderOptionsItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.orderOptionsColKey, orderOptionsManagedCopy);
        } else {
            builder.addObjectList(columnInfo.orderOptionsColKey, new RealmList<com.rhinoactive.foreorder_golf_employee.models.OrderOption>());
        }
        builder.addFloat(columnInfo.priceColKey, realmObjectSource.realmGet$price());
        builder.addString(columnInfo.specialRequestColKey, realmObjectSource.realmGet$specialRequest());
        builder.addInteger(columnInfo.quantityColKey, realmObjectSource.realmGet$quantity());
        builder.addBoolean(columnInfo.validColKey, realmObjectSource.realmGet$valid());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("OrderItem = proxy[");
        stringBuilder.append("{orderItemId:");
        stringBuilder.append(realmGet$orderItemId() != null ? realmGet$orderItemId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{menuItemId:");
        stringBuilder.append(realmGet$menuItemId() != null ? realmGet$menuItemId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orderId:");
        stringBuilder.append(realmGet$orderId() != null ? realmGet$orderId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orderOptions:");
        stringBuilder.append("RealmList<OrderOption>[").append(realmGet$orderOptions().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price() != null ? realmGet$price() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{specialRequest:");
        stringBuilder.append(realmGet$specialRequest() != null ? realmGet$specialRequest() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{quantity:");
        stringBuilder.append(realmGet$quantity() != null ? realmGet$quantity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valid:");
        stringBuilder.append(realmGet$valid() != null ? realmGet$valid() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy aOrderItem = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aOrderItem.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOrderItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aOrderItem.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
