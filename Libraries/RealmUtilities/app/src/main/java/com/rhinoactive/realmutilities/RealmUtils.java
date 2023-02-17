package com.rhinoactive.realmutilities;

import android.content.Context;

import com.rhinoactive.realmutilities.savers.RealmListSaver;
import com.rhinoactive.realmutilities.savers.SingleRealmObjectSaver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by Hunter Andrin on 2018-01-04.
 */

public class RealmUtils {

    public static void initRealm(Context appContext) {
        Realm.init(appContext);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public static <T extends RealmModel> void saveRealmObject(final T realmObject) {
        SingleRealmObjectSaver<T> realmObjectSaver = new SingleRealmObjectSaver<>();
        realmObjectSaver.saveRealmObject(realmObject);
    }

    public static <T extends RealmModel> void saveMap(Map<Integer, T> map) {
        final List<T> list = new ArrayList<>(map.values());
        saveList(list);
    }

    public static <T extends RealmModel> void saveList(List<T> list) {
        RealmListSaver<T, List<T>> realmObjectSaver = new RealmListSaver<>();
        realmObjectSaver.saveRealmObject(list);
    }
}
