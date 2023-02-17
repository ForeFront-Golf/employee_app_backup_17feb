package com.rhinoactive.foreorder_golf_employee.models;

import android.location.Location;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.generalutilities.DistanceUtils;

import java.util.Date;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by rhinodesktop on 2017-03-14.
 */

public class User extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.USER_ID)
    @Getter
    private Integer userId;
    @SerializedName(Constants.FIRST_NAME)
    @Getter
    private String firstName;
    @SerializedName(Constants.LAST_NAME)
    @Getter
    private String lastName;
    @Getter
    private String email;
    @SerializedName(Constants.PHONE_NUMBER)
    @Getter
    private String phoneNumber;
    @SerializedName(Constants.PERM_LVL)
    @Getter
    private String permLvl;
    @Getter
    private Float rating;
    @SerializedName(Constants.PROFILE_PHOTO_URL)
    @Getter
    @Setter
    private String profilePhotoUrl;
    @Getter
    private Boolean valid;
    @SerializedName(Constants.RATING_COUNT)
    @Getter
    private Integer ratingCount;
    @SerializedName(Constants.PHONE_VALID)
    @Getter
    private Boolean phoneValid;
    @Getter
    private Boolean banned;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
    @Getter
    @Setter
    private UserLocation userLocation;
    @Getter
    @Setter
    private String distanceAwayText = "N/A";

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String createProfileImageUrl() {
        return "public/user/" + userId + "/profile.jpg";
    }

    public boolean isPhoneNumberEmpty() {
        return (phoneNumber == null || phoneNumber.equals(""));
    }

    public void setUserLocationF(final Location location, Realm realm) {
        User user = realm.where(User.class).equalTo("userId", ForeOrderSharedPrefUtils.getCurrentUserId(ForeOrderApp.getAppContext())).findFirst();
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        user.setUserLocationF(new UserLocation(lat, lon, user.getUserId()), realm);
    }

    public void setUserLocationF(final UserLocation userLocation, Realm realm) {
        if (realm != null) {
            User user = realm.where(User.class).equalTo("userId", userLocation.getUserId()).findFirst();
            user.setUserLocation(realm.copyToRealmOrUpdate(userLocation));
            updateDistanceAwayFromCurrentUserText(user, realm);
        } else {
            try (Realm realm1 = Realm.getDefaultInstance()) {
                realm1.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User user = realm.where(User.class).equalTo("userId", userLocation.getUserId()).findFirst();
                        user.setUserLocation(realm.copyToRealmOrUpdate(userLocation));
                        updateDistanceAwayFromCurrentUserText(user, realm1);
                    }
                });
            }
        }
    }

    private void updateDistanceAwayFromCurrentUserText(User user, Realm realm) {
        User currentUser = realm
                .where(User.class)
                .equalTo("userId", ForeOrderSharedPrefUtils.getCurrentUserId(ForeOrderApp.getAppContext()))
                .findFirst();
        if (user != null && user.getUserLocation() != null) {
            UserLocation currentUserLocation = currentUser.getUserLocation();
            Double distanceAwayInMeter = DistanceUtils.distanceBetween(user.getUserLocation().getLat(), user.getUserLocation().getLon(),
                    currentUserLocation.getLat(), currentUserLocation.getLon());
            String unitText;
            if (distanceAwayInMeter < 1000) {
                unitText = ForeOrderResourceUtils.getInstance().strRes(R.string.m);
                distanceAwayText = String.format(Locale.ENGLISH, "%.0f %s", distanceAwayInMeter, unitText);
                user.setDistanceAwayText(distanceAwayText);
            } else {
                unitText = ForeOrderResourceUtils.getInstance().strRes(R.string.km);
                distanceAwayText = String.format(Locale.ENGLISH, "%.1f %s", distanceAwayInMeter / 1000, unitText);
                user.setDistanceAwayText(distanceAwayText);
            }
        }
    }
}
