package com.rhinoactive.foreorder_golf_employee.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.adapter.OrderAdapter;
import com.rhinoactive.foreorder_golf_employee.events.ClubChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.CompleteOrderEvent;
import com.rhinoactive.foreorder_golf_employee.events.MenuSelectionChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.MenusDownloadedEvent;
import com.rhinoactive.foreorder_golf_employee.events.NotificationReceivedEvent;
import com.rhinoactive.foreorder_golf_employee.events.OrdersUpdatedEvent;
import com.rhinoactive.foreorder_golf_employee.events.UserLocationsUpdateEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.LocationApiManager;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinodesktop.locationutilities.newlocationupdates.events.LastKnownLocationEvent;
import com.rhinodesktop.locationutilities.newlocationupdates.utils.LastKnownLocationUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.realm.Realm;
import timber.log.Timber;


/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class OrderListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private Realm mRealm;
    private View rootView;
    private OrderAdapter orderAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.order_list_fragment, container, false);

        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.fore_order_red));

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshRecyclerView();
            }
        });

        initRecyclerView();
        return rootView;
    }

    //Must set views to null in order to prevent a memory leak: http://stackoverflow.com/a/13422819/6575556
    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        rootView = null;
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.e("onResume");
        refreshRecyclerView();
    }

    @Override
    public void onDestroy() {
        mRealm.close();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOrdersUpdatedEvent(OrdersUpdatedEvent event) {
        refreshRecyclerView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserLocationsChanged(UserLocationsUpdateEvent event) {
        refreshRecyclerView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCompleteOrderEvent(final CompleteOrderEvent event) {
        if (event.isSuccessful()) {
            refreshRecyclerView();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClubChangedEvent(ClubChangedEvent event) {
        reinitializeRecyclerView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMenusDownloadedEvent(MenusDownloadedEvent event) {
        reinitializeRecyclerView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMenuChangedEvent(MenuSelectionChangedEvent event) {
        reinitializeRecyclerView();
    }

    @Subscribe
    public void onLastKnownLocationEvent(final LastKnownLocationEvent event) {
        ClubMenus currentClubMenu = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                .findFirst();
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User user = realm.where(User.class).findFirst();
                    user.setUserLocationF(event.getLocation(), realm);
                }
            });
        }
        LocationApiManager.getLocationsOfUsersAtClub(currentClubMenu);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotificationReceivedEvent(NotificationReceivedEvent event) {
        refreshData();
    }

    @Override
    public void onRefresh() {
        refreshData();
    }

    private void refreshData() {
        mSwipeRefreshLayout.setRefreshing(true);
        ClubMenus currentClubMenu = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                .findFirst();
        OrderApiManager.getOrdersForMenus(currentClubMenu);
        refreshRecyclerView();
        LastKnownLocationUtils.getLastKnownLocation((AppCompatActivity) getActivity());
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void initRecyclerView() {
        ClubMenus currentClubMenu = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                .findFirst();

        if (currentClubMenu == null) {
            currentClubMenu = mRealm.where(ClubMenus.class).findFirst();
        }

        List<MenuOrders> selectedMenuOrders = OrderDataUtils.getSelectedMenus(currentClubMenu);
        orderAdapter = new OrderAdapter((AppCompatActivity) getActivity(), selectedMenuOrders);
        RecyclerView ordersRecyclerView = rootView.findViewById(R.id.recyclerview_orders);
        ordersRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ordersRecyclerView.setLayoutManager(layoutManager);
        ordersRecyclerView.setAdapter(orderAdapter);
        LastKnownLocationUtils.getLastKnownLocation((AppCompatActivity) getActivity());
    }

    private void refreshRecyclerView() {
        ClubMenus currentClubMenu = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                .findFirst();

        if (currentClubMenu != null) {
            List<MenuOrders> selectedMenuOrders = OrderDataUtils.getSelectedMenus(currentClubMenu);
            orderAdapter.moldData(selectedMenuOrders);
            orderAdapter.notifyDataSetChanged();
        }
    }

    private void reinitializeRecyclerView() {
        initRecyclerView();
    }
}
