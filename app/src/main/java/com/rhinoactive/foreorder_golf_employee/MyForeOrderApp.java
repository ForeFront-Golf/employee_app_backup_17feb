package com.rhinoactive.foreorder_golf_employee;

import android.app.Application;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
public class MyForeOrderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/DINNextLTPro-Regular.otf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()


                ViewPump.init(ViewPump.builder()
                        .addInterceptor(new CalligraphyInterceptor(
                                new CalligraphyConfig.Builder()
                                        .setDefaultFontPath("fonts/DINNextLTPro-Regular.otf")
                                        .setFontAttrId(R.attr.fontPath)
                                        .build()))
                        .build());

    }

}
