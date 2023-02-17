package com.rhinoactive.foreorder_golf_employee.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rhinoactive.foreorder_golf_employee.R;

import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-08.
 */

public class OrderItemViewHolder extends RecyclerView.ViewHolder {

    //Used for the order_item_header_fragment_container
    @Getter
    private FrameLayout fragmentContainer;

    // Relative Layout for each row
    @Getter
    private RelativeLayout rLayoutSubtotal;
    @Getter
    private RelativeLayout rLayoutHST;

    //Used for the order_item_header
    @Getter
    private RelativeLayout headerContainerLayout;
    @Getter
    private TextView headerOrderNumberTextView;
    @Getter
    private TextView headerNumItemsTextView;
    @Getter
    private ImageView headerUserImageView;
    @Getter
    private TextView headerUserNameTextView;
    @Getter
    private TextView headerOrderPriceTextView;
    @Getter
    private TextView headerTimeSinceTextView;
    @Getter
    private TextView headerDistanceTextView;
    @Getter
    private TextView headerOrderStatusTextView;
    @Getter
    private ImageView headerOrderStatusCircle;
    @Getter
    private LinearLayout headerMembershipLayout;
    @Getter
    private TextView headerMembershipText;

    //Used for the order_item_view layout
    @Getter
    private TextView itemNameTextView;
    @Getter
    private TextView instructionsTextView;
    @Getter
    private TextView numOfItemsTextView;
    @Getter
    private TextView priceOfItemsTextView;
    @Getter
    private LinearLayout optionItemsLayout;

    //Used for the order_item_footer
    @Getter
    private TextView footerSubtotalTextView;
    @Getter
    private TextView footerHstTextView;
    @Getter
    private TextView footerTotalPriceTextView;

    public OrderItemViewHolder(View itemView) {
        super(itemView);

        fragmentContainer = itemView.findViewById(R.id.flayout_map_fragment_container);

        rLayoutSubtotal = itemView.findViewById(R.id.rlayout_subtotal);
        rLayoutHST = itemView.findViewById(R.id.rlayout_hst);

        headerContainerLayout = itemView.findViewById(R.id.rlayout_container);
        headerOrderNumberTextView = itemView.findViewById(R.id.textview_order_details_number);
        headerNumItemsTextView = itemView.findViewById(R.id.textview_details_num_of_items);
        headerUserImageView = itemView.findViewById(R.id.imageview_details_user_image);
        headerUserNameTextView = itemView.findViewById(R.id.textview_details_user_name);
        headerOrderPriceTextView = itemView.findViewById(R.id.textview_detail_total_price);
        headerTimeSinceTextView = itemView.findViewById(R.id.textview_detail_time_since);
        headerDistanceTextView = itemView.findViewById(R.id.textview_detail_distance);
        headerOrderStatusTextView = itemView.findViewById(R.id.textview_status);
        headerOrderStatusCircle = itemView.findViewById(R.id.order_status_circle);
        headerMembershipLayout = itemView.findViewById(R.id.llayout_membership_id);
        headerMembershipText = itemView.findViewById(R.id.text_membership_id);

        itemNameTextView = itemView.findViewById(R.id.textview_cart_item_name);
        instructionsTextView = itemView.findViewById(R.id.textview_cart_item_instructions);
        numOfItemsTextView = itemView.findViewById(R.id.textview_number_of_cart_items);
        priceOfItemsTextView = itemView.findViewById(R.id.textview_price_of_cart_items);
        optionItemsLayout = itemView.findViewById(R.id.llayout_option_items_container);

        footerSubtotalTextView = itemView.findViewById(R.id.textview_subtotal_price);
        footerHstTextView = itemView.findViewById(R.id.textview_hst_price);
        footerTotalPriceTextView = itemView.findViewById(R.id.textview_order_total_price);
    }
}
