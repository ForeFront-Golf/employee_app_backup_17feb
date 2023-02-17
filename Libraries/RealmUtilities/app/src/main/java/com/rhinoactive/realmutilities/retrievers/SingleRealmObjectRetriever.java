package com.rhinoactive.realmutilities.retrievers;

import androidx.annotation.Nullable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Hunter Andrin on 2018-01-03.
 */

public abstract class SingleRealmObjectRetriever<T extends RealmObject> extends RealmObjectRetriever<T, T> {

    public SingleRealmObjectRetriever(@Nullable Realm realm) {
        super(realm);
    }

    protected T handleResults(Realm realm, RealmResults<T> results) {
        T realmInstanceOfObject = results.get(0);
        //Must perform a deep copy of results in order to avoid realm threading issues
        return realm.copyFromRealm(realmInstanceOfObject);
    }
}
