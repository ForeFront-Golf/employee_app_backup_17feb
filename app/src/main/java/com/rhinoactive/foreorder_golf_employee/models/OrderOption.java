package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class OrderOption extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.OPTION_ITEM_ID)
    @Getter
    private String optionItemId;
    @SerializedName(Constants.OPTION_GROUP_ID)
    @Getter
    private String optionGroupId;
    @Getter
    private Boolean available;
    @Getter
    private String desc;
    @Getter
    private String name;
    @Getter
    private Float price;
    @Getter
    private Boolean valid;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
}
