package com.rhinoactive.realmutilities.retrievers;

import androidx.annotation.Nullable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Hunter Andrin on 2018-01-03.
 */

public abstract class RealmObjectRetriever<E, T extends RealmObject> {

    private Realm realm;
    private RealmQuery<T> realmQuery;
    private boolean shouldCloseRealm = false;

    protected abstract Class<T> getRealmObjectClass();

    protected abstract E handleResults(Realm realm, RealmResults<T> results);

    public RealmObjectRetriever(@Nullable Realm realm) {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
            shouldCloseRealm = true;
        }
        this.realm = realm;
        this.realmQuery = realm.where(getRealmObjectClass());
    }

    public void setEqualTo(String fieldName, Integer id) {
        this.realmQuery = realmQuery.equalTo(fieldName, id);
    }

    public void setNotEqualTo(String fieldName, Integer id) {
        this.realmQuery = realmQuery.notEqualTo(fieldName, id);
    }

    public void sortDescending(String fieldName) {
        this.realmQuery = realmQuery.sort(fieldName, Sort.DESCENDING);
    }

    public void sortAscending(String fieldName) {
        this.realmQuery = realmQuery.sort(fieldName, Sort.ASCENDING);
    }

    @Nullable
    public E getRealmObject() {
        E realmObjectResult = null;
        RealmResults<T> results = realmQuery.findAll();
        if (results.size() > 0) {
            realmObjectResult = handleResults(realm, results);
        }
        if (shouldCloseRealm) {
            realm.close();
        }
        return realmObjectResult;
    }
}
