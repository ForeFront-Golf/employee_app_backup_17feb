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
public class com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.OrderOption
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface {

    static final class OrderOptionColumnInfo extends ColumnInfo {
        long optionItemIdColKey;
        long optionGroupIdColKey;
        long availableColKey;
        long descColKey;
        long nameColKey;
        long priceColKey;
        long validColKey;
        long modifiedAtColKey;

        OrderOptionColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("OrderOption");
            this.optionItemIdColKey = addColumnDetails("optionItemId", "optionItemId", objectSchemaInfo);
            this.optionGroupIdColKey = addColumnDetails("optionGroupId", "optionGroupId", objectSchemaInfo);
            this.availableColKey = addColumnDetails("available", "available", objectSchemaInfo);
            this.descColKey = addColumnDetails("desc", "desc", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.priceColKey = addColumnDetails("price", "price", objectSchemaInfo);
            this.validColKey = addColumnDetails("valid", "valid", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
        }

        OrderOptionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new OrderOptionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final OrderOptionColumnInfo src = (OrderOptionColumnInfo) rawSrc;
            final OrderOptionColumnInfo dst = (OrderOptionColumnInfo) rawDst;
            dst.optionItemIdColKey = src.optionItemIdColKey;
            dst.optionGroupIdColKey = src.optionGroupIdColKey;
            dst.availableColKey = src.availableColKey;
            dst.descColKey = src.descColKey;
            dst.nameColKey = src.nameColKey;
            dst.priceColKey = src.priceColKey;
            dst.validColKey = src.validColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private OrderOptionColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.OrderOption> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OrderOptionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.OrderOption>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$optionItemId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.optionItemIdColKey);
    }

    @Override
    public void realmSet$optionItemId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'optionItemId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$optionGroupId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.optionGroupIdColKey);
    }

    @Override
    public void realmSet$optionGroupId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.optionGroupIdColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.optionGroupIdColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.optionGroupIdColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.optionGroupIdColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$available() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.availableColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.availableColKey);
    }

    @Override
    public void realmSet$available(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.availableColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.availableColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.availableColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.availableColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$desc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descColKey);
    }

    @Override
    public void realmSet$desc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.descColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descColKey, value);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "OrderOption", false, 8, 0);
        builder.addPersistedProperty(NO_ALIAS, "optionItemId", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "optionGroupId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "available", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "desc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "price", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "valid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static OrderOptionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new OrderOptionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "OrderOption";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "OrderOption";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.OrderOption createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rhinoactive.foreorder_golf_employee.models.OrderOption obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
            OrderOptionColumnInfo columnInfo = (OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
            long pkColumnKey = columnInfo.optionItemIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("optionItemId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("optionItemId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("optionItemId")) {
                if (json.isNull("optionItemId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class, json.getString("optionItemId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'optionItemId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) obj;
        if (json.has("optionGroupId")) {
            if (json.isNull("optionGroupId")) {
                objProxy.realmSet$optionGroupId(null);
            } else {
                objProxy.realmSet$optionGroupId((String) json.getString("optionGroupId"));
            }
        }
        if (json.has("available")) {
            if (json.isNull("available")) {
                objProxy.realmSet$available(null);
            } else {
                objProxy.realmSet$available((boolean) json.getBoolean("available"));
            }
        }
        if (json.has("desc")) {
            if (json.isNull("desc")) {
                objProxy.realmSet$desc(null);
            } else {
                objProxy.realmSet$desc((String) json.getString("desc"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                objProxy.realmSet$price(null);
            } else {
                objProxy.realmSet$price((float) json.getDouble("price"));
            }
        }
        if (json.has("valid")) {
            if (json.isNull("valid")) {
                objProxy.realmSet$valid(null);
            } else {
                objProxy.realmSet$valid((boolean) json.getBoolean("valid"));
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.OrderOption createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.OrderOption obj = new com.rhinoactive.foreorder_golf_employee.models.OrderOption();
        final com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("optionItemId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$optionItemId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$optionItemId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("optionGroupId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$optionGroupId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$optionGroupId(null);
                }
            } else if (name.equals("available")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$available((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$available(null);
                }
            } else if (name.equals("desc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$desc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$desc(null);
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("price")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$price((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$price(null);
                }
            } else if (name.equals("valid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$valid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$valid(null);
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'optionItemId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderOption copyOrUpdate(Realm realm, OrderOptionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderOption object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.OrderOption realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
            long pkColumnKey = columnInfo.optionItemIdColKey;
            String value = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionItemId();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderOption copy(Realm realm, OrderOptionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderOption newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.optionItemIdColKey, unmanagedSource.realmGet$optionItemId());
        builder.addString(columnInfo.optionGroupIdColKey, unmanagedSource.realmGet$optionGroupId());
        builder.addBoolean(columnInfo.availableColKey, unmanagedSource.realmGet$available());
        builder.addString(columnInfo.descColKey, unmanagedSource.realmGet$desc());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addFloat(columnInfo.priceColKey, unmanagedSource.realmGet$price());
        builder.addBoolean(columnInfo.validColKey, unmanagedSource.realmGet$valid());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.OrderOption object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long tableNativePtr = table.getNativePtr();
        OrderOptionColumnInfo columnInfo = (OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long pkColumnKey = columnInfo.optionItemIdColKey;
        String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionItemId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$optionGroupId = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionGroupId();
        if (realmGet$optionGroupId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, realmGet$optionGroupId, false);
        }
        Boolean realmGet$available = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$available();
        if (realmGet$available != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.availableColKey, objKey, realmGet$available, false);
        }
        String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
        }
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long tableNativePtr = table.getNativePtr();
        OrderOptionColumnInfo columnInfo = (OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long pkColumnKey = columnInfo.optionItemIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.OrderOption object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.OrderOption) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionItemId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$optionGroupId = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionGroupId();
            if (realmGet$optionGroupId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, realmGet$optionGroupId, false);
            }
            Boolean realmGet$available = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$available();
            if (realmGet$available != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.availableColKey, objKey, realmGet$available, false);
            }
            String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
            }
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
            Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.OrderOption object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long tableNativePtr = table.getNativePtr();
        OrderOptionColumnInfo columnInfo = (OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long pkColumnKey = columnInfo.optionItemIdColKey;
        String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionItemId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$optionGroupId = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionGroupId();
        if (realmGet$optionGroupId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, realmGet$optionGroupId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, false);
        }
        Boolean realmGet$available = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$available();
        if (realmGet$available != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.availableColKey, objKey, realmGet$available, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.availableColKey, objKey, false);
        }
        String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descColKey, objKey, false);
        }
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceColKey, objKey, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long tableNativePtr = table.getNativePtr();
        OrderOptionColumnInfo columnInfo = (OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        long pkColumnKey = columnInfo.optionItemIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.OrderOption object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.OrderOption) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionItemId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$optionGroupId = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$optionGroupId();
            if (realmGet$optionGroupId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, realmGet$optionGroupId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.optionGroupIdColKey, objKey, false);
            }
            Boolean realmGet$available = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$available();
            if (realmGet$available != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.availableColKey, objKey, realmGet$available, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.availableColKey, objKey, false);
            }
            String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descColKey, objKey, false);
            }
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
            Float realmGet$price = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceColKey, objKey, realmGet$price, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.priceColKey, objKey, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.OrderOption createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.OrderOption realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.OrderOption unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.OrderOption();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.OrderOption) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$optionItemId(realmSource.realmGet$optionItemId());
        unmanagedCopy.realmSet$optionGroupId(realmSource.realmGet$optionGroupId());
        unmanagedCopy.realmSet$available(realmSource.realmGet$available());
        unmanagedCopy.realmSet$desc(realmSource.realmGet$desc());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$price(realmSource.realmGet$price());
        unmanagedCopy.realmSet$valid(realmSource.realmGet$valid());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.OrderOption update(Realm realm, OrderOptionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.OrderOption realmObject, com.rhinoactive.foreorder_golf_employee.models.OrderOption newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.optionItemIdColKey, realmObjectSource.realmGet$optionItemId());
        builder.addString(columnInfo.optionGroupIdColKey, realmObjectSource.realmGet$optionGroupId());
        builder.addBoolean(columnInfo.availableColKey, realmObjectSource.realmGet$available());
        builder.addString(columnInfo.descColKey, realmObjectSource.realmGet$desc());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addFloat(columnInfo.priceColKey, realmObjectSource.realmGet$price());
        builder.addBoolean(columnInfo.validColKey, realmObjectSource.realmGet$valid());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("OrderOption = proxy[");
        stringBuilder.append("{optionItemId:");
        stringBuilder.append(realmGet$optionItemId() != null ? realmGet$optionItemId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{optionGroupId:");
        stringBuilder.append(realmGet$optionGroupId() != null ? realmGet$optionGroupId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{available:");
        stringBuilder.append(realmGet$available() != null ? realmGet$available() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{desc:");
        stringBuilder.append(realmGet$desc() != null ? realmGet$desc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price() != null ? realmGet$price() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valid:");
        stringBuilder.append(realmGet$valid() != null ? realmGet$valid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy aOrderOption = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aOrderOption.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOrderOption.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aOrderOption.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
