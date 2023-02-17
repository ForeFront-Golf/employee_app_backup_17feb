package com.rhinoactive.foreorder_golf_employee.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rhinoactive.foreorder_golf_employee.R;

import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-02.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder {

    // Used for the header menu item layout
    @Getter
    private TextView menuHeaderTextView;

    // Used for the normal order item layout
    @Getter
    private TextView orderNumberTextView;
    @Getter
    private TextView orderNameTextView;
    @Getter
    private TextView orderDistanceTextView;
    @Getter
    private TextView numOfOrderItemsTextView;
    @Getter
    private TextView orderTimeTextView;
    @Getter
    private TextView orderPriceTextView;
    @Getter
    private ImageView orderStatusCircle;

    public OrderViewHolder(View itemView) {
        super(itemView);

        menuHeaderTextView = itemView.findViewById(R.id.textview_header_menu);
        orderNumberTextView = itemView.findViewById(R.id.textview_order_number);
        orderNameTextView = itemView.findViewById(R.id.textview_order_name);
        orderDistanceTextView = itemView.findViewById(R.id.textview_order_distance);
        numOfOrderItemsTextView = itemView.findViewById(R.id.textview_number_of_items);
        orderTimeTextView = itemView.findViewById(R.id.textview_order_since_time);
        orderPriceTextView = itemView.findViewById(R.id.textview_order_price);
        orderStatusCircle = itemView.findViewById(R.id.status_circle);
    }
}
