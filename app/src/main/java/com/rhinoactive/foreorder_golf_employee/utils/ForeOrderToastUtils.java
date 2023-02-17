package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;

import com.rhinoactive.generalutilities.ToastUtils;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class ForeOrderToastUtils extends ToastUtils {

    private static ForeOrderToastUtils foreOrderToastUtils;

    private ForeOrderToastUtils() {}

    public static ForeOrderToastUtils getInstance() {
        if (foreOrderToastUtils == null) {
            foreOrderToastUtils = new ForeOrderToastUtils();
        }
        return foreOrderToastUtils;
    }

    @Override
    protected Context getAppContext() {
        return ForeOrderApp.getAppContext();
    }
}
