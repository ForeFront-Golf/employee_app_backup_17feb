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
public class com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.Club
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface {

    static final class ClubColumnInfo extends ColumnInfo {
        long clubIdColKey;
        long nameColKey;
        long phoneNumberColKey;
        long addressColKey;
        long latColKey;
        long lonColKey;
        long photoUrlColKey;
        long photoUrlThumbColKey;
        long modifiedAtColKey;
        long privateClubColKey;
        long showTaxColKey;

        ClubColumnInfo(OsSchemaInfo schemaInfo) {
            super(11);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Club");
            this.clubIdColKey = addColumnDetails("clubId", "clubId", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.phoneNumberColKey = addColumnDetails("phoneNumber", "phoneNumber", objectSchemaInfo);
            this.addressColKey = addColumnDetails("address", "address", objectSchemaInfo);
            this.latColKey = addColumnDetails("lat", "lat", objectSchemaInfo);
            this.lonColKey = addColumnDetails("lon", "lon", objectSchemaInfo);
            this.photoUrlColKey = addColumnDetails("photoUrl", "photoUrl", objectSchemaInfo);
            this.photoUrlThumbColKey = addColumnDetails("photoUrlThumb", "photoUrlThumb", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
            this.privateClubColKey = addColumnDetails("privateClub", "privateClub", objectSchemaInfo);
            this.showTaxColKey = addColumnDetails("showTax", "showTax", objectSchemaInfo);
        }

        ClubColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ClubColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ClubColumnInfo src = (ClubColumnInfo) rawSrc;
            final ClubColumnInfo dst = (ClubColumnInfo) rawDst;
            dst.clubIdColKey = src.clubIdColKey;
            dst.nameColKey = src.nameColKey;
            dst.phoneNumberColKey = src.phoneNumberColKey;
            dst.addressColKey = src.addressColKey;
            dst.latColKey = src.latColKey;
            dst.lonColKey = src.lonColKey;
            dst.photoUrlColKey = src.photoUrlColKey;
            dst.photoUrlThumbColKey = src.photoUrlThumbColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
            dst.privateClubColKey = src.privateClubColKey;
            dst.showTaxColKey = src.showTaxColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ClubColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.Club> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ClubColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.Club>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'clubId' cannot be changed after object was created.");
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
    public String realmGet$phoneNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneNumberColKey);
    }

    @Override
    public void realmSet$phoneNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneNumberColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneNumberColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneNumberColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneNumberColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressColKey);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressColKey, value);
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

    @Override
    @SuppressWarnings("cast")
    public String realmGet$photoUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.photoUrlColKey);
    }

    @Override
    public void realmSet$photoUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.photoUrlColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.photoUrlColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.photoUrlColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.photoUrlColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$photoUrlThumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.photoUrlThumbColKey);
    }

    @Override
    public void realmSet$photoUrlThumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.photoUrlThumbColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.photoUrlThumbColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.photoUrlThumbColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.photoUrlThumbColKey, value);
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
    public Boolean realmGet$privateClub() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.privateClubColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.privateClubColKey);
    }

    @Override
    public void realmSet$privateClub(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.privateClubColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.privateClubColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.privateClubColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.privateClubColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$showTax() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.showTaxColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.showTaxColKey);
    }

    @Override
    public void realmSet$showTax(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.showTaxColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.showTaxColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.showTaxColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.showTaxColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Club", false, 11, 0);
        builder.addPersistedProperty(NO_ALIAS, "clubId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "phoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lat", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lon", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "photoUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "photoUrlThumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "privateClub", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "showTax", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ClubColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ClubColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Club";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Club";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.Club createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rhinoactive.foreorder_golf_employee.models.Club obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
            ClubColumnInfo columnInfo = (ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
            long pkColumnKey = columnInfo.clubIdColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("clubId")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("clubId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("clubId")) {
                if (json.isNull("clubId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Club.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.Club.class, json.getInt("clubId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clubId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("phoneNumber")) {
            if (json.isNull("phoneNumber")) {
                objProxy.realmSet$phoneNumber(null);
            } else {
                objProxy.realmSet$phoneNumber((String) json.getString("phoneNumber"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                objProxy.realmSet$address((String) json.getString("address"));
            }
        }
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
        if (json.has("photoUrl")) {
            if (json.isNull("photoUrl")) {
                objProxy.realmSet$photoUrl(null);
            } else {
                objProxy.realmSet$photoUrl((String) json.getString("photoUrl"));
            }
        }
        if (json.has("photoUrlThumb")) {
            if (json.isNull("photoUrlThumb")) {
                objProxy.realmSet$photoUrlThumb(null);
            } else {
                objProxy.realmSet$photoUrlThumb((String) json.getString("photoUrlThumb"));
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
        if (json.has("privateClub")) {
            if (json.isNull("privateClub")) {
                objProxy.realmSet$privateClub(null);
            } else {
                objProxy.realmSet$privateClub((boolean) json.getBoolean("privateClub"));
            }
        }
        if (json.has("showTax")) {
            if (json.isNull("showTax")) {
                objProxy.realmSet$showTax(null);
            } else {
                objProxy.realmSet$showTax((boolean) json.getBoolean("showTax"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.Club createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.Club obj = new com.rhinoactive.foreorder_golf_employee.models.Club();
        final com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clubId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clubId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$clubId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("phoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneNumber(null);
                }
            } else if (name.equals("address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                }
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
            } else if (name.equals("photoUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$photoUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$photoUrl(null);
                }
            } else if (name.equals("photoUrlThumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$photoUrlThumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$photoUrlThumb(null);
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
            } else if (name.equals("privateClub")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$privateClub((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$privateClub(null);
                }
            } else if (name.equals("showTax")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$showTax((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$showTax(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clubId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Club copyOrUpdate(Realm realm, ClubColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Club object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.Club) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.Club realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
            long pkColumnKey = columnInfo.clubIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Club copy(Realm realm, ClubColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Club newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.Club) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clubIdColKey, unmanagedSource.realmGet$clubId());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addString(columnInfo.phoneNumberColKey, unmanagedSource.realmGet$phoneNumber());
        builder.addString(columnInfo.addressColKey, unmanagedSource.realmGet$address());
        builder.addDouble(columnInfo.latColKey, unmanagedSource.realmGet$lat());
        builder.addDouble(columnInfo.lonColKey, unmanagedSource.realmGet$lon());
        builder.addString(columnInfo.photoUrlColKey, unmanagedSource.realmGet$photoUrl());
        builder.addString(columnInfo.photoUrlThumbColKey, unmanagedSource.realmGet$photoUrlThumb());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());
        builder.addBoolean(columnInfo.privateClubColKey, unmanagedSource.realmGet$privateClub());
        builder.addBoolean(columnInfo.showTaxColKey, unmanagedSource.realmGet$showTax());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Club object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long tableNativePtr = table.getNativePtr();
        ClubColumnInfo columnInfo = (ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long pkColumnKey = columnInfo.clubIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        }
        String realmGet$address = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
        }
        Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lat();
        if (realmGet$lat != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
        }
        Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lon();
        if (realmGet$lon != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
        }
        String realmGet$photoUrl = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrl();
        if (realmGet$photoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoUrlColKey, objKey, realmGet$photoUrl, false);
        }
        String realmGet$photoUrlThumb = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrlThumb();
        if (realmGet$photoUrlThumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, realmGet$photoUrlThumb, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }
        Boolean realmGet$privateClub = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$privateClub();
        if (realmGet$privateClub != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.privateClubColKey, objKey, realmGet$privateClub, false);
        }
        Boolean realmGet$showTax = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$showTax();
        if (realmGet$showTax != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.showTaxColKey, objKey, realmGet$showTax, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long tableNativePtr = table.getNativePtr();
        ClubColumnInfo columnInfo = (ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long pkColumnKey = columnInfo.clubIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Club object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Club) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
            String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            }
            String realmGet$address = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
            }
            Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lat();
            if (realmGet$lat != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
            }
            Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lon();
            if (realmGet$lon != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
            }
            String realmGet$photoUrl = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrl();
            if (realmGet$photoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoUrlColKey, objKey, realmGet$photoUrl, false);
            }
            String realmGet$photoUrlThumb = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrlThumb();
            if (realmGet$photoUrlThumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, realmGet$photoUrlThumb, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }
            Boolean realmGet$privateClub = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$privateClub();
            if (realmGet$privateClub != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.privateClubColKey, objKey, realmGet$privateClub, false);
            }
            Boolean realmGet$showTax = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$showTax();
            if (realmGet$showTax != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.showTaxColKey, objKey, realmGet$showTax, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.Club object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long tableNativePtr = table.getNativePtr();
        ClubColumnInfo columnInfo = (ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long pkColumnKey = columnInfo.clubIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
        }
        String realmGet$address = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressColKey, objKey, false);
        }
        Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lat();
        if (realmGet$lat != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latColKey, objKey, false);
        }
        Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lon();
        if (realmGet$lon != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lonColKey, objKey, false);
        }
        String realmGet$photoUrl = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrl();
        if (realmGet$photoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoUrlColKey, objKey, realmGet$photoUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.photoUrlColKey, objKey, false);
        }
        String realmGet$photoUrlThumb = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrlThumb();
        if (realmGet$photoUrlThumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, realmGet$photoUrlThumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }
        Boolean realmGet$privateClub = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$privateClub();
        if (realmGet$privateClub != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.privateClubColKey, objKey, realmGet$privateClub, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.privateClubColKey, objKey, false);
        }
        Boolean realmGet$showTax = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$showTax();
        if (realmGet$showTax != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.showTaxColKey, objKey, realmGet$showTax, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.showTaxColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long tableNativePtr = table.getNativePtr();
        ClubColumnInfo columnInfo = (ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        long pkColumnKey = columnInfo.clubIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.Club object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.Club) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$clubId());
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
            String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
            }
            String realmGet$address = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressColKey, objKey, false);
            }
            Double realmGet$lat = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lat();
            if (realmGet$lat != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.latColKey, objKey, realmGet$lat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.latColKey, objKey, false);
            }
            Double realmGet$lon = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$lon();
            if (realmGet$lon != null) {
                Table.nativeSetDouble(tableNativePtr, columnInfo.lonColKey, objKey, realmGet$lon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lonColKey, objKey, false);
            }
            String realmGet$photoUrl = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrl();
            if (realmGet$photoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoUrlColKey, objKey, realmGet$photoUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.photoUrlColKey, objKey, false);
            }
            String realmGet$photoUrlThumb = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$photoUrlThumb();
            if (realmGet$photoUrlThumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, realmGet$photoUrlThumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.photoUrlThumbColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }
            Boolean realmGet$privateClub = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$privateClub();
            if (realmGet$privateClub != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.privateClubColKey, objKey, realmGet$privateClub, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.privateClubColKey, objKey, false);
            }
            Boolean realmGet$showTax = ((com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) object).realmGet$showTax();
            if (realmGet$showTax != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.showTaxColKey, objKey, realmGet$showTax, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.showTaxColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.Club createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.Club realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.Club unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.Club();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.Club) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.Club) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$clubId(realmSource.realmGet$clubId());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$phoneNumber(realmSource.realmGet$phoneNumber());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$lat(realmSource.realmGet$lat());
        unmanagedCopy.realmSet$lon(realmSource.realmGet$lon());
        unmanagedCopy.realmSet$photoUrl(realmSource.realmGet$photoUrl());
        unmanagedCopy.realmSet$photoUrlThumb(realmSource.realmGet$photoUrlThumb());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());
        unmanagedCopy.realmSet$privateClub(realmSource.realmGet$privateClub());
        unmanagedCopy.realmSet$showTax(realmSource.realmGet$showTax());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.Club update(Realm realm, ClubColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.Club realmObject, com.rhinoactive.foreorder_golf_employee.models.Club newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.clubIdColKey, realmObjectSource.realmGet$clubId());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.phoneNumberColKey, realmObjectSource.realmGet$phoneNumber());
        builder.addString(columnInfo.addressColKey, realmObjectSource.realmGet$address());
        builder.addDouble(columnInfo.latColKey, realmObjectSource.realmGet$lat());
        builder.addDouble(columnInfo.lonColKey, realmObjectSource.realmGet$lon());
        builder.addString(columnInfo.photoUrlColKey, realmObjectSource.realmGet$photoUrl());
        builder.addString(columnInfo.photoUrlThumbColKey, realmObjectSource.realmGet$photoUrlThumb());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());
        builder.addBoolean(columnInfo.privateClubColKey, realmObjectSource.realmGet$privateClub());
        builder.addBoolean(columnInfo.showTaxColKey, realmObjectSource.realmGet$showTax());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Club = proxy[");
        stringBuilder.append("{clubId:");
        stringBuilder.append(realmGet$clubId() != null ? realmGet$clubId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneNumber:");
        stringBuilder.append(realmGet$phoneNumber() != null ? realmGet$phoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lat:");
        stringBuilder.append(realmGet$lat() != null ? realmGet$lat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lon:");
        stringBuilder.append(realmGet$lon() != null ? realmGet$lon() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{photoUrl:");
        stringBuilder.append(realmGet$photoUrl() != null ? realmGet$photoUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{photoUrlThumb:");
        stringBuilder.append(realmGet$photoUrlThumb() != null ? realmGet$photoUrlThumb() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{privateClub:");
        stringBuilder.append(realmGet$privateClub() != null ? realmGet$privateClub() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showTax:");
        stringBuilder.append(realmGet$showTax() != null ? realmGet$showTax() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy aClub = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aClub.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aClub.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aClub.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
