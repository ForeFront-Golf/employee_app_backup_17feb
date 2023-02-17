package com.rhinoactive.realmutilities.retrievers;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Hunter Andrin on 2018-01-03.
 */

public abstract class RealmObjectListRetriever<T extends RealmObject> extends RealmObjectRetriever<List<T>, T> {

    public RealmObjectListRetriever(@Nullable Realm realm) {
        super(realm);
    }

    protected abstract void handleSingleRealmObject(T realmObject);

    protected List<T> handleResults(Realm realm, RealmResults<T> results) {
        List<T> listOfRealmObjects = new ArrayList<>();
        for (T realmInstanceOfObject : results) {
            //Must perform a deep copy of results in order to avoid realm threading issues
            T realmObject = realm.copyFromRealm(realmInstanceOfObject);
            listOfRealmObjects.add(realmObject);
            handleSingleRealmObject(realmObject);
        }
        return listOfRealmObjects;
    }
}
