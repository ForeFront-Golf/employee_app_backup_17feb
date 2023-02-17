package com.rhinoactive.foreorder_golf_employee.adapter;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.generator.MapMarkerIconGenerator;
import com.rhinoactive.foreorder_golf_employee.generator.RedMapMarkerIconGenerator;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_golf_employee.utils.OrderDataUtils;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.models.OrderItem;
import com.rhinoactive.foreorder_golf_employee.models.OrderOption;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.views.OrderOptionLayout;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.imageutility.amazonfiledownloaders.AmazonImageGlideDownloader;
import com.rhinoactive.imageutility.amazonfiledownloaders.AmazonRecyclerViewImageDownloader;
import com.rhinodesktop.activityanimatorutility.fragmentutils.SupportFragmentAnimateManager;

import java.util.Locale;

import io.realm.Realm;
import lombok.Getter;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-08.
 */

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemViewHolder> implements OnMapReadyCallback {

    private static final float ORDER_ZOOM_DISTANCE = 17.5f;
    private static final float CLUB_ZOOM_DISTANCE = 15f;

    public enum OrderItemViewType {
        OrderItemHeaderMap(R.layout.order_item_header_fragment_container),
        OrderItemHeaderContent(R.layout.order_item_header),
        OrderItemContent(R.layout.order_item_view),
        OrderItemFooter(R.layout.order_item_footer);

        @Getter
        private final int layout;

        OrderItemViewType(int layout) {
            this.layout = layout;
        }
    }

    private Realm mRealm;
    private Order order;
    private FragmentActivity activity;
    private GoogleMap mMap;
    private Marker marker;
    private OrderItemViewHolder headHolder;
    // This prevents the image from flickering when it is scrolled back into view
    private boolean profileImageLoaded = false;

    public OrderItemAdapter(Realm realm, Order order, FragmentActivity activity) {
        mRealm = realm;
        this.order = order;
        this.activity = activity;
    }

    public void updateMapMarker(Order order) {
        if (mMap != null && marker != null) {
            LatLng currentLatLng = order.getUser().getUserLocation().getLatLng();
            marker.setPosition(currentLatLng);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, ORDER_ZOOM_DISTANCE));
            headHolder.getHeaderDistanceTextView().setText(order.getUser().getDistanceAwayText());
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try {
            if (mMap != null) {
                zoomMapToOrderLocation();
            }
        } catch (SecurityException ex) {
            // Permission to access the location is missing.
            Timber.e("User has not yet allowed the app to track the their location.");
            ex.printStackTrace();
        }
    }

    @NonNull
    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(viewType, parent, false);
        return new OrderItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderItemViewHolder holder, int position) {
        if (position == 0) {
            initMapHeader(holder);
        } else if (position == 1) {
            initHeaderContent(holder);
        } else if (isLastItem(position)) {
            initFooter(holder);
        } else {
            initOrderItemView(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        //Size is the number of order items plus 3 for the headers and the footer
        return order.getOrderItems().size() + 3;
    }

    @Override
    public int getItemViewType(int position) {
        int layout;
        if (position == 0) {
            layout = OrderItemViewType.OrderItemHeaderMap.getLayout();
        } else if (position == 1) {
            layout = OrderItemViewType.OrderItemHeaderContent.getLayout();
        } else if (isLastItem(position)) {
            layout = OrderItemViewType.OrderItemFooter.getLayout();
        } else {
            layout = OrderItemViewType.OrderItemContent.getLayout();
        }
        return layout;
    }

    public void updateOrderStatusUI() {
        headHolder.getHeaderOrderStatusTextView().setText(activity.getString(R.string.in_progress));
        headHolder.getHeaderOrderStatusCircle().setBackground(activity.getDrawable(R.drawable.status_circle_inprogress));
    }

    private void setSpecialInstructionsView(OrderItemViewHolder holder, OrderItem orderItem) {
        if (orderItem.hasSpecialRequest()) {
            StringBuilder specialInstructions = new StringBuilder();
            specialInstructions.append("Notes: ");
            specialInstructions.append(orderItem.getSpecialRequest());
            holder.getInstructionsTextView().setText(specialInstructions.toString());
            holder.getInstructionsTextView().setVisibility(View.VISIBLE);
        } else {
            holder.getInstructionsTextView().setVisibility(View.GONE);
        }
    }

    private void setOptionItemViews(OrderItemViewHolder holder, OrderItem orderItem) {
        if (orderItem.getOrderOptions().size() == 0) {
            return;
        }
        LinearLayout optionItemsLayout = holder.getOptionItemsLayout();
        for (OrderOption orderOption : orderItem.getOrderOptions()) {
            OrderOptionLayout orderOptionLayout = new OrderOptionLayout(optionItemsLayout.getContext());
            orderOptionLayout.setOptionText(orderOption);
            optionItemsLayout.addView(orderOptionLayout);
        }
    }

    private boolean isLastItem(int position) {
        return position == order.getOrderItems().size() + 2; // plus 2 for the headers
    }

    private void initMapHeader(OrderItemViewHolder holder) {
        if (mMap == null) {
            createMapFragment(holder);
        }
    }

    private void createMapFragment(OrderItemViewHolder holder) {
        FrameLayout mapContainerLayout = holder.getFragmentContainer();
        GoogleMapOptions options = new GoogleMapOptions();
        //TODO: lite mode is buggy and won't zoom to the correct zoom level
        //TODO: Perhaps this will be fixed in the future. https://issuetracker.google.com/issues/36218443
//        options.liteMode(true);
        options.rotateGesturesEnabled(false);
        options.scrollGesturesEnabled(false);
        options.tiltGesturesEnabled(false);
        options.zoomControlsEnabled(false);
        options.zoomGesturesEnabled(false);
        options.mapType(GoogleMap.MAP_TYPE_HYBRID);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance(options);
        SupportFragmentAnimateManager.getInstance().addSupportFragment(activity.getSupportFragmentManager(), mapFragment, mapContainerLayout.getId());
        mapFragment.getMapAsync(this);
    }

    private void zoomMapToOrderLocation() {
        LatLng currentLatLng = null;
        float zoomDistance = 0;
        if (order.getUser().getUserLocation() != null) {
            currentLatLng = order.getUser().getUserLocation().getLatLng();
            zoomDistance = ORDER_ZOOM_DISTANCE;
            MapMarkerIconGenerator mapMarkerIconGenerator = new RedMapMarkerIconGenerator(order, (AppCompatActivity) activity);
            Bitmap bitmap = mapMarkerIconGenerator.makeMapMarkerIcon();
            marker = mMap.addMarker(new MarkerOptions().position(currentLatLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap)).anchor(0.5f, 0.5f));
        } else {
            Club currentClub = mRealm.where(Club.class)
                    .equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(activity))
                    .findFirst();
            if (currentClub != null) {
                currentLatLng = new LatLng(currentClub.getLat(), currentClub.getLon());
                zoomDistance = CLUB_ZOOM_DISTANCE;
            }
        }
        mMap.getUiSettings().setMapToolbarEnabled(false);
        if (currentLatLng != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, zoomDistance));
        }
    }

    private void initHeaderContent(OrderItemViewHolder holder) {
        headHolder = holder;
        holder.getHeaderOrderNumberTextView().setText(String.format(Locale.ENGLISH, "%d", order.getOrderNum()));
        String profileUrl = order.getUser().getProfilePhotoUrl();
        if (profileUrl != null && !profileImageLoaded) {
            initUserImageView(holder);
        }

        int numOfItems = order.getQuantity();
        String itemsText;
        if (numOfItems == 1) {
            itemsText = ForeOrderResourceUtils.getInstance().strRes(R.string.item);
        } else {
            itemsText = ForeOrderResourceUtils.getInstance().strRes(R.string.items);
        }

        String menuName = null;
        ClubMenus currentClubMenu = mRealm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(activity))
                .findFirst();
        for (MenuOrders mo : currentClubMenu.getListOfMenuOrders()) {
            if (order.getMenuId().equals(mo.getMenuOrdersId())) {
                menuName = mo.getMenu().getName();
                break;
            }
        }

        holder.getHeaderNumItemsTextView().setText(String.format(Locale.ENGLISH, "%d %s from %s", numOfItems, itemsText, menuName));
        int mins = OrderDataUtils.getTimeSinceOrder(order);
        String minText = activity.getString(R.string.min);
        String minsText = activity.getString(R.string.mins);
        String hrText = activity.getString(R.string.hr);
        String hrsText = activity.getString(R.string.hrs);
        if (mins == 1) {
            holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s", mins, minText));
        } else if (mins < 60) {
            holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s", mins, minsText));
        } else {
            int hrs = mins / 60;
            mins = mins % 60;
            if (hrs == 1) {
                if (mins == 1) {
                    holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrText, mins, minText));
                } else {
                    holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrText, mins, minsText));
                }
            } else {
                if (mins == 1) {
                    holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrsText, mins, minText));
                } else {
                    holder.getHeaderTimeSinceTextView().setText(String.format(Locale.ENGLISH, "%d %s %d %s", hrs, hrsText, mins, minsText));
                }
            }
        }
        holder.getHeaderUserNameTextView().setText(order.getUser().getFullName());
        float price = order.getPriceTotalWithTax();
        holder.getHeaderOrderPriceTextView().setText(String.format(Locale.ENGLISH, "$%.2f", price));
        holder.getHeaderDistanceTextView().setText(order.getUser().getDistanceAwayText());
        if (order.getCurrentState().equals(Constants.RECEIVED)) {
            holder.getHeaderOrderStatusTextView().setText(activity.getString(R.string.in_progress));
            holder.getHeaderOrderStatusCircle().setBackground(activity.getDrawable(R.drawable.status_circle_inprogress));
        }

        Club currentClub = mRealm.where(Club.class)
                .equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(activity))
                .findFirst();

        ViewGroup.LayoutParams params = holder.getHeaderContainerLayout().getLayoutParams();
        if (currentClub.getPrivateClub() && order.getMemberCode() != null) {
            params.height = 240;
            holder.getHeaderMembershipLayout().setVisibility(View.VISIBLE);
            holder.getHeaderMembershipText().setText(order.getMemberCode());
        } else {
            params.height = 226;
            holder.getHeaderMembershipLayout().setVisibility(View.GONE);
        }
        // Convert to dp
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, params.height, activity.getResources().getDisplayMetrics());
        holder.getHeaderContainerLayout().setLayoutParams(params);
    }

    private void initUserImageView(OrderItemViewHolder holder) {
        AmazonImageGlideDownloader amazonImageDownloader = new AmazonRecyclerViewImageDownloader(holder.getHeaderUserImageView(), holder);
        amazonImageDownloader.circleImage();
        amazonImageDownloader.doNotCheckCacheForFile();
        amazonImageDownloader.skipGlideCache();
        amazonImageDownloader.downloadFile(order.getUser().createProfileImageUrl());
        profileImageLoaded = true;
    }

    private void initOrderItemView(OrderItemViewHolder holder, int position) {
        int index = position - 2; //minus 2 to account for the headers
        OrderItem orderItem = order.getOrderItems().get(index);
        holder.getItemNameTextView().setText(orderItem.getName());
        holder.getNumOfItemsTextView().setText(String.format(Locale.ENGLISH, "%d", orderItem.getQuantity()));
        holder.getPriceOfItemsTextView().setText(String.format(Locale.ENGLISH, "$%.2f", orderItem.getPrice()));
        setSpecialInstructionsView(holder, orderItem);
        setOptionItemViews(holder, orderItem);
    }

    private void initFooter(OrderItemViewHolder holder) {
        float price = order.getPriceTotal();
        holder.getFooterSubtotalTextView().setText(String.format(Locale.ENGLISH, "$%.2f", price));
        float hst = order.getTaxAmount();
        holder.getFooterHstTextView().setText(String.format(Locale.ENGLISH, "$%.2f", hst));
        float totalPrice = order.getPriceTotalWithTax();
        holder.getFooterTotalPriceTextView().setText(String.format(Locale.ENGLISH, "$%.2f", totalPrice));

        Club currentClub = mRealm.where(Club.class)
                .equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(activity))
                .findFirst();
        if (currentClub.getShowTax()) {
            holder.getRLayoutSubtotal().setVisibility(View.VISIBLE);
            holder.getRLayoutHST().setVisibility(View.VISIBLE);
        } else {
            holder.getRLayoutSubtotal().setVisibility(View.GONE);
            holder.getRLayoutHST().setVisibility(View.GONE);
        }
    }
}
