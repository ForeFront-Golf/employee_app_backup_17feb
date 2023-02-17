package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;
import androidx.multidex.MultiDexApplication;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.loggers.TimberLogImplementation;
import com.rhinoactive.realmutilities.RealmUtils;

import net.danlew.android.joda.JodaTimeAndroid;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;


/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class ForeOrderApp extends MultiDexApplication {

    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        appContext = getApplicationContext();

        TimberLogImplementation.init();

        OneSignalUtils.initOneSignal(this);

        RealmUtils.initRealm(appContext);

        setUpCalligraphy();
    }

    private void setUpCalligraphy() {
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Montserrat_Medium.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build());

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/DINNextLTPro-Regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());


    }
}
