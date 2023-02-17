package com.rhinoactive.foreorder_golf_employee.generator;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.maps.android.ui.IconGenerator;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.models.Order;

import java.util.Locale;

/**
 * Created by Hunter Andrin on 2017-05-12.
 */

public abstract class MapMarkerIconGenerator {

    private final IconGenerator iconGenerator;
    private Order order;
    private AppCompatActivity activity;

    public MapMarkerIconGenerator(Order order, AppCompatActivity activity) {
        this.order = order;
        this.activity = activity;
        iconGenerator = new IconGenerator(activity);
    }

    public Bitmap makeMapMarkerIcon() {
        iconGenerator.setBackground(null);
        View mapMarkerView = activity.getLayoutInflater().inflate(R.layout.map_marker, null);
        TextView orderNumberTextView = mapMarkerView.findViewById(R.id.textview_marker_number);
        ImageView backgroundImageView = mapMarkerView.findViewById(R.id.imageview_map_order_background);
        orderNumberTextView.setText(String.format(Locale.ENGLISH, "%d", order.getOrderNum()));
        orderNumberTextView.setTypeface(orderNumberTextView.getTypeface(), Typeface.BOLD);
        setViewColors(orderNumberTextView, backgroundImageView);
        iconGenerator.setContentView(mapMarkerView);
        return iconGenerator.makeIcon();
    }

    protected abstract void setViewColors(TextView orderNumberTextView, ImageView backgroundImageView);
}
