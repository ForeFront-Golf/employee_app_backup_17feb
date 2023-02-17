package com.rhinoactive.foreorder_golf_employee.activities;

import android.os.Bundle;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.events.ClubChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.ClubCheckedEvent;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.views.ClubRadioButton;
import com.rhinoactive.generalutilities.views.AdvancedRadioGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.util.List;

import io.realm.Realm;

public class ChangeClubActivity extends ToolbarActivity {

    private ClubMenus selectedClubMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_club);
        initStandardToolbar();
        intClubList();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onClubCheckedEvent(ClubCheckedEvent event) {
        selectedClubMenus = event.getClubMenus();
        confirmClub();
    }

    public void confirmClub() {
        ForeOrderSharedPrefUtils.setCurrentClubId(this, selectedClubMenus.getClubMenusId());
        ForeOrderSharedPrefUtils.setPreviousClubId(this, selectedClubMenus.getClub().getClubId());
        EventBus.getDefault().post(new ClubChangedEvent());
        ForeOrderSharedPrefUtils.setShouldDefaultToClubLocation(this, true);
        onBackPressed();
    }

    private void intClubList() {
        Realm realm = Realm.getDefaultInstance();
        selectedClubMenus = realm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();
        List<ClubMenus> listOfClubOrders = realm.where(ClubMenus.class).findAll();
        realm.close();
        AdvancedRadioGroup radioGroup = findViewById(R.id.llayout_single_choice_items);
        for (ClubMenus clubMenus : listOfClubOrders) {
            boolean checked = clubMenus.getClub().getClubId().equals(selectedClubMenus.getClub().getClubId());
            ClubRadioButton clubRadioButton = new ClubRadioButton(this);
            clubRadioButton.setViews(clubMenus, checked);
            radioGroup.addView(clubRadioButton);
        }
    }
}
