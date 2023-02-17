package com.rhinoactive.foreorder_golf_employee.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.events.ClubCheckedEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Hunter Andrin on 2017-05-04.
 */

public class ClubRadioButton extends RelativeLayout {

    private RadioButton radioButton;
    private TextView clubTextView;

    public ClubRadioButton(Context context) {
        super(context);
        initViews();
    }

    public ClubRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ClubRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.club_item_radio_layout, this);
        radioButton = findViewById(R.id.radiobtn_single_option);
        clubTextView = findViewById(R.id.textview_club_item_name);
    }

    public void setViews(final ClubMenus clubMenus, boolean checked) {
        radioButton.setChecked(checked);
        clubTextView.setText(clubMenus.getClub().getName());

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    OrderApiManager.getMenusForCurrentClub(clubMenus.getClub().getClubId());
                    EventBus.getDefault().post(new ClubCheckedEvent(clubMenus));
                }
            }
        });
    }
}
