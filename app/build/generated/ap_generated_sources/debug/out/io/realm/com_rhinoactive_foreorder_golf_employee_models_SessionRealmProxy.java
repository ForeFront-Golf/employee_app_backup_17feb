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
public class com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.Session
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface {

    static final class SessionColumnInfo extends ColumnInfo {
        long sessionIdColKey;
        long userIdColKey;
        long validColKey;
        long createdAtColKey;
        long modifiedAtColKey;

        SessionColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Session");
            this.sessionIdColKey = addColumnDetails("sessionId", "sessionId", objectSchemaInfo);
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.validColKey = addColumnDetails("valid", "valid", objectSchemaInfo);
            this.createdAtColKey = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
        }

        SessionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SessionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SessionColumnInfo src = (SessionColumnInfo) rawSrc;
            final SessionColumnInfo dst = (SessionColumnInfo) rawDst;
            dst.sessionIdColKey = src.sessionIdColKey;
            dst.userIdColKey = src.userIdColKey;
            dst.validColKey = src.validColKey;
            dst.createdAtColKey = src.createdAtColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SessionColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.Session> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SessionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.Session>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sessionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sessionIdColKey);
    }

    @Override
    public void realmSet$sessionId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'sessionId' cannot be changed after object was created.");
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Session", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "sessionId", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "userId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "valid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "createdAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SessionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SessionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Session";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Session";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.Session createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rhinoactive.foreorder_golf_employee.models.Session obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
            SessionColumnInfo columnInfo = (SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
            long pkColumnKey = columnInfo.sessionIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("sessionId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("sessionId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("sessionId")) {
                if (json.isNull("sessionId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Session.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Session.class, json.getString("sessionId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sessionId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) obj;
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((int) json.getInt("userId"));
            }
        }
        if (json.has("valid")) {
            if (json.isNull("valid")) {
                objProxy.realmSet$valid(null);
            } else {
                objProxy.realmSet$valid((boolean) json.getBoolean("valid"));
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
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.Session createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.Session obj = new com.rhinoactive.foreorder_golf_employee.models.Session();
        final com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("sessionId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sessionId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sessionId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("valid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$valid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$valid(null);
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'sessionId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Session copyOrUpdate(Realm realm, SessionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Session object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.Session) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.Session realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
            long pkColumnKey = columnInfo.sessionIdColKey;
            String value = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$sessionId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Session copy(Realm realm, SessionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Session newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.Session) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.sessionIdColKey, unmanagedSource.realmGet$sessionId());
        builder.addInteger(columnInfo.userIdColKey, unmanagedSource.realmGet$userId());
        builder.addBoolean(columnInfo.validColKey, unmanagedSource.realmGet$valid());
        builder.addDate(columnInfo.createdAtColKey, unmanagedSource.realmGet$createdAt());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Session object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long pkColumnKey = columnInfo.sessionIdColKey;
        String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$sessionId();
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
        Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        }
        java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long pkColumnKey = columnInfo.sessionIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Session object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Session) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$sessionId();
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
            Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            }
            java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Session object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long pkColumnKey = columnInfo.sessionIdColKey;
        String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$sessionId();
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
        Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, objKey, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
        }
        java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        long pkColumnKey = columnInfo.sessionIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Session object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Session) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$sessionId();
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
            Number realmGet$userId = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.userIdColKey, objKey, realmGet$userId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdColKey, objKey, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
            }
            java.util.Date realmGet$createdAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdAtColKey, objKey, realmGet$createdAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Session createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.Session realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.Session unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.Session();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.Session) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.Session) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$sessionId(realmSource.realmGet$sessionId());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$valid(realmSource.realmGet$valid());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.Session update(Realm realm, SessionColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Session realmObject, com.rhinoactive.foreorder_golf_employee.models.Session newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.sessionIdColKey, realmObjectSource.realmGet$sessionId());
        builder.addInteger(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addBoolean(columnInfo.validColKey, realmObjectSource.realmGet$valid());
        builder.addDate(columnInfo.createdAtColKey, realmObjectSource.realmGet$createdAt());
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
        StringBuilder stringBuilder = new StringBuilder("Session = proxy[");
        stringBuilder.append("{sessionId:");
        stringBuilder.append(realmGet$sessionId() != null ? realmGet$sessionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valid:");
        stringBuilder.append(realmGet$valid() != null ? realmGet$valid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy aSession = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aSession.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSession.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aSession.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
