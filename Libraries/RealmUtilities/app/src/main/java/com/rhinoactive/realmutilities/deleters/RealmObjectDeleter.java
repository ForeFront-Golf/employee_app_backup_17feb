package com.rhinoactive.realmutilities.deleters;

import androidx.annotation.Nullable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by hunter on 2018-03-02.
 */

public abstract class RealmObjectDeleter <T extends RealmObject> {

    private Realm realm;
    private RealmQuery<T> realmQuery;
    private boolean shouldCloseRealm = false;

    protected abstract Class<T> getRealmObjectClass();

    public RealmObjectDeleter(@Nullable Realm realm) {
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

    public void getRealmObject() {
        RealmResults<T> results = realmQuery.findAll();
        if (results.size() > 0) {
            // Delete all matches
            results.deleteAllFromRealm();
        }
        if (shouldCloseRealm) {
            realm.close();
        }
    }
}
