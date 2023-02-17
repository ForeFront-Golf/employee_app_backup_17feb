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
public class com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.UserLocation
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface {

    static final class UserLocationColumnInfo extends ColumnInfo {
        long userIdColKey;
        long latColKey;
        long lonColKey;

        UserLocationColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UserLocation");
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.latColKey = addColumnDetails("lat", "lat", objectSchemaInfo);
            this.lonColKey = addColumnDetails("lon", "lon", objectSchemaInfo);
        }

        UserLocationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserLocationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserLocationColumnInfo src = (UserLocationColumnInfo) rawSrc;
            final UserLocationColumnInfo dst = (UserLocationColumnInfo) rawDst;
            dst.userIdColKey = src.userIdColKey;
            dst.latColKey = src.latColKey;
            dst.lonColKey = src.lonColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserLocationColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.UserLocation> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserLocationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.UserLocation>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$lat() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.latColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latColKey);
    }

    @Override
    public void realmSet$lat(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.latColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.latColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.latColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.latColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$lon() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.lonColKey)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.lonColKey);
    }

    @Override
    public void realmSet$lon(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lonColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.lonColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lonColKey);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.lonColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "UserLocation", false, 3, 0);
        builder.addPersistedProperty(NO_ALIAS, "userId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lat", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lon", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserLocationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserLocationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UserLocation";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UserLocation";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.UserLocation createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rhinoactive.foreorder_golf_employee.models.UserLocation obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
            UserLocationColumnInfo columnInfo = (UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
            long pkColumnKey = columnInfo.userIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("userId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("userId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userId")) {
                if (json.isNull("userId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class, json.getInt("userId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) obj;
        if (json.has("lat")) {
            if (json.isNull("lat")) {
                objProxy.realmSet$lat(null);
            } else {
                objProxy.realmSet$lat((double) json.getDouble("lat"));
            }
        }
        if (json.has("lon")) {
            if (json.isNull("lon")) {
                objProxy.realmSet$lon(null);
            } else {
                objProxy.realmSet$lon((double) json.getDouble("lon"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.UserLocation createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.UserLocation obj = new com.rhinoactive.foreorder_golf_employee.models.UserLocation();
        final com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("lat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lat((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lat(null);
                }
            } else if (name.equals("lon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lon((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lon(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.UserLocation copyOrUpdate(Realm realm, UserLocationColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.UserLocation object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.UserLocation realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
            long pkColumnKey = columnInfo.userIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.UserLocation copy(Realm realm, UserLocationColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.UserLocation newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.userIdColKey, unmanagedSource.realmGet$userId());
        builder.addDouble(columnInfo.latColKey, unmanagedSource.realmGet$lat());
        builder.addDouble(columnInfo.lonColKey, unmanagedSource.realmGet$lon());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.UserLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long tableNativePtr = table.getNativePtr();
        UserLocationColumnInfo columnInfo = (UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long pkColumnKey = columnInfo.userIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lat();
        if (realmGet$lat != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
        }
        Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lon();
        if (realmGet$lon != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long tableNativePtr = table.getNativePtr();
        UserLocationColumnInfo columnInfo = (UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.UserLocation object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.UserLocation) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lat();
            if (realmGet$lat != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
            }
            Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lon();
            if (realmGet$lon != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.UserLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long tableNativePtr = table.getNativePtr();
        UserLocationColumnInfo columnInfo = (UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long pkColumnKey = columnInfo.userIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
        }
        cache.put(object, objKey);
        Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lat();
        if (realmGet$lat != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latColKey, objKey, false);
        }
        Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lon();
        if (realmGet$lon != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lonColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long tableNativePtr = table.getNativePtr();
        UserLocationColumnInfo columnInfo = (UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.UserLocation object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.UserLocation) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$userId());
            }
            cache.put(object, objKey);
            Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lat();
            if (realmGet$lat != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.latColKey, objKey, false);
            }
            Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) object).realmGet$lon();
            if (realmGet$lon != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lonColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.UserLocation createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.UserLocation realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.UserLocation unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.UserLocation();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$lat(realmSource.realmGet$lat());
        unmanagedCopy.realmSet$lon(realmSource.realmGet$lon());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.UserLocation update(Realm realm, UserLocationColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.UserLocation realmObject, com.rhinoactive.foreorder_golf_employee.models.UserLocation newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addDouble(columnInfo.latColKey, realmObjectSource.realmGet$lat());
        builder.addDouble(columnInfo.lonColKey, realmObjectSource.realmGet$lon());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserLocation = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lat:");
        stringBuilder.append(realmGet$lat() != null ? realmGet$lat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lon:");
        stringBuilder.append(realmGet$lon() != null ? realmGet$lon() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy aUserLocation = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUserLocation.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUserLocation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUserLocation.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
