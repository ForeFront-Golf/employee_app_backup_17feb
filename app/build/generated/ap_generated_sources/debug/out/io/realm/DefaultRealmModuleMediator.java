package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(10);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.User.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.Session.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.Order.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
        modelClasses.add(com.rhinoactive.foreorder_golf_employee.models.Club.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(10);
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.User.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.Session.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.Order.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.Menu.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.rhinoactive.foreorder_golf_employee.models.Club.class, io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return "UserLocation";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return "User";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return "Session";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return "OrderOption";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return "OrderItem";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return "Order";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return "MenuOrders";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return "Menu";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return "ClubMenus";
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return "Club";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("UserLocation")) {
            return com.rhinoactive.foreorder_golf_employee.models.UserLocation.class;
        }
        if (className.equals("User")) {
            return com.rhinoactive.foreorder_golf_employee.models.User.class;
        }
        if (className.equals("Session")) {
            return com.rhinoactive.foreorder_golf_employee.models.Session.class;
        }
        if (className.equals("OrderOption")) {
            return com.rhinoactive.foreorder_golf_employee.models.OrderOption.class;
        }
        if (className.equals("OrderItem")) {
            return com.rhinoactive.foreorder_golf_employee.models.OrderItem.class;
        }
        if (className.equals("Order")) {
            return com.rhinoactive.foreorder_golf_employee.models.Order.class;
        }
        if (className.equals("MenuOrders")) {
            return com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class;
        }
        if (className.equals("Menu")) {
            return com.rhinoactive.foreorder_golf_employee.models.Menu.class;
        }
        if (className.equals("ClubMenus")) {
            return com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class;
        }
        if (className.equals("Club")) {
            return com.rhinoactive.foreorder_golf_employee.models.Club.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return com.rhinoactive.foreorder_golf_employee.models.UserLocation.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.User.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.Session.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.OrderOption.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.OrderItem.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.Order.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.Menu.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class.isAssignableFrom(clazz)
                || com.rhinoactive.foreorder_golf_employee.models.Club.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy());
            }
            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
                return clazz.cast(new io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.UserLocationColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.UserLocationColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.UserLocation) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.UserColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.User.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.User) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.SessionColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.SessionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Session.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.Session) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.OrderOptionColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.OrderOptionColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.OrderOption) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.OrderItemColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.OrderItemColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.OrderItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.OrderColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.OrderColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Order.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.Order) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.MenuOrdersColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.MenuOrdersColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.MenuColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.MenuColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Menu.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.Menu) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.ClubMenusColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.ClubMenusColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) obj, update, cache, flags));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.ClubColumnInfo columnInfo = (com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.ClubColumnInfo) realm.getSchema().getColumnInfo(com.rhinoactive.foreorder_golf_employee.models.Club.class);
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.copyOrUpdate(realm, columnInfo, (com.rhinoactive.foreorder_golf_employee.models.Club) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.UserLocation) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.User) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Session) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderOption) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderItem) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Order) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Menu) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) object, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Club) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.UserLocation) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.User) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Session) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderOption) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderItem) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Order) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Menu) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insert(realm, (com.rhinoactive.foreorder_golf_employee.models.Club) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.UserLocation) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.User) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Session) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderOption) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderItem) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Order) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Menu) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) obj, cache);
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Club) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.UserLocation) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.User) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Session) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderOption) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.OrderItem) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Order) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.MenuOrders) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Menu) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.ClubMenus) object, cache);
            } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
                io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insertOrUpdate(realm, (com.rhinoactive.foreorder_golf_employee.models.Club) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
                    io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserLocationRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.UserLocation) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_UserRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_SessionRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.Session) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderOptionRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.OrderOption) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderItemRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.OrderItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_OrderRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.Order) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuOrdersRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.MenuOrders) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_MenuRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.Menu) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubMenusRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.ClubMenus) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return clazz.cast(io.realm.com_rhinoactive_foreorder_golf_employee_models_ClubRealmProxy.createDetachedCopy((com.rhinoactive.foreorder_golf_employee.models.Club) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            return false;
        }
        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.UserLocation.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.UserLocation");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.User.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.User");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Session.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.Session");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderOption.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.OrderOption");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.OrderItem.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.OrderItem");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Order.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.Order");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.MenuOrders.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.MenuOrders");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Menu.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.Menu");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.ClubMenus.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.ClubMenus");
        } else if (clazz.equals(com.rhinoactive.foreorder_golf_employee.models.Club.class)) {
            throw getNotEmbeddedClassException("com.rhinoactive.foreorder_golf_employee.models.Club");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
