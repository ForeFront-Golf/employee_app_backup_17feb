package com.rhinoactive.foreorder_golf_employee.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.onesignal.OneSignal;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.adapter.OrderItemAdapter;
import com.rhinoactive.foreorder_golf_employee.events.CompleteOrderEvent;
import com.rhinoactive.foreorder_golf_employee.events.ReceivedOrderEvent;
import com.rhinoactive.foreorder_golf_employee.events.OrdersUpdatedEvent;
import com.rhinoactive.foreorder_golf_employee.events.UserLocationsUpdateEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.OrderApiManager;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderDialogUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.realm.Realm;

public class OrderActivity extends ToolbarActivity {

    public static final String ORDER_ID_JSON_KEY = "order_item_key";

    private Realm mRealm;
    private Order currentOrder;
    private MaterialDialog progressDialog;
    private OrderItemAdapter orderItemAdapter;
    private RelativeLayout rLayoutChangeOrderStatus;
    private TextView textViewChangeOrderStatus;
    private boolean shouldShowDialog = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_order);
        mRealm = Realm.getDefaultInstance();
        Intent intent = getIntent();
        int orderId = intent.getIntExtra(ORDER_ID_JSON_KEY, -1);
        currentOrder = mRealm.where(Order.class).equalTo("orderId", orderId).findFirst();

        /**
         * This gets the latest order info. However, it pulls all the orders from the club
         * Optimization required in future.
         * Possible way: Server will send a User object within an Order object so it's possible
         * to just pull one order.
         * Double check the requirements (km, orderItems, etc) before asking for the server response update.
         */

        ClubMenus clubMenus = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();

        OrderApiManager.getOrdersForMenus(clubMenus);

        initPhoneToolbar(currentOrder);
        initViews();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        mRealm.close();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOrdersUpdatedEvent(OrdersUpdatedEvent event) {
        if (shouldShowDialog) {
            updateUIToMatchTheLatestState();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserLocationsChanged(UserLocationsUpdateEvent event) {
        boolean shouldStopLooping = false;
        List<MenuOrders> menuOrdersList = event.getMenuOrdersList();
        for (int i = 0; i < menuOrdersList.size(); i++) {
            for (int j = 0; j < menuOrdersList.get(i).getOrders().size(); j++) {
                if (currentOrder.getUser().getUserId().equals(menuOrdersList.get(i).getOrders().get(j).getUser().getUserId())) {
                    Order tempOrder = menuOrdersList.get(i).getOrders().get(j);
                    orderItemAdapter.updateMapMarker(tempOrder);
                    shouldStopLooping = true;
                    break;
                }
            }
            if (shouldStopLooping) {
                break;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCompleteOrderEvent(final CompleteOrderEvent event) {
        progressDialog.dismiss();
        if (event.isSuccessful()) {
            OneSignal.sendTag(Constants.CURRENT_STATE, Constants.COMPLETED);
            onBackPressed();
        } else {
            Toast.makeText(OrderActivity.this, Constants.ERROR_OCCURRED_COMPLETING_ORDER, Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceivedOrderEvent(final ReceivedOrderEvent event) {
        if (event.isSuccessful()) {
            currentOrder = event.getOrder();
            updateUIReceivedOrder();
            OneSignal.sendTag(Constants.CURRENT_STATE, Constants.RECEIVED);

        } else {
            Toast.makeText(OrderActivity.this, Constants.ERROR_OCCURRED_RECEIVING_ORDER, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUIToMatchTheLatestState() {
        ClubMenus clubMenus = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(this))
                .findFirst();
        List<MenuOrders> selectedMenuOrders = OrderDataUtils.getSelectedMenus(clubMenus);
        for (MenuOrders menuOrders : selectedMenuOrders) {
            for (Order order : menuOrders.getOrders()) {
                if (currentOrder.getOrderId().equals(order.getOrderId())) {
                    if (order.getCurrentState().equals(Constants.RECEIVED) && currentOrder.getCurrentState().equals(Constants.PLACED)) {
                        currentOrder = order;
                        updateUIReceivedOrder();
                        ForeOrderDialogUtils.getInstance().buildDialog(OrderActivity.this,
                                        getString(R.string.status_updated_by_others))
                                .positiveText(R.string.okay)
                                .show();
                    }
                    return;
                }
            }
        }

        shouldShowDialog = false;
        ForeOrderDialogUtils.getInstance().buildDialog(OrderActivity.this,
                        getString(R.string.marked_complete_by_others))
                .positiveText(R.string.okay)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        shouldShowDialog = true;
                        finish();
                    }
                })
                .show();

    }

    private void updateUIReceivedOrder() {
        orderItemAdapter.updateOrderStatusUI();
        rLayoutChangeOrderStatus.setBackgroundColor(getResources().getColor(R.color.fore_order_green));
        textViewChangeOrderStatus.setText(getString(R.string.mark_order_as_complete));
    }

    private void completeOrder() {
        ForeOrderDialogUtils.getInstance().buildDialog(OrderActivity.this,
                        getString(R.string.dialog_order_complete))
                .negativeText(R.string.no)
                .positiveText(R.string.yes)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        progressDialog = ForeOrderDialogUtils.getInstance().showProgressDialog(OrderActivity.this, Constants.COMPLETING, null);
                        OrderApiManager.markOrderComplete(currentOrder);
                    }
                })
                .show();
    }

    private void receiveOrder() {
        ForeOrderDialogUtils.getInstance().buildDialog(OrderActivity.this,
                        getString(R.string.dialog_order_received))
                .negativeText(R.string.no)
                .positiveText(R.string.yes)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        OrderApiManager.markOrderReceived(currentOrder);
                    }
                })
                .show();
    }

    private void initViews() {
        initRecyclerView();
        initLayout();
    }

    private void initRecyclerView() {
        RecyclerView orderItemsRecyclerView = findViewById(R.id.recyclerview_order_items);
        orderItemAdapter = new OrderItemAdapter(mRealm, currentOrder, this);
        orderItemsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        orderItemsRecyclerView.setLayoutManager(layoutManager);
        orderItemsRecyclerView.setAdapter(orderItemAdapter);
    }

    private void initLayout() {
        textViewChangeOrderStatus = findViewById(R.id.textview_change_order_status);
        rLayoutChangeOrderStatus = findViewById(R.id.rlayout_change_order_status);

        if (currentOrder.getCurrentState().equals(Constants.RECEIVED)) {
            rLayoutChangeOrderStatus.setBackgroundColor(getResources().getColor(R.color.fore_order_green));
            textViewChangeOrderStatus.setText(getString(R.string.mark_order_as_complete));
        }

        rLayoutChangeOrderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentOrder.getCurrentState().equals(Constants.PLACED)) {
                    receiveOrder();
                } else {
                    completeOrder();
                }
            }
        });
    }
}
