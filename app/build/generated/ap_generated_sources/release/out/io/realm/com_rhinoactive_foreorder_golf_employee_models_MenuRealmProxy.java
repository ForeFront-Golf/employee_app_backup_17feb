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
public class com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.Menu
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface {

    static final class MenuColumnInfo extends ColumnInfo {
        long menuIdColKey;
        long nameColKey;
        long descColKey;
        long clubIdColKey;
        long modifiedAtColKey;
        long selectedColKey;

        MenuColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Menu");
            this.menuIdColKey = addColumnDetails("menuId", "menuId", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.descColKey = addColumnDetails("desc", "desc", objectSchemaInfo);
            this.clubIdColKey = addColumnDetails("clubId", "clubId", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
            this.selectedColKey = addColumnDetails("selected", "selected", objectSchemaInfo);
        }

        MenuColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MenuColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MenuColumnInfo src = (MenuColumnInfo) rawSrc;
            final MenuColumnInfo dst = (MenuColumnInfo) rawDst;
            dst.menuIdColKey = src.menuIdColKey;
            dst.nameColKey = src.nameColKey;
            dst.descColKey = src.descColKey;
            dst.clubIdColKey = src.clubIdColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
            dst.selectedColKey = src.selectedColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MenuColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.Menu> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MenuColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.Menu>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'menuId' cannot be changed after object was created.");
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
    public Boolean realmGet$selected() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.selectedColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.selectedColKey);
    }

    @Override
    public void realmSet$selected(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.selectedColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.selectedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.selectedColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.selectedColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Menu", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "menuId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "desc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "clubId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "selected", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MenuColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MenuColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Menu";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Menu";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.Menu createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rhinoactive.foreorder_golf_employee.models.Menu obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
            MenuColumnInfo columnInfo = (MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
            long pkColumnKey = columnInfo.menuIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("menuId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("menuId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("menuId")) {
                if (json.isNull("menuId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Menu.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Menu.class, json.getInt("menuId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'menuId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("desc")) {
            if (json.isNull("desc")) {
                objProxy.realmSet$desc(null);
            } else {
                objProxy.realmSet$desc((String) json.getString("desc"));
            }
        }
        if (json.has("clubId")) {
            if (json.isNull("clubId")) {
                objProxy.realmSet$clubId(null);
            } else {
                objProxy.realmSet$clubId((int) json.getInt("clubId"));
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
        if (json.has("selected")) {
            if (json.isNull("selected")) {
                objProxy.realmSet$selected(null);
            } else {
                objProxy.realmSet$selected((boolean) json.getBoolean("selected"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.Menu createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.Menu obj = new com.rhinoactive.foreorder_golf_employee.models.Menu();
        final com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("menuId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$menuId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$menuId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("desc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$desc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$desc(null);
                }
            } else if (name.equals("clubId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clubId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clubId(null);
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
            } else if (name.equals("selected")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$selected((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$selected(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'menuId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Menu copyOrUpdate(Realm realm, MenuColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Menu object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.Menu) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.Menu realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
            long pkColumnKey = columnInfo.menuIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Menu copy(Realm realm, MenuColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Menu newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.Menu) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.menuIdColKey, unmanagedSource.realmGet$menuId());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addString(columnInfo.descColKey, unmanagedSource.realmGet$desc());
        builder.addInteger(columnInfo.clubIdColKey, unmanagedSource.realmGet$clubId());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());
        builder.addBoolean(columnInfo.selectedColKey, unmanagedSource.realmGet$selected());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Menu object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long tableNativePtr = table.getNativePtr();
        MenuColumnInfo columnInfo = (MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long pkColumnKey = columnInfo.menuIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
        }
        Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$clubId();
        if (realmGet$clubId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        Boolean realmGet$selected = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$selected();
        if (realmGet$selected != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.selectedColKey, objKey, realmGet$selected, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long tableNativePtr = table.getNativePtr();
        MenuColumnInfo columnInfo = (MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long pkColumnKey = columnInfo.menuIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Menu object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Menu) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
            String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
            }
            Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$clubId();
            if (realmGet$clubId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
            Boolean realmGet$selected = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$selected();
            if (realmGet$selected != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.selectedColKey, objKey, realmGet$selected, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Menu object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long tableNativePtr = table.getNativePtr();
        MenuColumnInfo columnInfo = (MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long pkColumnKey = columnInfo.menuIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$desc();
        if (realmGet$desc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descColKey, objKey, false);
        }
        Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$clubId();
        if (realmGet$clubId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clubIdColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        Boolean realmGet$selected = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$selected();
        if (realmGet$selected != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.selectedColKey, objKey, realmGet$selected, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.selectedColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long tableNativePtr = table.getNativePtr();
        MenuColumnInfo columnInfo = (MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        long pkColumnKey = columnInfo.menuIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Menu object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Menu) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$menuId());
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
            String realmGet$desc = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$desc();
            if (realmGet$desc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descColKey, objKey, realmGet$desc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descColKey, objKey, false);
            }
            Number realmGet$clubId = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$clubId();
            if (realmGet$clubId != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.clubIdColKey, objKey, realmGet$clubId.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.clubIdColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
            Boolean realmGet$selected = ((com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) object).realmGet$selected();
            if (realmGet$selected != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.selectedColKey, objKey, realmGet$selected, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.selectedColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Menu createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.Menu realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.Menu unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.Menu();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.Menu) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.Menu) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$menuId(realmSource.realmGet$menuId());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$desc(realmSource.realmGet$desc());
        unmanagedCopy.realmSet$clubId(realmSource.realmGet$clubId());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());
        unmanagedCopy.realmSet$selected(realmSource.realmGet$selected());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.Menu update(Realm realm, MenuColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Menu realmObject, com.rhinoactive.foreorder_golf_employee.models.Menu newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.menuIdColKey, realmObjectSource.realmGet$menuId());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.descColKey, realmObjectSource.realmGet$desc());
        builder.addInteger(columnInfo.clubIdColKey, realmObjectSource.realmGet$clubId());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());
        builder.addBoolean(columnInfo.selectedColKey, realmObjectSource.realmGet$selected());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Menu = proxy[");
        stringBuilder.append("{menuId:");
        stringBuilder.append(realmGet$menuId() != null ? realmGet$menuId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{desc:");
        stringBuilder.append(realmGet$desc() != null ? realmGet$desc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clubId:");
        stringBuilder.append(realmGet$clubId() != null ? realmGet$clubId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selected:");
        stringBuilder.append(realmGet$selected() != null ? realmGet$selected() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy aMenu = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMenu.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMenu.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMenu.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
