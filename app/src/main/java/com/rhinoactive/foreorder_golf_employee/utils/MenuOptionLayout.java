package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.events.MenuSelectionChangedEvent;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Menu;

import org.greenrobot.eventbus.EventBus;

import io.realm.Realm;

/**
 * Created by Hunter Andrin on 2017-05-05.
 */

public class MenuOptionLayout extends RelativeLayout {

    private RelativeLayout menuOptionLayout;
    private TextView menuNameTextView;
    private ImageView selectedImageView;

    public MenuOptionLayout(Context context) {
        super(context);
        initViews();
    }

    public MenuOptionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MenuOptionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.menu_option_layout, this);
        menuOptionLayout = findViewById(R.id.rlayout_menu_option);
        menuNameTextView = findViewById(R.id.textview_menu_name);
        selectedImageView = findViewById(R.id.imageview_selected);
    }

    public void setViews(Menu menu) {
        menuNameTextView.setText(menu.getName());
        initSelectedView(menu);
        initClickListener(menu);
    }

    private void initSelectedView(Menu menu) {
        if (menu.getSelected()) {
            initSelectedViews();
        } else {
            initUnselectedViews();
        }
    }

    private void initSelectedViews() {
        selectedImageView.setVisibility(VISIBLE);
        menuNameTextView.setTypeface(Typeface.DEFAULT_BOLD);
        menuNameTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.fore_order_blue));
    }

    private void initUnselectedViews() {
        selectedImageView.setVisibility(GONE);
        menuNameTextView.setTypeface(Typeface.DEFAULT);
        menuNameTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.fore_order_blue_percent_70));
    }

    private void initClickListener(final Menu menu) {
        menuOptionLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();
                ClubMenus clubMenus = realm.where(ClubMenus.class)
                        .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                        .findFirst();
                realm.close();
                final Boolean selected = menu.getSelected();
//                if (selected && OrderDataUtils.getSelectedMenus(clubMenus).size() <= 1) {
//                    return;
//                }
                try (Realm realm1 = Realm.getDefaultInstance()) {
                    realm1.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            menu.setSelected(!selected);
                            initSelectedView(menu);
                            EventBus.getDefault().post(new MenuSelectionChangedEvent());
                        }
                    });
                }
            }
        });
    }
}
