package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class OrderItem extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.ORDER_ITEM_ID)
    @Getter
    private Integer orderItemId;
    @SerializedName(Constants.MENU_ITEM_ID)
    @Getter
    private Integer menuItemId;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
    @SerializedName(Constants.ORDER_ID)
    @Getter
    private Integer orderId;
    @Getter
    private String name;
    @SerializedName(Constants.ORDER_OPTIONS)
    @Getter
    private RealmList<OrderOption> orderOptions = new RealmList<>();
    @Getter
    private Float price;
    @SerializedName(Constants.SPECIAL_REQUEST)
    @Getter
    private String specialRequest;
    @Getter
    private Integer quantity;
    @Getter
    private Boolean valid;


    public boolean hasSpecialRequest() {
        return specialRequest != null && !specialRequest.equals("");
    }
}
