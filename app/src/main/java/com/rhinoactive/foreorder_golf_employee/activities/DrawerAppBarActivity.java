package com.rhinoactive.foreorder_golf_employee.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rhinoactive.foreorder_golf_employee.BuildConfig;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.managers.LogoutManager;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OneSignalUtils;
import com.rhinoactive.foreorder_golf_employee.views.MenuOptionsLayout;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.imageutility.legaldocutils.DocS3LinkUtils;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAndAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public abstract class DrawerAppBarActivity extends ToolbarActivity {

    private Realm mRealm;
    private DrawerLayout drawer;
    private TextView clubNameTextView;
    private LinearLayout llayout_menu_name;
    private MenuOptionsLayout menuOptionsLayout;

    @Override
    protected void onStart() {
        super.onStart();
        if (drawer.isDrawerVisible(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    protected void onDestroy() {
        mRealm.close();
        super.onDestroy();
    }

    protected void initToolbar() {
        initToolbarViews();
    }

    protected void initToolbarViews() {
        super.initToolbarViews();
        initToolbarTitleDropdown();
        initCustomHamburgerIcon();
        initDrawerViews();
    }

    protected void setMenuOptionsDropdown() {
        setCurrentMenuTitleName();
        menuOptionsLayout.removePreviousMenuOptions();
        ClubMenus clubMenus = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();
        if (clubMenus == null) {
            menuOptionsLayout.addMenuOptions(mRealm.where(ClubMenus.class).findFirst());
        } else {
            menuOptionsLayout.addMenuOptions(clubMenus);
        }
    }

    protected void setCurrentMenuTitleName() {
        ClubMenus clubMenus = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();

        if (clubMenus == null) {
            clubMenus = mRealm.where(ClubMenus.class).findFirst();
        }

        List<MenuOrders> selectedMenus = OrderDataUtils.getSelectedMenus(clubMenus);
        if (selectedMenus.size() > 1) {
            setToolbarTitle(Constants.MULTIPLE_MENUS);
        } else {
            if (selectedMenus.size() > 0) {
                String clubName = selectedMenus.get(0).getMenu().getName();
                setToolbarTitle(clubName);
            }
        }
    }

    protected void setCurrentClubTitleName() {
        Club currentClub = mRealm.where(Club.class)
                .equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();

        if (currentClub == null) {
            int currentClubMenuId = mRealm.where(ClubMenus.class).findFirst().getClubMenusId();
            currentClub = mRealm.where(Club.class)
                    .equalTo("clubId", currentClubMenuId)
                    .findFirst();
        }
        OneSignalUtils.sendClubToOneSignal(currentClub);
        clubNameTextView.setText(currentClub.getName());
    }

    private void initToolbarTitleDropdown() {
        menuOptionsLayout = findViewById(R.id.menuoptionslayout);
        llayout_menu_name = findViewById(R.id.llayout_menu_name);
        ImageView carrotImageView = findViewById(R.id.imageview_title_carrot);
        carrotImageView.setVisibility(View.VISIBLE);
        setMenuOptionsDropdown();
        setMenuSelectorClickListener();
    }

    private void initCustomHamburgerIcon() {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
        toggle.syncState();
        drawer.addDrawerListener(toggle);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        };
        super.initLeftButton(R.drawable.icon_menu_wht, clickListener);
    }

    private void initDrawerViews() {
        setLegalDocLinks();
        clubNameTextView = findViewById(R.id.textview_course_name);
        setCurrentClubTitleName();
        TextView versionNumberTextView = findViewById(R.id.textview_version_number);
        versionNumberTextView.setText(BuildConfig.VERSION_NAME);
        initChangeClubButton();
        initLogoutButton();
    }

    private void setLegalDocLinks() {
        LinearLayout policyLayout = findViewById(R.id.llayout_privacy_policy);
        LinearLayout termsLayout = findViewById(R.id.llayout_terms_of_use);
        policyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(Constants.PRIVACY_POLICY_URL), "application/pdf");
                startActivity(browserIntent);
            }
        });

        termsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(Constants.TERMS_OF_USE_URL), "application/pdf");
                startActivity(browserIntent);
            }
        });

//        ForeOrderResourceUtils resourceUtils = ForeOrderResourceUtils.getInstance();
//        String fileProviderAuth = resourceUtils.strRes(R.string.file_provider_authority);
//        DocS3LinkUtils.setLegalDocLinkClickListeners(policyLayout, this, Constants.PRIVACY_POLICY_URL, fileProviderAuth);
//        DocS3LinkUtils.setLegalDocLinkClickListeners(termsLayout, this, Constants.TERMS_OF_USE_URL, fileProviderAuth);
    }

    private void initChangeClubButton() {
        LinearLayout changeClubLayout = findViewById(R.id.llayout_change_club);
        changeClubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityAndAnimateManager.Builder builder = new ActivityAndAnimateManager.Builder(DrawerAppBarActivity.this, ChangeClubActivity.class, AnimationType.SLIDE_LEFT);
                builder.buildActivityAndTransition();
            }
        });
    }

    private void initLogoutButton() {
        RelativeLayout logoutLayout = findViewById(R.id.rlayout_logout);
        logoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutManager.logout(DrawerAppBarActivity.this);
            }
        });
    }

    private void setMenuSelectorClickListener() {
        llayout_menu_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuOptionsLayout.handleOpenCloseOfMenuOptionsLayout();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (menuOptionsLayout.isMenuOptionsOpen()) {
            menuOptionsLayout.handleOpenCloseOfMenuOptionsLayout();
        } else {
            super.onBackPressed();
        }
    }
}
