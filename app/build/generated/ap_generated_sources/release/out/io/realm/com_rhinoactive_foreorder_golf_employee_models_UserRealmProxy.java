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
public class com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy extends com.rhinoactive.foreorder_golf_employee.models.User
    implements RealmObjectProxy, com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long userIdColKey;
        long firstNameColKey;
        long lastNameColKey;
        long emailColKey;
        long phoneNumberColKey;
        long permLvlColKey;
        long ratingColKey;
        long profilePhotoUrlColKey;
        long validColKey;
        long ratingCountColKey;
        long phoneValidColKey;
        long bannedColKey;
        long modifiedAtColKey;
        long userLocationColKey;
        long distanceAwayTextColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(15);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.userIdColKey = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.firstNameColKey = addColumnDetails("firstName", "firstName", objectSchemaInfo);
            this.lastNameColKey = addColumnDetails("lastName", "lastName", objectSchemaInfo);
            this.emailColKey = addColumnDetails("email", "email", objectSchemaInfo);
            this.phoneNumberColKey = addColumnDetails("phoneNumber", "phoneNumber", objectSchemaInfo);
            this.permLvlColKey = addColumnDetails("permLvl", "permLvl", objectSchemaInfo);
            this.ratingColKey = addColumnDetails("rating", "rating", objectSchemaInfo);
            this.profilePhotoUrlColKey = addColumnDetails("profilePhotoUrl", "profilePhotoUrl", objectSchemaInfo);
            this.validColKey = addColumnDetails("valid", "valid", objectSchemaInfo);
            this.ratingCountColKey = addColumnDetails("ratingCount", "ratingCount", objectSchemaInfo);
            this.phoneValidColKey = addColumnDetails("phoneValid", "phoneValid", objectSchemaInfo);
            this.bannedColKey = addColumnDetails("banned", "banned", objectSchemaInfo);
            this.modifiedAtColKey = addColumnDetails("modifiedAt", "modifiedAt", objectSchemaInfo);
            this.userLocationColKey = addColumnDetails("userLocation", "userLocation", objectSchemaInfo);
            this.distanceAwayTextColKey = addColumnDetails("distanceAwayText", "distanceAwayText", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.userIdColKey = src.userIdColKey;
            dst.firstNameColKey = src.firstNameColKey;
            dst.lastNameColKey = src.lastNameColKey;
            dst.emailColKey = src.emailColKey;
            dst.phoneNumberColKey = src.phoneNumberColKey;
            dst.permLvlColKey = src.permLvlColKey;
            dst.ratingColKey = src.ratingColKey;
            dst.profilePhotoUrlColKey = src.profilePhotoUrlColKey;
            dst.validColKey = src.validColKey;
            dst.ratingCountColKey = src.ratingCountColKey;
            dst.phoneValidColKey = src.phoneValidColKey;
            dst.bannedColKey = src.bannedColKey;
            dst.modifiedAtColKey = src.modifiedAtColKey;
            dst.userLocationColKey = src.userLocationColKey;
            dst.distanceAwayTextColKey = src.distanceAwayTextColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.rhinoactive.foreorder_golf_employee.models.User> proxyState;

    com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rhinoactive.foreorder_golf_employee.models.User>(this);
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
    public String realmGet$firstName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstNameColKey);
    }

    @Override
    public void realmSet$firstName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.firstNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lastName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastNameColKey);
    }

    @Override
    public void realmSet$lastName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lastNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailColKey);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailColKey, value);
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
    public String realmGet$permLvl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.permLvlColKey);
    }

    @Override
    public void realmSet$permLvl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.permLvlColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.permLvlColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.permLvlColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.permLvlColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Float realmGet$rating() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.ratingColKey)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.ratingColKey);
    }

    @Override
    public void realmSet$rating(Float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ratingColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setFloat(columnInfo.ratingColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ratingColKey);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.ratingColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$profilePhotoUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.profilePhotoUrlColKey);
    }

    @Override
    public void realmSet$profilePhotoUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.profilePhotoUrlColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.profilePhotoUrlColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.profilePhotoUrlColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.profilePhotoUrlColKey, value);
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
    public Integer realmGet$ratingCount() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.ratingCountColKey)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.ratingCountColKey);
    }

    @Override
    public void realmSet$ratingCount(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ratingCountColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setLong(columnInfo.ratingCountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ratingCountColKey);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.ratingCountColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$phoneValid() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.phoneValidColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.phoneValidColKey);
    }

    @Override
    public void realmSet$phoneValid(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneValidColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.phoneValidColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneValidColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.phoneValidColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$banned() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.bannedColKey)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.bannedColKey);
    }

    @Override
    public void realmSet$banned(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bannedColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.bannedColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bannedColKey);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.bannedColKey, value);
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
    public com.rhinoactive.foreorder_golf_employee.models.UserLocation realmGet$userLocation() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userLocationColKey)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class, proxyState.getRow$realm().getLink(columnInfo.userLocationColKey), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$userLocation(com.rhinoactive.foreorder_golf_employee.models.UserLocation value) {
        Realm realm = (Realm) proxyState.getRealm$realm();
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("userLocation")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = realm.copyToRealmOrUpdate(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userLocationColKey);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userLocationColKey, row.getObjectKey(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userLocationColKey);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userLocationColKey, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getObjectKey());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$distanceAwayText() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.distanceAwayTextColKey);
    }

    @Override
    public void realmSet$distanceAwayText(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.distanceAwayTextColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.distanceAwayTextColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.distanceAwayTextColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.distanceAwayTextColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "User", false, 15, 0);
        builder.addPersistedProperty(NO_ALIAS, "userId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "firstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "phoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "permLvl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "rating", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "profilePhotoUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "valid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "ratingCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "phoneValid", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "banned", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "modifiedAt", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty(NO_ALIAS, "userLocation", RealmFieldType.OBJECT, "UserLocation");
        builder.addPersistedProperty(NO_ALIAS, "distanceAwayText", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.rhinoactive.foreorder_golf_employee.models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.rhinoactive.foreorder_golf_employee.models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
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
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userLocation")) {
                excludeFields.add("userLocation");
            }
            if (json.has("userId")) {
                if (json.isNull("userId")) {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy) realm.createObjectInternal(com.rhinoactive.foreorder_golf_employee.models.User.class, json.getInt("userId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
            }
        }

        final com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) obj;
        if (json.has("firstName")) {
            if (json.isNull("firstName")) {
                objProxy.realmSet$firstName(null);
            } else {
                objProxy.realmSet$firstName((String) json.getString("firstName"));
            }
        }
        if (json.has("lastName")) {
            if (json.isNull("lastName")) {
                objProxy.realmSet$lastName(null);
            } else {
                objProxy.realmSet$lastName((String) json.getString("lastName"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("phoneNumber")) {
            if (json.isNull("phoneNumber")) {
                objProxy.realmSet$phoneNumber(null);
            } else {
                objProxy.realmSet$phoneNumber((String) json.getString("phoneNumber"));
            }
        }
        if (json.has("permLvl")) {
            if (json.isNull("permLvl")) {
                objProxy.realmSet$permLvl(null);
            } else {
                objProxy.realmSet$permLvl((String) json.getString("permLvl"));
            }
        }
        if (json.has("rating")) {
            if (json.isNull("rating")) {
                objProxy.realmSet$rating(null);
            } else {
                objProxy.realmSet$rating((float) json.getDouble("rating"));
            }
        }
        if (json.has("profilePhotoUrl")) {
            if (json.isNull("profilePhotoUrl")) {
                objProxy.realmSet$profilePhotoUrl(null);
            } else {
                objProxy.realmSet$profilePhotoUrl((String) json.getString("profilePhotoUrl"));
            }
        }
        if (json.has("valid")) {
            if (json.isNull("valid")) {
                objProxy.realmSet$valid(null);
            } else {
                objProxy.realmSet$valid((boolean) json.getBoolean("valid"));
            }
        }
        if (json.has("ratingCount")) {
            if (json.isNull("ratingCount")) {
                objProxy.realmSet$ratingCount(null);
            } else {
                objProxy.realmSet$ratingCount((int) json.getInt("ratingCount"));
            }
        }
        if (json.has("phoneValid")) {
            if (json.isNull("phoneValid")) {
                objProxy.realmSet$phoneValid(null);
            } else {
                objProxy.realmSet$phoneValid((boolean) json.getBoolean("phoneValid"));
            }
        }
        if (json.has("banned")) {
            if (json.isNull("banned")) {
                objProxy.realmSet$banned(null);
            } else {
                objProxy.realmSet$banned((boolean) json.getBoolean("banned"));
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
        if (json.has("userLocation")) {
            if (json.isNull("userLocation")) {
                objProxy.realmSet$userLocation(null);
            } else {
                com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("userLocation"), update);
                objProxy.realmSet$userLocation(userLocationObj);
            }
        }
        if (json.has("distanceAwayText")) {
            if (json.isNull("distanceAwayText")) {
                objProxy.realmSet$distanceAwayText(null);
            } else {
                objProxy.realmSet$distanceAwayText((String) json.getString("distanceAwayText"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rhinoactive.foreorder_golf_employee.models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.rhinoactive.foreorder_golf_employee.models.User obj = new com.rhinoactive.foreorder_golf_employee.models.User();
        final com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface objProxy = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) obj;
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
            } else if (name.equals("firstName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$firstName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$firstName(null);
                }
            } else if (name.equals("lastName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lastName(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("phoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneNumber(null);
                }
            } else if (name.equals("permLvl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$permLvl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$permLvl(null);
                }
            } else if (name.equals("rating")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rating((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rating(null);
                }
            } else if (name.equals("profilePhotoUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$profilePhotoUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$profilePhotoUrl(null);
                }
            } else if (name.equals("valid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$valid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$valid(null);
                }
            } else if (name.equals("ratingCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ratingCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ratingCount(null);
                }
            } else if (name.equals("phoneValid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneValid((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneValid(null);
                }
            } else if (name.equals("banned")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$banned((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$banned(null);
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
            } else if (name.equals("userLocation")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$userLocation(null);
                } else {
                    com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$userLocation(userLocationObj);
                }
            } else if (name.equals("distanceAwayText")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$distanceAwayText((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$distanceAwayText(null);
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

    static com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class), false, Collections.<String>emptyList());
        io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy obj = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.rhinoactive.foreorder_golf_employee.models.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.rhinoactive.foreorder_golf_employee.models.User) cachedRealmObject;
        }

        com.rhinoactive.foreorder_golf_employee.models.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
            long pkColumnKey = columnInfo.userIdColKey;
            Number value = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId();
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
                    realmObject = new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.rhinoactive.foreorder_golf_employee.models.User copy(Realm realm, UserColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rhinoactive.foreorder_golf_employee.models.User) cachedRealmObject;
        }

        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface unmanagedSource = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.userIdColKey, unmanagedSource.realmGet$userId());
        builder.addString(columnInfo.firstNameColKey, unmanagedSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameColKey, unmanagedSource.realmGet$lastName());
        builder.addString(columnInfo.emailColKey, unmanagedSource.realmGet$email());
        builder.addString(columnInfo.phoneNumberColKey, unmanagedSource.realmGet$phoneNumber());
        builder.addString(columnInfo.permLvlColKey, unmanagedSource.realmGet$permLvl());
        builder.addFloat(columnInfo.ratingColKey, unmanagedSource.realmGet$rating());
        builder.addString(columnInfo.profilePhotoUrlColKey, unmanagedSource.realmGet$profilePhotoUrl());
        builder.addBoolean(columnInfo.validColKey, unmanagedSource.realmGet$valid());
        builder.addInteger(columnInfo.ratingCountColKey, unmanagedSource.realmGet$ratingCount());
        builder.addBoolean(columnInfo.phoneValidColKey, unmanagedSource.realmGet$phoneValid());
        builder.addBoolean(columnInfo.bannedColKey, unmanagedSource.realmGet$banned());
        builder.addDate(columnInfo.modifiedAtColKey, unmanagedSource.realmGet$modifiedAt());
        builder.addString(columnInfo.distanceAwayTextColKey, unmanagedSource.realmGet$distanceAwayText());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = unmanagedSource.realmGet$userLocation();
        if (userLocationObj == null) {
            managedCopy.realmSet$userLocation(null);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.UserLocation cacheuserLocation = (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cache.get(userLocationObj);
            if (cacheuserLocation != null) {
                managedCopy.realmSet$userLocation(cacheuserLocation);
            } else {
                managedCopy.realmSet$userLocation(com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class), userLocationObj, update, cache, flags));
            }
        }

        return managedCopy;
    }

    public static long insert(Realm realm, com.rhinoactive.foreorder_golf_employee.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long pkColumnKey = columnInfo.userIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$firstName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
        }
        String realmGet$lastName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
        }
        String realmGet$email = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        }
        String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        }
        String realmGet$permLvl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$permLvl();
        if (realmGet$permLvl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permLvlColKey, objKey, realmGet$permLvl, false);
        }
        Float realmGet$rating = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$rating();
        if (realmGet$rating != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.ratingColKey, objKey, realmGet$rating, false);
        }
        String realmGet$profilePhotoUrl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$profilePhotoUrl();
        if (realmGet$profilePhotoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, realmGet$profilePhotoUrl, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        }
        Number realmGet$ratingCount = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$ratingCount();
        if (realmGet$ratingCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.ratingCountColKey, objKey, realmGet$ratingCount.longValue(), false);
        }
        Boolean realmGet$phoneValid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneValid();
        if (realmGet$phoneValid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.phoneValidColKey, objKey, realmGet$phoneValid, false);
        }
        Boolean realmGet$banned = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$banned();
        if (realmGet$banned != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bannedColKey, objKey, realmGet$banned, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        }

        com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userLocation();
        if (userLocationObj != null) {
            Long cacheuserLocation = cache.get(userLocationObj);
            if (cacheuserLocation == null) {
                cacheuserLocation = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insert(realm, userLocationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userLocationColKey, objKey, cacheuserLocation, false);
        }
        String realmGet$distanceAwayText = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$distanceAwayText();
        if (realmGet$distanceAwayText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, realmGet$distanceAwayText, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.User object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$firstName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
            }
            String realmGet$lastName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
            }
            String realmGet$email = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            }
            String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            }
            String realmGet$permLvl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$permLvl();
            if (realmGet$permLvl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.permLvlColKey, objKey, realmGet$permLvl, false);
            }
            Float realmGet$rating = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$rating();
            if (realmGet$rating != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.ratingColKey, objKey, realmGet$rating, false);
            }
            String realmGet$profilePhotoUrl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$profilePhotoUrl();
            if (realmGet$profilePhotoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, realmGet$profilePhotoUrl, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            }
            Number realmGet$ratingCount = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$ratingCount();
            if (realmGet$ratingCount != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.ratingCountColKey, objKey, realmGet$ratingCount.longValue(), false);
            }
            Boolean realmGet$phoneValid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneValid();
            if (realmGet$phoneValid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.phoneValidColKey, objKey, realmGet$phoneValid, false);
            }
            Boolean realmGet$banned = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$banned();
            if (realmGet$banned != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.bannedColKey, objKey, realmGet$banned, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            }

            com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userLocation();
            if (userLocationObj != null) {
                Long cacheuserLocation = cache.get(userLocationObj);
                if (cacheuserLocation == null) {
                    cacheuserLocation = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insert(realm, userLocationObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userLocationColKey, objKey, cacheuserLocation, false);
            }
            String realmGet$distanceAwayText = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$distanceAwayText();
            if (realmGet$distanceAwayText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, realmGet$distanceAwayText, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rhinoactive.foreorder_golf_employee.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long pkColumnKey = columnInfo.userIdColKey;
        Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
        }
        cache.put(object, objKey);
        String realmGet$firstName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstNameColKey, objKey, false);
        }
        String realmGet$lastName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastNameColKey, objKey, false);
        }
        String realmGet$email = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
        }
        String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
        }
        String realmGet$permLvl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$permLvl();
        if (realmGet$permLvl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permLvlColKey, objKey, realmGet$permLvl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.permLvlColKey, objKey, false);
        }
        Float realmGet$rating = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$rating();
        if (realmGet$rating != null) {
            Table.nativeSetFloat(tableNativePtr, columnInfo.ratingColKey, objKey, realmGet$rating, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ratingColKey, objKey, false);
        }
        String realmGet$profilePhotoUrl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$profilePhotoUrl();
        if (realmGet$profilePhotoUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, realmGet$profilePhotoUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, false);
        }
        Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$valid();
        if (realmGet$valid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
        }
        Number realmGet$ratingCount = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$ratingCount();
        if (realmGet$ratingCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.ratingCountColKey, objKey, realmGet$ratingCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ratingCountColKey, objKey, false);
        }
        Boolean realmGet$phoneValid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneValid();
        if (realmGet$phoneValid != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.phoneValidColKey, objKey, realmGet$phoneValid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneValidColKey, objKey, false);
        }
        Boolean realmGet$banned = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$banned();
        if (realmGet$banned != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.bannedColKey, objKey, realmGet$banned, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bannedColKey, objKey, false);
        }
        java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$modifiedAt();
        if (realmGet$modifiedAt != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
        }

        com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userLocation();
        if (userLocationObj != null) {
            Long cacheuserLocation = cache.get(userLocationObj);
            if (cacheuserLocation == null) {
                cacheuserLocation = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insertOrUpdate(realm, userLocationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userLocationColKey, objKey, cacheuserLocation, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userLocationColKey, objKey);
        }
        String realmGet$distanceAwayText = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$distanceAwayText();
        if (realmGet$distanceAwayText != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, realmGet$distanceAwayText, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
        long pkColumnKey = columnInfo.userIdColKey;
        com.rhinoactive.foreorder_golf_employee.models.User object = null;
        while (objects.hasNext()) {
            object = (com.rhinoactive.foreorder_golf_employee.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            Object primaryKeyValue = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userId());
            }
            cache.put(object, objKey);
            String realmGet$firstName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.firstNameColKey, objKey, false);
            }
            String realmGet$lastName = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastNameColKey, objKey, false);
            }
            String realmGet$email = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailColKey, objKey, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailColKey, objKey, false);
            }
            String realmGet$phoneNumber = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
            }
            String realmGet$permLvl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$permLvl();
            if (realmGet$permLvl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.permLvlColKey, objKey, realmGet$permLvl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.permLvlColKey, objKey, false);
            }
            Float realmGet$rating = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$rating();
            if (realmGet$rating != null) {
                Table.nativeSetFloat(tableNativePtr, columnInfo.ratingColKey, objKey, realmGet$rating, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ratingColKey, objKey, false);
            }
            String realmGet$profilePhotoUrl = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$profilePhotoUrl();
            if (realmGet$profilePhotoUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, realmGet$profilePhotoUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.profilePhotoUrlColKey, objKey, false);
            }
            Boolean realmGet$valid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$valid();
            if (realmGet$valid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.validColKey, objKey, realmGet$valid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.validColKey, objKey, false);
            }
            Number realmGet$ratingCount = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$ratingCount();
            if (realmGet$ratingCount != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.ratingCountColKey, objKey, realmGet$ratingCount.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ratingCountColKey, objKey, false);
            }
            Boolean realmGet$phoneValid = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$phoneValid();
            if (realmGet$phoneValid != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.phoneValidColKey, objKey, realmGet$phoneValid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneValidColKey, objKey, false);
            }
            Boolean realmGet$banned = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$banned();
            if (realmGet$banned != null) {
                Table.nativeSetBoolean(tableNativePtr, columnInfo.bannedColKey, objKey, realmGet$banned, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bannedColKey, objKey, false);
            }
            java.util.Date realmGet$modifiedAt = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$modifiedAt();
            if (realmGet$modifiedAt != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.modifiedAtColKey, objKey, realmGet$modifiedAt.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.modifiedAtColKey, objKey, false);
            }

            com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$userLocation();
            if (userLocationObj != null) {
                Long cacheuserLocation = cache.get(userLocationObj);
                if (cacheuserLocation == null) {
                    cacheuserLocation = com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insertOrUpdate(realm, userLocationObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userLocationColKey, objKey, cacheuserLocation, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userLocationColKey, objKey);
            }
            String realmGet$distanceAwayText = ((com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) object).realmGet$distanceAwayText();
            if (realmGet$distanceAwayText != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, realmGet$distanceAwayText, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.distanceAwayTextColKey, objKey, false);
            }
        }
    }

    public static com.rhinoactive.foreorder_golf_employee.models.User createDetachedCopy(com.rhinoactive.foreorder_golf_employee.models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rhinoactive.foreorder_golf_employee.models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rhinoactive.foreorder_golf_employee.models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rhinoactive.foreorder_golf_employee.models.User) cachedObject.object;
            }
            unmanagedObject = (com.rhinoactive.foreorder_golf_employee.models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface unmanagedCopy = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) unmanagedObject;
        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface realmSource = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$firstName(realmSource.realmGet$firstName());
        unmanagedCopy.realmSet$lastName(realmSource.realmGet$lastName());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$phoneNumber(realmSource.realmGet$phoneNumber());
        unmanagedCopy.realmSet$permLvl(realmSource.realmGet$permLvl());
        unmanagedCopy.realmSet$rating(realmSource.realmGet$rating());
        unmanagedCopy.realmSet$profilePhotoUrl(realmSource.realmGet$profilePhotoUrl());
        unmanagedCopy.realmSet$valid(realmSource.realmGet$valid());
        unmanagedCopy.realmSet$ratingCount(realmSource.realmGet$ratingCount());
        unmanagedCopy.realmSet$phoneValid(realmSource.realmGet$phoneValid());
        unmanagedCopy.realmSet$banned(realmSource.realmGet$banned());
        unmanagedCopy.realmSet$modifiedAt(realmSource.realmGet$modifiedAt());

        // Deep copy of userLocation
        unmanagedCopy.realmSet$userLocation(com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createDetachedCopy(realmSource.realmGet$userLocation(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$distanceAwayText(realmSource.realmGet$distanceAwayText());

        return unmanagedObject;
    }

    static com.rhinoactive.foreorder_golf_employee.models.User update(Realm realm, UserColumnInfo columnInfo, com.rhinoactive.foreorder_golf_employee.models.User realmObject, com.rhinoactive.foreorder_golf_employee.models.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface realmObjectTarget = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) realmObject;
        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface realmObjectSource = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.rhinoactive.foreorder_golf_employee.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.userIdColKey, realmObjectSource.realmGet$userId());
        builder.addString(columnInfo.firstNameColKey, realmObjectSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameColKey, realmObjectSource.realmGet$lastName());
        builder.addString(columnInfo.emailColKey, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.phoneNumberColKey, realmObjectSource.realmGet$phoneNumber());
        builder.addString(columnInfo.permLvlColKey, realmObjectSource.realmGet$permLvl());
        builder.addFloat(columnInfo.ratingColKey, realmObjectSource.realmGet$rating());
        builder.addString(columnInfo.profilePhotoUrlColKey, realmObjectSource.realmGet$profilePhotoUrl());
        builder.addBoolean(columnInfo.validColKey, realmObjectSource.realmGet$valid());
        builder.addInteger(columnInfo.ratingCountColKey, realmObjectSource.realmGet$ratingCount());
        builder.addBoolean(columnInfo.phoneValidColKey, realmObjectSource.realmGet$phoneValid());
        builder.addBoolean(columnInfo.bannedColKey, realmObjectSource.realmGet$banned());
        builder.addDate(columnInfo.modifiedAtColKey, realmObjectSource.realmGet$modifiedAt());

        com.rhinoactive.foreorder_golf_employee.models.UserLocation userLocationObj = realmObjectSource.realmGet$userLocation();
        if (userLocationObj == null) {
            builder.addNull(columnInfo.userLocationColKey);
        } else {
            com.rhinoactive.foreorder_golf_employee.models.UserLocation cacheuserLocation = (com.rhinoactive.foreorder_golf_employee.models.UserLocation) cache.get(userLocationObj);
            if (cacheuserLocation != null) {
                builder.addObject(columnInfo.userLocationColKey, cacheuserLocation);
            } else {
                builder.addObject(columnInfo.userLocationColKey, com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.copyOrUpdate(realm, (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class), userLocationObj, true, cache, flags));
            }
        }
        builder.addString(columnInfo.distanceAwayTextColKey, realmObjectSource.realmGet$distanceAwayText());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstName:");
        stringBuilder.append(realmGet$firstName() != null ? realmGet$firstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastName:");
        stringBuilder.append(realmGet$lastName() != null ? realmGet$lastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneNumber:");
        stringBuilder.append(realmGet$phoneNumber() != null ? realmGet$phoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{permLvl:");
        stringBuilder.append(realmGet$permLvl() != null ? realmGet$permLvl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rating:");
        stringBuilder.append(realmGet$rating() != null ? realmGet$rating() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profilePhotoUrl:");
        stringBuilder.append(realmGet$profilePhotoUrl() != null ? realmGet$profilePhotoUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valid:");
        stringBuilder.append(realmGet$valid() != null ? realmGet$valid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ratingCount:");
        stringBuilder.append(realmGet$ratingCount() != null ? realmGet$ratingCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneValid:");
        stringBuilder.append(realmGet$phoneValid() != null ? realmGet$phoneValid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{banned:");
        stringBuilder.append(realmGet$banned() != null ? realmGet$banned() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{modifiedAt:");
        stringBuilder.append(realmGet$modifiedAt() != null ? realmGet$modifiedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userLocation:");
        stringBuilder.append(realmGet$userLocation() != null ? "UserLocation" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{distanceAwayText:");
        stringBuilder.append(realmGet$distanceAwayText() != null ? realmGet$distanceAwayText() : "null");
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
        com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy aUser = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUser.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUser.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
