package com.rhinoactive.foreorder_golf_employee.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.models.OrderOption;

import java.util.Locale;

/**
 * Created by Hunter Andrin on 2017-05-09.
 */

public class OrderOptionLayout extends RelativeLayout {

    TextView orderOptionTextView;

    public OrderOptionLayout(Context context) {
        super(context);
        initViews();
    }

    public OrderOptionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public OrderOptionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    public void setOptionText(OrderOption orderOption) {
        String textToDisplay = orderOption.getName();
        if (orderOption.getPrice() > 0) {
            textToDisplay = textToDisplay + String.format(Locale.ENGLISH, " ($%.2f)", orderOption.getPrice());
        }
        orderOptionTextView.setText(textToDisplay);
    }

    private void initViews() {
        inflate(getContext(), R.layout.order_option_view, this);
        orderOptionTextView = (TextView) findViewById(R.id.textview_order_option_name_price);
    }
}
