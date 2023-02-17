## Utility Library that provides helper methods for performing realm functions. ##

# To integrate this library into your project: #

1) In the terminal, navigate to your project's root level directory and execute the command:

git submodule add https://bitbucket.org/rhinoactive/realmutilities.git ./Libraries/RealmUtilities

This adds the RealmUtilities submodule to you project.

2) In you app's settings.gradle file add the following lines:

```
#!java


include ':realmutilities'
project(':realmutilities').projectDir = new File('Libraries/RealmUtilities/app')
```


3) In your app's build.gradle file add the following dependency:


```
#!java

dependencies {
/*
other dependencies
*/
compile project(':realmutilities')
}
```

## To initilize realm in your project:

###1) In your project level build.gradle file, add realm as a dependency ###

```
#!java

buildscript {
    repositories {
        ...
    }
    dependencies {
        ...
        classpath "io.realm:realm-gradle-plugin:4.3.1"
    }
}
```

###2) In your app level build.gradle file, apply the realm plugin ###

```
#!java

apply plugin: 'realm-android'
```

###3) Call this method in the onCreate method of your application class ###


```
#!java

RealmUtils.initRealm(appContext);
```

## To save a single object to realm, call the following method, passing in an object that extends RealmObject: ##

```
#!java

public static <T extends RealmObject> void saveRealmObject(final T realmObject);

//Example:

RealmUtils.saveRealmObject(venue);

public class Venue extends RealmObject {

    @PrimaryKey
    @Getter
    @SerializedName(Constants.VENUE_ID)
    private Integer venueId;
    @Getter
    @SerializedName(Constants.VENUE_NAME)
    private String venueName;
}

```

## To save a list of RealmObjects, call the following method: ##

```
#!java

public static <T extends RealmObject> void saveList(List<T> list);

//Example:

RealmUtils.saveList(listOfVenues);
```

## To retrieve a single RealmObject: ##

### 1) Extend the SingleRealmObjectRetriever class: ###

Example:

```
#!java

public class CurrentUserRealmRetriever extends SingleRealmObjectRetriever<CurrentUserManager> {
    public CurrentUserRealmRetriever(@Nullable Realm realm) {
        super(realm);
    }

    @Override
    protected Class<CurrentUserManager> getRealmObjectClass() {
        return CurrentUserManager.class;
    }
}
```

### 2) Get the results from realm. Make sure to close the realm instance if you are instantiating one. If you pass null for the realm instance, the RealmRetriever class will create a realm instance and close it for you. The reason you would instantiate one yourself is if you were retrieving multiple objects from realm at a single time. ###

```
#!java

    @Nullable
    public static CurrentUserManager retrieveDataFromLocalDatabase(Integer currentUserManagerId) {
        Realm realm = Realm.getDefaultInstance();
        CurrentUserRealmRetriever currentUserRealmRetriever = new CurrentUserRealmRetriever(realm);
        currentUserRealmRetriever.setEqualTo(Constants.CURRENT_USER_MANAGER_ID, currentUserManagerId);
        CurrentUserManager currentUserManager = currentUserRealmRetriever.getRealmObject();
        realm.close();
        return currentUserManager;
    }
```

### Note: The setEqualTo method is optional. Call this method if you want to filter the results you get based on the value of an attribute. ###

### There are other methods available to filter and sort the realm results. ###


## To retrieve a list of RealmObjects: ##

### 1) Extend the RealmObjectListRetriever class: ###

Example: 

```
#!java

public class ChatsRealmRetriever extends RealmObjectListRetriever<Chat> {

	private CurrentUserManager currentUserManager;

    public ChatsRealmRetriever(@Nullable Realm realm, CurrentUserManager currentUserManager) {
        super(realm);
		this.currentUserManager = currentUserManager;
    }

    @Override
    protected void handleSingleRealmObject(Chat chat) {
        currentUserManager.getCurrentUserChats().getChats().put(chat.getChatId(), chat);
    }

    @Override
    protected Class<Chat> getRealmObjectClass() {
        return Chat.class;
    }
}
```

### 2) Get the results from realm ###

```
#!java

    @Nullable
    public static List<Chat> getCurrentUserChats(Realm realm, CurrentUserManager currentUserManager) {
        ChatsRealmRetriever chatsRealmRetriever = new ChatsRealmRetriever(realm, currentUserManager);
        return chatsRealmRetriever.getRealmObject();
    }
```

Note: Realm under the hood uses the getter and setter methods to populate the object's attributes when retrieving them from realm. So be cautious when creating custom getter and setter functionality.