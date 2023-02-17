package com.rhinoactive.foreorder_golf_employee.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.activities.OrderActivity;
import com.rhinoactive.foreorder_golf_employee.models.Menu;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAndAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sungwook on 2018-04-20.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ROW = 1;

    private AppCompatActivity activity;
    private List<Object> groupList;


    public OrderAdapter(AppCompatActivity activity, List<MenuOrders> menuOrdersList) {
        this.activity = activity;
        groupList = new ArrayList<>();
        moldData(menuOrdersList);
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(viewType == TYPE_HEADER ? R.layout.order_header_view : R.layout.order_view, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_HEADER) {
            // String menuName = menuOrdersList.get(section).getMenu().getName();
            String menuName = ((Menu) groupList.get(position)).getName();
            holder.getMenuHeaderTextView().setText(String.format(Locale.ENGLISH, "%s %s", menuName, Constants.ORDERS));
        } else {
            // Order order = menuOrdersList.get(section).getOrders().get(relativePosition);
            Order order = (Order) groupList.get(position);
            setItemTextViews(order, holder);
            setItemOnClickListener(order, holder);
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (groupList.get(position) instanceof Menu) {
            return TYPE_HEADER;
        } else {
            return TYPE_ROW;
        }
    }

    public void moldData(List<MenuOrders> menuOrdersList) {
        groupList.clear();
        for (MenuOrders mo : menuOrdersList) {
            if (mo != null) {
                if (mo.getMenu() != null && mo.getOrders().size() != 0) {
                    groupList.add(mo.getMenu());
                }
                if (mo.getOrders() != null) {
                    groupList.addAll(mo.getOrders());
                }
            }
        }
    }

    private void setItemTextViews(final Order order, OrderViewHolder holder) {
        holder.getOrderNumberTextView().setText(String.format(Locale.ENGLISH, "%d", order.getOrderNum()));
        holder.getOrderNameTextView().setText(order.getUser().getFullName());
        holder.getOrderDistanceTextView().setText(order.getUser().getDistanceAwayText());
        int mins = OrderDataUtils.getTimeSinceOrder(order);
        String minText = activity.getString(R.string.min);
        String minsText = activity.getString(R.string.mins);
        String hrText = activity.getString(R.string.hr);
        String hrsText = activity.getString(R.string.hrs);
        if (mins == 1) {
            holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s", mins, minText));
        } else if (mins < 60) {
            holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s", mins, minsText));
        } else {
            int hrs = mins / 60;
            mins = mins % 60;
            if (hrs == 1) {
                if (mins == 1) {
                    holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrText, mins, minText));
                } else {
                    holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrText, mins, minsText));
                }
            } else {
                if (mins == 1) {
                    holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrsText, mins, minText));
                } else {
                    holder.getOrderTimeTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrsText, mins, minsText));
                }
            }
        }
        int numOfItems = order.getQuantity();
        String itemsText;
        if (order.getQuantity() == 1) {
            itemsText = ForeOrderResourceUtils.getInstance().strRes(R.string.item);
        } else {
            itemsText = ForeOrderResourceUtils.getInstance().strRes(R.string.items);
        }
        holder.getNumOfOrderItemsTextView().setText(String.format(Locale.ENGLISH, "%d %s /", numOfItems, itemsText));


        float price = order.getPriceTotalWithTax();
        holder.getOrderPriceTextView().setText(String.format(Locale.ENGLISH, "$%.2f", price));
        if (order.getCurrentState().equals(Constants.RECEIVED)) {
            holder.getOrderStatusCircle().setBackground(activity.getDrawable(R.drawable.status_circle_inprogress));
        } else {
            holder.getOrderStatusCircle().setBackground(activity.getDrawable(R.drawable.status_circle_unconfirmed));
        }
    }

    private void setItemOnClickListener(final Order order, OrderViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityAndAnimateManager.Builder builder = new ActivityAndAnimateManager.Builder(activity, OrderActivity.class, AnimationType.SLIDE_LEFT);
                builder.intExtra(OrderActivity.ORDER_ID_JSON_KEY, order.getOrderId());
                builder.buildActivityAndTransition();
            }
        });
    }
}
