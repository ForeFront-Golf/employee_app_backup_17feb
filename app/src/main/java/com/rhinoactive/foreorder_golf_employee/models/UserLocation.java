package com.rhinoactive.foreorder_golf_employee.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-11.
 */

public class UserLocation extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.USER_ID)
    @Getter
    private Integer userId;
    @Getter
    private Double lat;
    @Getter
    private Double lon;

    public UserLocation() {
    }

    public UserLocation(Double lat, Double lon, Integer userId) {
        this.lat = lat;
        this.lon = lon;
        this.userId = userId;
    }

    public LatLng getLatLng() {
        return new LatLng(lat, lon);
    }
}
