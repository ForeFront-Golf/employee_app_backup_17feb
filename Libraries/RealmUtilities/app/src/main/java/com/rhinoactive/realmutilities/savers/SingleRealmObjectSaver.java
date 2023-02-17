package com.rhinoactive.realmutilities.savers;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by Hunter Andrin on 2018-01-04.
 */

public class SingleRealmObjectSaver<T extends RealmModel> extends RealmObjectSaver<T> {

    @Override
    protected void insertToRealmOrUpdate(Realm realm, T realmObject) {
        realm.insertOrUpdate(realmObject);
    }
}
