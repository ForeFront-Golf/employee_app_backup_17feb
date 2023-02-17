package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hunter Andrin on 2017-05-04.
 */

public class Menu extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.MENU_ID)
    @Getter
    private Integer menuId;
    @Getter
    private String name;
    @Getter
    private String desc;
    @SerializedName(Constants.CLUB_ID)
    @Getter
    private Integer clubId;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
    @Getter
    @Setter
    private Boolean selected = true;
}
