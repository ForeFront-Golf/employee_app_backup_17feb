package com.rhinoactive.realmutilities.savers;

import io.realm.Realm;

/**
 * Created by Hunter Andrin on 2018-01-04.
 */

public abstract class RealmObjectSaver<T> {

    public void saveRealmObject(final T realmObject) {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    insertToRealmOrUpdate(realm, realmObject);
                }
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    protected abstract void insertToRealmOrUpdate(Realm realm, T realmObject);
}
