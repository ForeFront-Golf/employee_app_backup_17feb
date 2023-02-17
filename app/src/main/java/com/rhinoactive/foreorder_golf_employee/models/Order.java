package com.rhinoactive.foreorder_golf_employee.models;

import com.google.gson.annotations.SerializedName;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class Order extends RealmObject {

    @PrimaryKey
    @SerializedName(Constants.ORDER_ID)
    @Getter
    private Integer orderId;
    @SerializedName(Constants.USER_TABLE)
    @Getter
    @Setter
    private User user;
    @SerializedName(Constants.CURRENT_STATE)
    @Getter
    @Setter
    private String currentState;
    @SerializedName(Constants.ORDER_NUM)
    @Getter
    private Integer orderNum;
    @SerializedName(Constants.CLUB_ID)
    @Getter
    private Integer clubId;
    @SerializedName(Constants.MENU_ID)
    @Getter
    private Integer menuId;
    @Getter
    private Boolean delivery;
    @Getter
    private Boolean fulfilled;
    @SerializedName(Constants.PRICE_TOTAL)
    @Getter
    private Float priceTotal;
    @SerializedName(Constants.PRICE_TOTAL_WITH_TAX)
    @Getter
    private Float priceTotalWithTax;
    @SerializedName(Constants.TAX_AMOUNT)
    @Getter
    private Float taxAmount;
    @Getter
    private Integer quantity;
    @SerializedName(Constants.USER_ID)
    @Getter
    private Integer userId;
    @SerializedName(Constants.CREATED_AT)
    @Getter
    private Date createdAt;
    @SerializedName(Constants.MODIFIED_AT)
    @Getter
    private Date modifiedAt;
    @SerializedName(Constants.MEMBER_CODE)
    @Getter
    private String memberCode;
    @SerializedName(Constants.ITEMS)
    @Getter
    private RealmList<OrderItem> orderItems = new RealmList<>();
}
