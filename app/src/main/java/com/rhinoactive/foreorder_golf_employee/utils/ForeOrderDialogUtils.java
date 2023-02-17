package com.rhinoactive.foreorder_golf_employee.utils;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.generalutilities.dialogutils.DialogUtils;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

public class ForeOrderDialogUtils {

    private static DialogUtils dialogUtils;

    public static DialogUtils getInstance() {
        if (dialogUtils == null) {
            ForeOrderResourceUtils resourceUtils = ForeOrderResourceUtils.getInstance();
            DialogUtils.DialogUtilsBuilder builder = new DialogUtils.DialogUtilsBuilder();
            builder.titleColor(resourceUtils.colorRes(R.color.fore_order_blue));
            builder.positiveTextColor(resourceUtils.colorRes(R.color.fore_order_red));
            builder.negativeTextColor(resourceUtils.colorRes(R.color.fore_order_blue));
            builder.itemsColor(resourceUtils.colorRes(R.color.fore_order_blue));
            builder.backgroundColor(resourceUtils.colorRes(R.color.white));
            builder.contentColor(resourceUtils.colorRes(R.color.fore_order_blue));
            builder.widgetColor(resourceUtils.colorRes(R.color.fore_order_red));
            dialogUtils = builder.build();
        }
        return dialogUtils;
    }
}
