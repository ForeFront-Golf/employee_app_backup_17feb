package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by rhinodesktop on 2017-03-14.
 */

public class Session extends RealmObject{

    @PrimaryKey
    @SerializedName(Constants.SESSION_ID)
    @Getter
    private String sessionId;
    @SerializedName(Constants.USER_ID)
    @Getter
    private Integer userId;
    private Boolean valid;
    @SerializedName(Constants.CREATED_AT)
    private Date createdAt;
    @SerializedName(Constants.MODIFIED_AT)
    private Date modifiedAt;

}
