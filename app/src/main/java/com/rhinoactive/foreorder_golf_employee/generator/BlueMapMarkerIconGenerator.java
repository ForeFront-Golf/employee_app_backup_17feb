package com.rhinoactive.foreorder_golf_employee.generator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;

/**
 * Created by Hunter Andrin on 2017-05-12.
 */

public class BlueMapMarkerIconGenerator extends MapMarkerIconGenerator {

    public BlueMapMarkerIconGenerator(Order order, AppCompatActivity activity) {
        super(order, activity);
    }

    @Override
    protected void setViewColors(TextView orderNumberTextView, ImageView backgroundImageView) {
        ForeOrderResourceUtils resourceUtils = ForeOrderResourceUtils.getInstance();
        orderNumberTextView.setTextColor(resourceUtils.colorRes(R.color.fore_order_blue));
        backgroundImageView.setImageResource(R.color.white_percent_30);
    }
}
