package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class Club extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.CLUB_ID)
    @Getter
    private Integer clubId;
    @Getter
    private String name;
    @SerializedName(Constants.PHONE_NUMBER)
    @Getter
    private String phoneNumber;
    @Getter
    private String address;
    @Getter
    private Double lat;
    @Getter
    private Double lon;
    @SerializedName(Constants.PHOTO_URL)
    @Getter
    private String photoUrl;
    @SerializedName(Constants.PHOTO_URL_THUMB)
    @Getter
    private String photoUrlThumb;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
    @SerializedName(Constants.PRIVATE)
    @Getter
    private Boolean privateClub;
    @SerializedName(Constants.SHOW_TAX)
    @Getter
    private Boolean showTax;
    @Ignore
    @Getter
    @Setter
    private Double dist;
}
