package com.rhinoactive.foreorder_golf_employee.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Menu;
import com.rhinoactive.foreorder_golf_employee.utils.MenuOptionLayout;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.generalutilities.animations.AnimationUtils;
import com.rhinoactive.generalutilities.models.HideViewAnimation;
import com.rhinoactive.generalutilities.models.ShowViewAnimation;

import java.util.List;

import io.realm.Realm;
import lombok.Getter;

/**
 * Created by Hunter Andrin on 2017-05-05.
 */

public class MenuOptionsLayout extends RelativeLayout {

    private OnClickListener optionsMenuClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            handleOpenCloseOfMenuOptionsLayout();
        }
    };

    @Getter
    private boolean menuOptionsOpen = false;

    private LinearLayout menuOptionsLayout;
    private RelativeLayout transparentLayout;

    public MenuOptionsLayout(Context context) {
        super(context);
        initViews();
    }

    public MenuOptionsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MenuOptionsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.menu_options_layout, this);
        menuOptionsLayout = findViewById(R.id.llayout_menu_options);
        transparentLayout = findViewById(R.id.rlayout_transparent_overlay);
        setClickListeners();
    }

    public void addMenuOptions(ClubMenus clubMenus) {
        Realm realm = Realm.getDefaultInstance();
        List<Menu> menus = realm.where(Menu.class).equalTo("clubId", clubMenus.getClubMenusId()).findAll();
        for(Menu menu : menus) {
            MenuOptionLayout menuOptionLayout = new MenuOptionLayout(getContext());
            menuOptionLayout.setViews(menu);
            menuOptionsLayout.addView(menuOptionLayout);
        }

//        for (MenuOrders menuOrders : clubMenus.getListOfMenuOrders()) {
//            MenuOptionLayout menuOptionLayout = new MenuOptionLayout(getContext());
//            menuOptionLayout.setViews(menuOrders.getMenu());
//            menuOptionsLayout.addView(menuOptionLayout);
//        }

        realm.close();
    }

    public void removePreviousMenuOptions() {
        menuOptionsLayout.removeAllViews();
    }

    public void handleOpenCloseOfMenuOptionsLayout() {
        if (menuOptionsOpen) {
            hideMenuOptions();
        } else {
            showMenuOptions();
        }
        menuOptionsOpen = !menuOptionsOpen;
    }

    private void showMenuOptions() {
        AnimationUtils.getInstance().showAnimation(transparentLayout, ShowViewAnimation.FADE_IN, Constants.ANIM_DURATION);
        AnimationUtils.getInstance().showAnimation(menuOptionsLayout, ShowViewAnimation.SLIDE_DOWN, Constants.ANIM_DURATION);
    }

    private void hideMenuOptions() {
        AnimationUtils.getInstance().hideAnimation(transparentLayout, HideViewAnimation.FADE_OUT, Constants.ANIM_DURATION);
        AnimationUtils.getInstance().hideAnimation(menuOptionsLayout, HideViewAnimation.SLIDE_UP, Constants.ANIM_DURATION);
    }

    private void setClickListeners() {
        menuOptionsLayout.setOnClickListener(optionsMenuClickedListener);
        transparentLayout.setOnClickListener(optionsMenuClickedListener);
    }
}
