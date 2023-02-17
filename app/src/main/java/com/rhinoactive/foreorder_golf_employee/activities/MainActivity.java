package com.rhinoactive.foreorder_golf_employee.activities;

import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.events.MenuSelectionChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.MenusDownloadedEvent;
import com.rhinoactive.foreorder_golf_employee.fragments.MapFragment;
import com.rhinoactive.foreorder_golf_employee.fragments.OrderListFragment;
import com.rhinoactive.foreorder_golf_employee.managers.LogoutManager;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Session;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderToastUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.nointernetview.BroadcastReceiverManager;
import com.rhinoactive.nointernetview.ConnectionChangeListener;
import com.rhinoactive.nointernetview.NetworkUtils;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAnimationUtils;
import com.rhinodesktop.activityanimatorutility.fragmentutils.SupportFragmentAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends TrackUserLocationActivity implements ConnectionChangeListener {

    private final int fragmentContainerId = R.id.flayout_fragment_container;
    private FragmentType currentFragmentType = FragmentType.OrderList;
    private BroadcastReceiverManager broadcastReceiverManager;

    private Realm mRealm;
    private RelativeLayout ordersLayout;
    private ImageView orderListImageView;
    private ImageView orderMapImageView;
    private int noInternetViewHeight = 0;

    public enum FragmentType {
        OrderList, OrderMap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        ForeOrderSharedPrefUtils.setShouldDefaultToClubLocation(this, true);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (mRealm.where(Session.class).findAll().isEmpty()) {
            logoutUnauthorizedUser();
        } else {
            initToolbar();
            initFragment();
            initSwitchFragmentButtons();
            initNoInternetViews();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        int previousClubId = ForeOrderSharedPrefUtils.getPreviousClubId(this);
        int notificationClubId = ForeOrderSharedPrefUtils.getNotificationClubId(this);
        if (notificationClubId != -1) {
            chooseCorrectClubMenu(notificationClubId);
            ForeOrderSharedPrefUtils.setPreviousClubId(this, notificationClubId);
            setCurrentClubTitleName();
            setMenuOptionsDropdown();
            ForeOrderSharedPrefUtils.setNotificationClubId(this, -1);
        } else if (previousClubId != -1) {
            chooseCorrectClubMenu(previousClubId);
            setCurrentClubTitleName();
            setMenuOptionsDropdown();
        } else {
            Club firstClub = mRealm.where(Club.class).findFirst();
            if (firstClub != null) {
                int firstClubId = firstClub.getClubId();
                ForeOrderSharedPrefUtils.setPreviousClubId(this, firstClubId);
                ForeOrderSharedPrefUtils.setCurrentClubId(this, firstClubId);
                chooseCorrectClubMenu(firstClubId);
                setCurrentClubTitleName();
                setMenuOptionsDropdown();
            }
        }
        OrderApiManager.getMenusForCurrentClub(ForeOrderSharedPrefUtils.getCurrentClubId(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mRealm.close();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        if (broadcastReceiverManager != null) {
            broadcastReceiverManager.uninstallListener();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityAnimationUtils.animateActivityTransition(this, AnimationType.FADE_IN);
    }

    @Override
    public void connectionChanged(boolean isConnected) {
        adjustMarginForNoInternetView(isConnected);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMenuDownloadedEvent(MenusDownloadedEvent event) {
        setCurrentClubTitleName();
        setMenuOptionsDropdown();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMenuChangedEvent(MenuSelectionChangedEvent event) {
        setCurrentMenuTitleName();
    }

    private void chooseCorrectClubMenu(int idToCompareWith) {
        List<ClubMenus> clubMenusList = mRealm.where(ClubMenus.class).findAll();
        for (ClubMenus clubMenus : clubMenusList) {
            if (clubMenus.getClub().getClubId().equals(idToCompareWith)) {
                ForeOrderSharedPrefUtils.setCurrentClubId(this, idToCompareWith);
                break;
            }
        }
    }

    private void logoutUnauthorizedUser() {
        LogoutManager.logout(MainActivity.this);
        ForeOrderToastUtils.getInstance().displayToastFromMainThreadLong(Constants.SESSION_EXPIRED);
    }

    private void initSwitchFragmentButtons() {
        orderListImageView = findViewById(R.id.imageview_order_list);
        orderMapImageView = findViewById(R.id.imageview_order_map);
        initSwitchFragmentClickListener(FragmentType.OrderList, orderListImageView);
        initSwitchFragmentClickListener(FragmentType.OrderMap, orderMapImageView);
    }

    private void initSwitchFragmentClickListener(final FragmentType fragmentType, ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentType.equals(currentFragmentType)) {
                    return;
                }

                Fragment fragment;
                AnimationType animType;
                if (currentFragmentType.equals(FragmentType.OrderList)) {
                    fragment = new MapFragment();
                    currentFragmentType = FragmentType.OrderMap;
                    changeSwitchButtonAppearancesForMap();
                    animType = AnimationType.SLIDE_LEFT;
                } else {
                    fragment = new OrderListFragment();
                    currentFragmentType = FragmentType.OrderList;
                    changeSwitchButtonAppearancesForList();
                    animType = AnimationType.SLIDE_RIGHT;
                }
                SupportFragmentAnimateManager.getInstance().changeSupportFragment(MainActivity.this.getSupportFragmentManager(), fragment, animType, fragmentContainerId);
            }
        });
    }

    private void changeSwitchButtonAppearancesForMap() {
        changeSwitchButtonAppearance(orderMapImageView, R.drawable.icon_map_wht, R.color.fore_order_blue);
        changeSwitchButtonAppearance(orderListImageView, R.drawable.icon_list_nvy, R.color.fore_order_darker_white);
    }

    private void changeSwitchButtonAppearancesForList() {
        changeSwitchButtonAppearance(orderMapImageView, R.drawable.icon_map_nvy, R.color.fore_order_darker_white);
        changeSwitchButtonAppearance(orderListImageView, R.drawable.icon_list_wht, R.color.fore_order_blue);
    }

    private void changeSwitchButtonAppearance(ImageView imageView, int imageResourceId, int backgroundColor) {
        int backgroundColorResource = ForeOrderResourceUtils.getInstance().colorRes(backgroundColor);
        imageView.setImageResource(imageResourceId);
        imageView.setBackgroundColor(backgroundColorResource);
    }

    private void initFragment() {
        Fragment fragment = new OrderListFragment();
        SupportFragmentAnimateManager.getInstance().addSupportFragment(this.getSupportFragmentManager(), fragment, fragmentContainerId);
    }

    private void initNoInternetViews() {
        ordersLayout = findViewById(R.id.rlayout_order_list);
        broadcastReceiverManager = new BroadcastReceiverManager(this, this);
        broadcastReceiverManager.installListener();
        addHeightIfNotConnected(this);
    }

    private void addHeightIfNotConnected(final Context context) {
        toolbar.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        boolean isConnected = NetworkUtils.hasNetworkConnection(context);
                        noInternetViewHeight = findViewById(R.id.no_internet_view).getHeight();
                        if (!isConnected) {
                            adjustForSizeOfNoInternetView(noInternetViewHeight);
                        }
                    }
                });
    }

    private void adjustMarginForNoInternetView(boolean isConnected) {
        if (isConnected) {
            adjustForSizeOfNoInternetView(-noInternetViewHeight);
        } else {
            adjustForSizeOfNoInternetView(noInternetViewHeight);
        }
    }

    private void adjustForSizeOfNoInternetView(int noInternetViewHeight) {
        ViewGroup.MarginLayoutParams contentMarginLayoutParams = (ViewGroup.MarginLayoutParams) ordersLayout.getLayoutParams();
        contentMarginLayoutParams.topMargin = contentMarginLayoutParams.topMargin + noInternetViewHeight;
    }
}
