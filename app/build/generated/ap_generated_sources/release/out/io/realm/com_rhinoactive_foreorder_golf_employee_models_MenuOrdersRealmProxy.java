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
public class com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.MenuOrders
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface {

    static final class MenuOrdersColumnInfo extends ColumnInfo {
        long menuOrdersIdColKey;
        long menuColKey;
        long ordersColKey;

        MenuOrdersColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MenuOrders");
            this.menuOrdersIdColKey = addColumnDetails("menuOrdersId", "menuOrdersId", objectSchemaInfo);
            this.menuColKey = addColumnDetails("menu", "menu", objectSchemaInfo);
            this.ordersColKey = addColumnDetails("orders", "orders", objectSchemaInfo);
        }

        MenuOrdersColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MenuOrdersColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MenuOrdersColumnInfo src = (MenuOrdersColumnInfo) rawSrc;
            final MenuOrdersColumnInfo dst = (MenuOrdersColumnInfo) rawDst;
            dst.menuOrdersIdColKey = src.menuOrdersIdColKey;
            dst.menuColKey = src.menuColKey;
            dst.ordersColKey = src.ordersColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MenuOrdersColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> proxyState;
    private RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersRealmList;

    com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MenuOrdersColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$menuOrdersId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.menuOrdersIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.menuOrdersIdColKey);
    }

    @Override
    public void realmSet$menuOrdersId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'menuOrdersId' cannot be changed after object was created.");
    }

    @Override
    public com.rhinoactive.foreorder_golf_employee.models.Menu realmGet$menu() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.menuColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.rhinoactive.foreorder_golf_employee.models.Menu.class, proxyState.getRow$realm().getLink(columnInfo.menuColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$menu(com.rhinoactive.foreorder_golf_employee.models.Menu value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("menu")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.menuColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.menuColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.menuColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.menuColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    public RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> realmGet$orders() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (ordersRealmList != null) {
            return ordersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.ordersColKey);
            ordersRealmList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>(com.rhinoactive.foreorder_golf_employee.models.Order.class, osList, proxyState.getRealm$realm());
            return ordersRealmList;
        }
    }

    @Override
    public void realmSet$orders(RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("orders")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> original = value;
                value = new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>();
                for (com.rhinoactive.foreorder_golf_employee.models.Order item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.ordersColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rhinoactive.foreorder_golf_employee.models.Order linkedObject = value.get(i);
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
                com.rhinoactive.foreorder_golf_employee.models.Order linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "MenuOrders", false, 3, 0);
        builder.addPersistedProperty(NO_ALIAS, "menuOrdersId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "menu", RealmFieldType.OBJECT, "Menu");
        builder.addPersistedLinkProperty(NO_ALIAS, "orders", RealmFieldType.LIST, "Order");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MenuOrdersColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MenuOrdersColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MenuOrders";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MenuOrders";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.MenuOrders createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.rhinoactive.foreorder_golf_employee.models.MenuOrders obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
            MenuOrdersColumnInfo columnInfo = (MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
            long pkColumnKey = columnInfo.menuOrdersIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("menuOrdersId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("menuOrdersId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("menu")) {
                excludeFields.add("menu");
            }
            if (json.has("orders")) {
                excludeFields.add("orders");
            }
            if (json.has("menuOrdersId")) {
                if (json.isNull("menuOrdersId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class, json.getInt("menuOrdersId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'menuOrdersId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) obj;
        if (json.has("menu")) {
            if (json.isNull("menu")) {
                objProxy.realmSet$menu(null);
            } else {
                com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("menu"), update);
                objProxy.realmSet$menu(menuObj);
            }
        }
        if (json.has("orders")) {
            if (json.isNull("orders")) {
                objProxy.realmSet$orders(null);
            } else {
                objProxy.realmGet$orders().clear();
                JSONArray array = json.getJSONArray("orders");
                for (int i = 0; i < array.length(); i++) {
                    com.rhinoactive.foreorder_golf_employee.models.Order item = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$orders().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.MenuOrders createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.MenuOrders obj = new com.rhinoactive.foreorder_golf_employee.models.MenuOrders();
        final com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("menuOrdersId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$menuOrdersId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$menuOrdersId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("menu")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$menu(null);
                } else {
                    com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$menu(menuObj);
                }
            } else if (name.equals("orders")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$orders(null);
                } else {
                    objProxy.realmSet$orders(new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rhinoactive.foreorder_golf_employee.models.Order item = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$orders().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'menuOrdersId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.MenuOrders copyOrUpdate(Realm realm, MenuOrdersColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.MenuOrders object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.MenuOrders realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
            long pkColumnKey = columnInfo.menuOrdersIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.MenuOrders copy(Realm realm, MenuOrdersColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.MenuOrders newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.menuOrdersIdColKey, unmanagedSource.realmGet$menuOrdersId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = unmanagedSource.realmGet$menu();
        if (menuObj == null) {
            managedCopy.realmSet$menu(null);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.Menu cachemenu = (com.rhinoactive.foreorder_golf_employee.models.Menu) cache.get(menuObj);
            if (cachemenu != null) {
                managedCopy.realmSet$menu(cachemenu);
            } else {
                managedCopy.realmSet$menu(com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class), menuObj, update, cache, flags));
            }
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersUnmanagedList = unmanagedSource.realmGet$orders();
        if (ordersUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersManagedList = managedCopy.realmGet$orders();
            ordersManagedList.clear();
            for (int i = 0; i < ordersUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.Order ordersUnmanagedItem = ordersUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.Order cacheorders = (com.rhinoactive.foreorder_golf_employee.models.Order) cache.get(ordersUnmanagedItem);
                if (cacheorders != null) {
                    ordersManagedList.add(cacheorders);
                } else {
                    ordersManagedList.add(com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class), ordersUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.MenuOrders object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long tableNativePtr = table.getNativePtr();
        MenuOrdersColumnInfo columnInfo = (MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long pkColumnKey = columnInfo.menuOrdersIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menu();
        if (menuObj != null) {
            Long cachemenu = cache.get(menuObj);
            if (cachemenu == null) {
                cachemenu = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insert(realm, menuObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.menuColKey, objKey, cachemenu, false);
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersList = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$orders();
        if (ordersList != null) {
            OsList ordersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.ordersColKey);
            for (com.rhinoactive.foreorder_golf_employee.models.Order ordersItem : ordersList) {
                Long cacheItemIndexorders = cache.get(ordersItem);
                if (cacheItemIndexorders == null) {
                    cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insert(realm, ordersItem, cache);
                }
                ordersOsList.addRow(cacheItemIndexorders);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long tableNativePtr = table.getNativePtr();
        MenuOrdersColumnInfo columnInfo = (MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long pkColumnKey = columnInfo.menuOrdersIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.MenuOrders object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menu();
            if (menuObj != null) {
                Long cachemenu = cache.get(menuObj);
                if (cachemenu == null) {
                    cachemenu = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insert(realm, menuObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.menuColKey, objKey, cachemenu, false);
            }

            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersList = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$orders();
            if (ordersList != null) {
                OsList ordersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.ordersColKey);
                for (com.rhinoactive.foreorder_golf_employee.models.Order ordersItem : ordersList) {
                    Long cacheItemIndexorders = cache.get(ordersItem);
                    if (cacheItemIndexorders == null) {
                        cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insert(realm, ordersItem, cache);
                    }
                    ordersOsList.addRow(cacheItemIndexorders);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.MenuOrders object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long tableNativePtr = table.getNativePtr();
        MenuOrdersColumnInfo columnInfo = (MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long pkColumnKey = columnInfo.menuOrdersIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menu();
        if (menuObj != null) {
            Long cachemenu = cache.get(menuObj);
            if (cachemenu == null) {
                cachemenu = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insertOrUpdate(realm, menuObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.menuColKey, objKey, cachemenu, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.menuColKey, objKey);
        }

        OsList ordersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.ordersColKey);
        RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersList = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$orders();
        if (ordersList != null && ordersList.size() == ordersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = ordersList.size();
            for (int i = 0; i < objectCount; i++) {
                com.rhinoactive.foreorder_golf_employee.models.Order ordersItem = ordersList.get(i);
                Long cacheItemIndexorders = cache.get(ordersItem);
                if (cacheItemIndexorders == null) {
                    cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, ordersItem, cache);
                }
                ordersOsList.setRow(i, cacheItemIndexorders);
            }
        } else {
            ordersOsList.removeAll();
            if (ordersList != null) {
                for (com.rhinoactive.foreorder_golf_employee.models.Order ordersItem : ordersList) {
                    Long cacheItemIndexorders = cache.get(ordersItem);
                    if (cacheItemIndexorders == null) {
                        cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, ordersItem, cache);
                    }
                    ordersOsList.addRow(cacheItemIndexorders);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long tableNativePtr = table.getNativePtr();
        MenuOrdersColumnInfo columnInfo = (MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        long pkColumnKey = columnInfo.menuOrdersIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.MenuOrders object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menuOrdersId());
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$menu();
            if (menuObj != null) {
                Long cachemenu = cache.get(menuObj);
                if (cachemenu == null) {
                    cachemenu = com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insertOrUpdate(realm, menuObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.menuColKey, objKey, cachemenu, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.menuColKey, objKey);
            }

            OsList ordersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.ordersColKey);
            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersList = ((com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) object).realmGet$orders();
            if (ordersList != null && ordersList.size() == ordersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = ordersList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rhinoactive.foreorder_golf_employee.models.Order ordersItem = ordersList.get(i);
                    Long cacheItemIndexorders = cache.get(ordersItem);
                    if (cacheItemIndexorders == null) {
                        cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, ordersItem, cache);
                    }
                    ordersOsList.setRow(i, cacheItemIndexorders);
                }
            } else {
                ordersOsList.removeAll();
                if (ordersList != null) {
                    for (com.rhinoactive.foreorder_golf_employee.models.Order ordersItem : ordersList) {
                        Long cacheItemIndexorders = cache.get(ordersItem);
                        if (cacheItemIndexorders == null) {
                            cacheItemIndexorders = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, ordersItem, cache);
                        }
                        ordersOsList.addRow(cacheItemIndexorders);
                    }
                }
            }

        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.MenuOrders createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.MenuOrders realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.MenuOrders unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.MenuOrders();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$menuOrdersId(realmSource.realmGet$menuOrdersId());

        // Deep copy of menu
        unmanagedCopy.realmSet$menu(com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createDetachedCopy(realmSource.realmGet$menu(), currentDepth + 1, maxDepth, cache));

        // Deep copy of orders
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$orders(null);
        } else {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> managedordersList = realmSource.realmGet$orders();
            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> unmanagedordersList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>();
            unmanagedCopy.realmSet$orders(unmanagedordersList);
            int nextDepth = currentDepth + 1;
            int size = managedordersList.size();
            for (int i = 0; i < size; i++) {
                com.rhinoactive.foreorder_golf_employee.models.Order item = com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createDetachedCopy(managedordersList.get(i), nextDepth, maxDepth, cache);
                unmanagedordersList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.MenuOrders update(Realm realm, MenuOrdersColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.MenuOrders realmObject, com.rhinoactive.foreorder_golf_employee.models.MenuOrders newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.menuOrdersIdColKey, realmObjectSource.realmGet$menuOrdersId());

        com.rhinoactive.foreorder_golf_employee.models.Menu menuObj = realmObjectSource.realmGet$menu();
        if (menuObj == null) {
            builder.addNull(columnInfo.menuColKey);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.Menu cachemenu = (com.rhinoactive.foreorder_golf_employee.models.Menu) cache.get(menuObj);
            if (cachemenu != null) {
                builder.addObject(columnInfo.menuColKey, cachemenu);
            } else {
                builder.addObject(columnInfo.menuColKey, com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class), menuObj, true, cache, flags));
            }
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersUnmanagedList = realmObjectSource.realmGet$orders();
        if (ordersUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.Order> ordersManagedCopy = new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>();
            for (int i = 0; i < ordersUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.Order ordersItem = ordersUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.Order cacheorders = (com.rhinoactive.foreorder_golf_employee.models.Order) cache.get(ordersItem);
                if (cacheorders != null) {
                    ordersManagedCopy.add(cacheorders);
                } else {
                    ordersManagedCopy.add(com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class), ordersItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.ordersColKey, ordersManagedCopy);
        } else {
            builder.addObjectList(columnInfo.ordersColKey, new RealmList<com.rhinoactive.foreorder_golf_employee.models.Order>());
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
        StringBuilder stringBuilder = new StringBuilder("MenuOrders = proxy[");
        stringBuilder.append("{menuOrdersId:");
        stringBuilder.append(realmGet$menuOrdersId() != null ? realmGet$menuOrdersId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{menu:");
        stringBuilder.append(realmGet$menu() != null ? "Menu" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{orders:");
        stringBuilder.append("RealmList<Order>[").append(realmGet$orders().size()).append("]");
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
        com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy aMenuOrders = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMenuOrders.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMenuOrders.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMenuOrders.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
