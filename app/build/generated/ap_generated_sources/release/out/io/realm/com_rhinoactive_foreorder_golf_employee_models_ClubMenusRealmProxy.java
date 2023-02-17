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
public class com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.ClubMenus
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface {

    static final class ClubMenusColumnInfo extends ColumnInfo {
        long clubMenusIdColKey;
        long clubColKey;
        long listOfMenuOrdersColKey;

        ClubMenusColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ClubMenus");
            this.clubMenusIdColKey = addColumnDetails("clubMenusId", "clubMenusId", objectSchemaInfo);
            this.clubColKey = addColumnDetails("club", "club", objectSchemaInfo);
            this.listOfMenuOrdersColKey = addColumnDetails("listOfMenuOrders", "listOfMenuOrders", objectSchemaInfo);
        }

        ClubMenusColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ClubMenusColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ClubMenusColumnInfo src = (ClubMenusColumnInfo) rawSrc;
            final ClubMenusColumnInfo dst = (ClubMenusColumnInfo) rawDst;
            dst.clubMenusIdColKey = src.clubMenusIdColKey;
            dst.clubColKey = src.clubColKey;
            dst.listOfMenuOrdersColKey = src.listOfMenuOrdersColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ClubMenusColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.ClubMenus> proxyState;
    private RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersRealmList;

    com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ClubMenusColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.ClubMenus>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$clubMenusId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.clubMenusIdColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.clubMenusIdColKey);
    }

    @Override
    public void realmSet$clubMenusId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'clubMenusId' cannot be changed after object was created.");
    }

    @Override
    public com.rhinoactive.foreorder_golf_employee.models.Club realmGet$club() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.clubColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.rhinoactive.foreorder_golf_employee.models.Club.class, proxyState.getRow$realm().getLink(columnInfo.clubColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$club(com.rhinoactive.foreorder_golf_employee.models.Club value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("club")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.clubColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.clubColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.clubColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.clubColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    public RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> realmGet$listOfMenuOrders() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (listOfMenuOrdersRealmList != null) {
            return listOfMenuOrdersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.listOfMenuOrdersColKey);
            listOfMenuOrdersRealmList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class, osList, proxyState.getRealm$realm());
            return listOfMenuOrdersRealmList;
        }
    }

    @Override
    public void realmSet$listOfMenuOrders(RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("listOfMenuOrders")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> original = value;
                value = new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>();
                for (com.rhinoactive.foreorder_golf_employee.models.MenuOrders item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealmOrUpdate(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.listOfMenuOrdersColKey);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders linkedObject = value.get(i);
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
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getObjectKey());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "ClubMenus", false, 3, 0);
        builder.addPersistedProperty(NO_ALIAS, "clubMenusId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "club", RealmFieldType.OBJECT, "Club");
        builder.addPersistedLinkProperty(NO_ALIAS, "listOfMenuOrders", RealmFieldType.LIST, "MenuOrders");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ClubMenusColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ClubMenusColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ClubMenus";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ClubMenus";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.ClubMenus createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.rhinoactive.foreorder_golf_employee.models.ClubMenus obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
            ClubMenusColumnInfo columnInfo = (ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
            long pkColumnKey = columnInfo.clubMenusIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("clubMenusId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("clubMenusId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("club")) {
                excludeFields.add("club");
            }
            if (json.has("listOfMenuOrders")) {
                excludeFields.add("listOfMenuOrders");
            }
            if (json.has("clubMenusId")) {
                if (json.isNull("clubMenusId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class, json.getInt("clubMenusId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clubMenusId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) obj;
        if (json.has("club")) {
            if (json.isNull("club")) {
                objProxy.realmSet$club(null);
            } else {
                com.rhinoactive.foreorder_golf_employee.models.Club clubObj = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("club"), update);
                objProxy.realmSet$club(clubObj);
            }
        }
        if (json.has("listOfMenuOrders")) {
            if (json.isNull("listOfMenuOrders")) {
                objProxy.realmSet$listOfMenuOrders(null);
            } else {
                objProxy.realmGet$listOfMenuOrders().clear();
                JSONArray array = json.getJSONArray("listOfMenuOrders");
                for (int i = 0; i < array.length(); i++) {
                    com.rhinoactive.foreorder_golf_employee.models.MenuOrders item = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$listOfMenuOrders().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.ClubMenus createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.ClubMenus obj = new com.rhinoactive.foreorder_golf_employee.models.ClubMenus();
        final com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clubMenusId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clubMenusId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clubMenusId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("club")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$club(null);
                } else {
                    com.rhinoactive.foreorder_golf_employee.models.Club clubObj = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$club(clubObj);
                }
            } else if (name.equals("listOfMenuOrders")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$listOfMenuOrders(null);
                } else {
                    objProxy.realmSet$listOfMenuOrders(new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rhinoactive.foreorder_golf_employee.models.MenuOrders item = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$listOfMenuOrders().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clubMenusId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.ClubMenus copyOrUpdate(Realm realm, ClubMenusColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.ClubMenus object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.ClubMenus realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
            long pkColumnKey = columnInfo.clubMenusIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.ClubMenus copy(Realm realm, ClubMenusColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.ClubMenus newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clubMenusIdColKey, unmanagedSource.realmGet$clubMenusId());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.rhinoactive.foreorder_golf_employee.models.Club clubObj = unmanagedSource.realmGet$club();
        if (clubObj == null) {
            managedCopy.realmSet$club(null);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.Club cacheclub = (com.rhinoactive.foreorder_golf_employee.models.Club) cache.get(clubObj);
            if (cacheclub != null) {
                managedCopy.realmSet$club(cacheclub);
            } else {
                managedCopy.realmSet$club(com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class), clubObj, update, cache, flags));
            }
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersUnmanagedList = unmanagedSource.realmGet$listOfMenuOrders();
        if (listOfMenuOrdersUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersManagedList = managedCopy.realmGet$listOfMenuOrders();
            listOfMenuOrdersManagedList.clear();
            for (int i = 0; i < listOfMenuOrdersUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersUnmanagedItem = listOfMenuOrdersUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders cachelistOfMenuOrders = (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cache.get(listOfMenuOrdersUnmanagedItem);
                if (cachelistOfMenuOrders != null) {
                    listOfMenuOrdersManagedList.add(cachelistOfMenuOrders);
                } else {
                    listOfMenuOrdersManagedList.add(com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class), listOfMenuOrdersUnmanagedItem, update, cache, flags));
                }
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.ClubMenus object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long tableNativePtr = table.getNativePtr();
        ClubMenusColumnInfo columnInfo = (ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long pkColumnKey = columnInfo.clubMenusIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.Club clubObj = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$club();
        if (clubObj != null) {
            Long cacheclub = cache.get(clubObj);
            if (cacheclub == null) {
                cacheclub = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insert(realm, clubObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.clubColKey, objKey, cacheclub, false);
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersList = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$listOfMenuOrders();
        if (listOfMenuOrdersList != null) {
            OsList listOfMenuOrdersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listOfMenuOrdersColKey);
            for (com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem : listOfMenuOrdersList) {
                Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                if (cacheItemIndexlistOfMenuOrders == null) {
                    cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insert(realm, listOfMenuOrdersItem, cache);
                }
                listOfMenuOrdersOsList.addRow(cacheItemIndexlistOfMenuOrders);
            }
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long tableNativePtr = table.getNativePtr();
        ClubMenusColumnInfo columnInfo = (ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long pkColumnKey = columnInfo.clubMenusIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.ClubMenus object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.Club clubObj = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$club();
            if (clubObj != null) {
                Long cacheclub = cache.get(clubObj);
                if (cacheclub == null) {
                    cacheclub = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insert(realm, clubObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.clubColKey, objKey, cacheclub, false);
            }

            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersList = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$listOfMenuOrders();
            if (listOfMenuOrdersList != null) {
                OsList listOfMenuOrdersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listOfMenuOrdersColKey);
                for (com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem : listOfMenuOrdersList) {
                    Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                    if (cacheItemIndexlistOfMenuOrders == null) {
                        cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insert(realm, listOfMenuOrdersItem, cache);
                    }
                    listOfMenuOrdersOsList.addRow(cacheItemIndexlistOfMenuOrders);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.ClubMenus object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long tableNativePtr = table.getNativePtr();
        ClubMenusColumnInfo columnInfo = (ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long pkColumnKey = columnInfo.clubMenusIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
        }
        cache.put(object, objKey);

        com.rhinoactive.foreorder_golf_employee.models.Club clubObj = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$club();
        if (clubObj != null) {
            Long cacheclub = cache.get(clubObj);
            if (cacheclub == null) {
                cacheclub = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insertOrUpdate(realm, clubObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.clubColKey, objKey, cacheclub, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.clubColKey, objKey);
        }

        OsList listOfMenuOrdersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listOfMenuOrdersColKey);
        RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersList = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$listOfMenuOrders();
        if (listOfMenuOrdersList != null && listOfMenuOrdersList.size() == listOfMenuOrdersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objectCount = listOfMenuOrdersList.size();
            for (int i = 0; i < objectCount; i++) {
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem = listOfMenuOrdersList.get(i);
                Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                if (cacheItemIndexlistOfMenuOrders == null) {
                    cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, listOfMenuOrdersItem, cache);
                }
                listOfMenuOrdersOsList.setRow(i, cacheItemIndexlistOfMenuOrders);
            }
        } else {
            listOfMenuOrdersOsList.removeAll();
            if (listOfMenuOrdersList != null) {
                for (com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem : listOfMenuOrdersList) {
                    Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                    if (cacheItemIndexlistOfMenuOrders == null) {
                        cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, listOfMenuOrdersItem, cache);
                    }
                    listOfMenuOrdersOsList.addRow(cacheItemIndexlistOfMenuOrders);
                }
            }
        }

        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long tableNativePtr = table.getNativePtr();
        ClubMenusColumnInfo columnInfo = (ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        long pkColumnKey = columnInfo.clubMenusIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.ClubMenus object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$clubMenusId());
            }
            cache.put(object, objKey);

            com.rhinoactive.foreorder_golf_employee.models.Club clubObj = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$club();
            if (clubObj != null) {
                Long cacheclub = cache.get(clubObj);
                if (cacheclub == null) {
                    cacheclub = com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insertOrUpdate(realm, clubObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.clubColKey, objKey, cacheclub, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.clubColKey, objKey);
            }

            OsList listOfMenuOrdersOsList = new OsList(table.getUncheckedRow(objKey), columnInfo.listOfMenuOrdersColKey);
            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersList = ((com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) object).realmGet$listOfMenuOrders();
            if (listOfMenuOrdersList != null && listOfMenuOrdersList.size() == listOfMenuOrdersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = listOfMenuOrdersList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem = listOfMenuOrdersList.get(i);
                    Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                    if (cacheItemIndexlistOfMenuOrders == null) {
                        cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, listOfMenuOrdersItem, cache);
                    }
                    listOfMenuOrdersOsList.setRow(i, cacheItemIndexlistOfMenuOrders);
                }
            } else {
                listOfMenuOrdersOsList.removeAll();
                if (listOfMenuOrdersList != null) {
                    for (com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem : listOfMenuOrdersList) {
                        Long cacheItemIndexlistOfMenuOrders = cache.get(listOfMenuOrdersItem);
                        if (cacheItemIndexlistOfMenuOrders == null) {
                            cacheItemIndexlistOfMenuOrders = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, listOfMenuOrdersItem, cache);
                        }
                        listOfMenuOrdersOsList.addRow(cacheItemIndexlistOfMenuOrders);
                    }
                }
            }

        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.ClubMenus createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.ClubMenus realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.ClubMenus unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.ClubMenus();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$clubMenusId(realmSource.realmGet$clubMenusId());

        // Deep copy of club
        unmanagedCopy.realmSet$club(com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createDetachedCopy(realmSource.realmGet$club(), currentDepth + 1, maxDepth, cache));

        // Deep copy of listOfMenuOrders
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$listOfMenuOrders(null);
        } else {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> managedlistOfMenuOrdersList = realmSource.realmGet$listOfMenuOrders();
            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> unmanagedlistOfMenuOrdersList = new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>();
            unmanagedCopy.realmSet$listOfMenuOrders(unmanagedlistOfMenuOrdersList);
            int nextDepth = currentDepth + 1;
            int size = managedlistOfMenuOrdersList.size();
            for (int i = 0; i < size; i++) {
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders item = com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createDetachedCopy(managedlistOfMenuOrdersList.get(i), nextDepth, maxDepth, cache);
                unmanagedlistOfMenuOrdersList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.ClubMenus update(Realm realm, ClubMenusColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.ClubMenus realmObject, com.rhinoactive.foreorder_golf_employee.models.ClubMenus newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.clubMenusIdColKey, realmObjectSource.realmGet$clubMenusId());

        com.rhinoactive.foreorder_golf_employee.models.Club clubObj = realmObjectSource.realmGet$club();
        if (clubObj == null) {
            builder.addNull(columnInfo.clubColKey);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.Club cacheclub = (com.rhinoactive.foreorder_golf_employee.models.Club) cache.get(clubObj);
            if (cacheclub != null) {
                builder.addObject(columnInfo.clubColKey, cacheclub);
            } else {
                builder.addObject(columnInfo.clubColKey, com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class), clubObj, true, cache, flags));
            }
        }

        RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersUnmanagedList = realmObjectSource.realmGet$listOfMenuOrders();
        if (listOfMenuOrdersUnmanagedList != null) {
            RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders> listOfMenuOrdersManagedCopy = new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>();
            for (int i = 0; i < listOfMenuOrdersUnmanagedList.size(); i++) {
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders listOfMenuOrdersItem = listOfMenuOrdersUnmanagedList.get(i);
                com.rhinoactive.foreorder_golf_employee.models.MenuOrders cachelistOfMenuOrders = (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) cache.get(listOfMenuOrdersItem);
                if (cachelistOfMenuOrders != null) {
                    listOfMenuOrdersManagedCopy.add(cachelistOfMenuOrders);
                } else {
                    listOfMenuOrdersManagedCopy.add(com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class), listOfMenuOrdersItem, true, cache, flags));
                }
            }
            builder.addObjectList(columnInfo.listOfMenuOrdersColKey, listOfMenuOrdersManagedCopy);
        } else {
            builder.addObjectList(columnInfo.listOfMenuOrdersColKey, new RealmList<com.rhinoactive.foreorder_golf_employee.models.MenuOrders>());
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
        StringBuilder stringBuilder = new StringBuilder("ClubMenus = proxy[");
        stringBuilder.append("{clubMenusId:");
        stringBuilder.append(realmGet$clubMenusId() != null ? realmGet$clubMenusId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{club:");
        stringBuilder.append(realmGet$club() != null ? "Club" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{listOfMenuOrders:");
        stringBuilder.append("RealmList<MenuOrders>[").append(realmGet$listOfMenuOrders().size()).append("]");
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
        com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy aClubMenus = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aClubMenus.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aClubMenus.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aClubMenus.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
