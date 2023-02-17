package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;

import com.rhinoactive.generalutilities.ResourceUtils;

/**
 * Created by Hunter Andrin on 2017-05-03.
 */

public class ForeOrderResourceUtils extends ResourceUtils {

    private static ForeOrderResourceUtils foreOrderResourceUtils;

    private ForeOrderResourceUtils() {}

    public static ForeOrderResourceUtils getInstance() {
        if (foreOrderResourceUtils == null) {
            foreOrderResourceUtils = new ForeOrderResourceUtils();
        }
        return foreOrderResourceUtils;
    }

    @Override
    protected Context getAppContext() {
        return ForeOrderApp.getAppContext();
    }
}
