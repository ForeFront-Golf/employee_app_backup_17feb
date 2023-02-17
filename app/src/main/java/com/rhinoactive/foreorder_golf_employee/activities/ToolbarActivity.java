package com.rhinoactive.foreorder_golf_employee.activities;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult.ExternalPhoneActivity;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAnimationUtils;
import com.rhinodesktop.activityanimatorutility.activityutils.externalactivities.ExternalActivity;
//import com.rhinodesktop.activityanimatorutility.activityutils.externalactivities.activitieswithoutresult.ExternalPhoneActivity;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public abstract class ToolbarActivity extends AppCompatActivity {

    protected enum ToolbarType {
        OrderDetailsToolbar,
        CloseToolbar
    }

    protected Toolbar toolbar;
    protected AnimationType animType = AnimationType.NONE;
    private TextView titleTextView;
    private ImageButton leftButton;
    private View.OnClickListener backClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    @Override
    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base));
    }

    protected void initStandardToolbar() {
        initToolbarViews();
        animType = AnimationType.SLIDE_RIGHT;
        initLeftButton(R.drawable.icon_close_wht, backClickListener);
        setToolbarTitle(Constants.CHANGE_CLUB);

    }

    protected void initPhoneToolbar(Order order) {
        initToolbarViews();
        animType = AnimationType.SLIDE_RIGHT;
        initLeftButton(R.drawable.icon_arow_left_wht, backClickListener);
        initPhoneButton(order);
        setToolbarTitle(Constants.ORDER_DETAILS);
    }

    protected void initToolbarViews() {
        titleTextView = findViewById(R.id.textview_toolbar_title);
        leftButton = findViewById(R.id.menu_button_left);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityAnimationUtils.animateActivityTransition(ToolbarActivity.this, animType);
    }

    protected void setToolbarTitle(String title) {
        titleTextView.setText(title);
    }

    protected void initLeftButton(int imageResourceId, View.OnClickListener onClickListener) {
        leftButton.setImageResource(imageResourceId);
        leftButton.setOnClickListener(onClickListener);
    }

    private void initPhoneButton(Order order) {
        ImageButton callButton = (ImageButton) findViewById(R.id.menu_button_phone);
        callButton.setVisibility(View.VISIBLE);
        final String phoneNumber = order.getUser().getPhoneNumber();
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+order.getUser().getPhoneNumber()));
                view.getContext().startActivity(intent);

//                ExternalActivity externalActivity = new ExternalPhoneActivity(ToolbarActivity.this, phoneNumber);
//                externalActivity.start();
            }
        });
    }
}
