package com.rhinoactive.realmutilities.savers;

import java.util.Collection;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by Hunter Andrin on 2018-01-04.
 */

public class RealmListSaver<E extends RealmModel, T extends Collection<E>> extends RealmObjectSaver<T> {

    @Override
    protected void insertToRealmOrUpdate(Realm realm, T realmObject) {
        realm.insertOrUpdate(realmObject);
    }
}
