package com.rhinoactive.foreorder_golf_employee.fragments;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.activities.OrderActivity;
import com.rhinoactive.foreorder_golf_employee.events.ClubChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.CompleteOrderEvent;
import com.rhinoactive.foreorder_golf_employee.events.MenuSelectionChangedEvent;
import com.rhinoactive.foreorder_golf_employee.events.MenusDownloadedEvent;
import com.rhinoactive.foreorder_golf_employee.events.OrdersUpdatedEvent;
import com.rhinoactive.foreorder_golf_employee.events.UserLocationsUpdateEvent;
import com.rhinoactive.foreorder_golf_employee.generator.BlueMapMarkerIconGenerator;
import com.rhinoactive.foreorder_golf_employee.generator.MapMarkerIconGenerator;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.models.UserLocation;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.generalutilities.MainThreadRunner;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAndAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;
import com.rhinodesktop.locationutilities.newlocationupdates.events.LastKnownLocationEvent;
import com.rhinodesktop.locationutilities.newlocationupdates.utils.LastKnownLocationUtils;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by Hunter Andrin on 2017-05-01.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View rootView = inflater.inflate(R.layout.map_fragment, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Realm realm = Realm.getDefaultInstance();
        UserLocation currentUserLocation = null;
        User currentUser = realm.where(User.class).findFirst();
        if (currentUser != null) {
            currentUserLocation = currentUser.getUserLocation();
        }
        if (currentUserLocation != null) {
            connectToMaps();
        } else {
            LastKnownLocationUtils.getLastKnownLocation((AppCompatActivity) getActivity());
        }
    }

    //Must set views to null in order to prevent a memory leak: http://stackoverflow.com/a/13422819/6575556
    @Override
    public void onDestroyView() {
        ForeOrderSharedPrefUtils.setShouldDefaultToClubLocation(getContext(), false);
        ForeOrderSharedPrefUtils.setPreviousLatitudeOnMap(getContext(), mMap.getCameraPosition().target.latitude);
        ForeOrderSharedPrefUtils.setPreviousLongitudeOnMap(getContext(), mMap.getCameraPosition().target.longitude);
        ForeOrderSharedPrefUtils.setPreviousZoomLevel(getContext(), mMap.getCameraPosition().zoom);
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe
    public void onUserLocationsChanged(UserLocationsUpdateEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onOrdersUpdatedEvent(OrdersUpdatedEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onCompleteOrderEvent(final CompleteOrderEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onClubChangedEvent(ClubChangedEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onMenusDownloadedEvent(MenusDownloadedEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onMenuChangedEvent(MenuSelectionChangedEvent event) {
        refreshMapMarkers();
    }

    @Subscribe
    public void onLocationUpdatesEvent(LastKnownLocationEvent event) {
        final Location location = event.getLocation();
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User user = realm.where(User.class).findFirst();
                    user.setUserLocationF(location, realm);
                }
            });
        }
        connectToMaps();
    }

    private void connectToMaps() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_main);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        enableMyLocationAndRenderMarkers();
    }

    @SuppressLint("MissingPermission")
    protected void enableMyLocationAndRenderMarkers() {
        Realm realm = Realm.getDefaultInstance();
        try {
            if (mMap != null) {
                mMap.getUiSettings().setMapToolbarEnabled(false);
                mMap.setMyLocationEnabled(true);
                mMap.setOnMarkerClickListener(this);

                double lat;
                double lon;
                float zoomDistance;

                if (ForeOrderSharedPrefUtils.shouldDefaultToClubLocation(getContext())) {
                    Club currentClub = realm.where(Club.class).equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext())).findFirst();
                    lat = currentClub.getLat();
                    lon = currentClub.getLon();
                    zoomDistance = 15.0f;
                } else {
                    lat = ForeOrderSharedPrefUtils.getPreviousLatitudeOnMap(getContext());
                    lon = ForeOrderSharedPrefUtils.getPreviousLongitudeOnMap(getContext());
                    zoomDistance = ForeOrderSharedPrefUtils.getPreviousZoomLevel(getContext());
                }

                LatLng latLng = new LatLng(lat, lon);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomDistance));
                renderOrderMarkers();
            } else {
                Toast.makeText(getActivity(), "An error occurred. Try reloading the page.", Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException ex) {
            // Permission to access the location is missing.
            Timber.e("User has not yet allowed the app to track the their location.");
            Timber.e(ex);
        } finally {
            realm.close();
        }
    }

    private void renderOrderMarkers() {
        Realm realm = Realm.getDefaultInstance();
        ClubMenus currentClubMenu = realm.where(ClubMenus.class)
                .equalTo("clubMenusId", ForeOrderSharedPrefUtils.getCurrentClubId(getContext()))
                .findFirst();

        if (currentClubMenu != null) {
            List<MenuOrders> menuOrdersList = currentClubMenu.getListOfMenuOrders();
            for (MenuOrders menuOrders : new ArrayList<>(menuOrdersList)) {
                if (!menuOrders.getMenu().getSelected()) {
                    continue;
                }
                for (Order order : menuOrders.getOrders()) {
                    renderOrderMarker(order);
                }
            }
        }

        realm.close();
    }

    private void renderOrderMarker(Order order) {
        if (order.getUser().getUserLocation() != null) {
            LatLng currentLatLng = order.getUser().getUserLocation().getLatLng();
            MapMarkerIconGenerator mapMarkerIconGenerator = new BlueMapMarkerIconGenerator(order, (AppCompatActivity) this.getActivity());
            Bitmap bitmap = mapMarkerIconGenerator.makeMapMarkerIcon();
            Marker marker = mMap.addMarker(new MarkerOptions().position(currentLatLng)
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmap)).anchor(0.5f, 0.5f));
            // More information about associating data with a marker:
            // https://developers.google.com/maps/documentation/android-api/marker#display_additional_information_about_a_marker
            marker.setTag(order);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Order order = (Order) marker.getTag();
        ActivityAndAnimateManager.Builder builder = new ActivityAndAnimateManager.Builder((AppCompatActivity) getActivity(), OrderActivity.class, AnimationType.SLIDE_LEFT);
        builder.intExtra(OrderActivity.ORDER_ID_JSON_KEY, order.getOrderId());
        builder.buildActivityAndTransition();

        // Return true to indicate that we have consumed the event and that we do not wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return true;
    }

    private void refreshMapMarkers() {
        if (mMap != null) {
            MainThreadRunner.runFromUiThread(new Runnable() {
                @Override
                public void run() {

                    try {
                        mMap.clear();
                        renderOrderMarkers();
                    }
                    catch (Exception e)
                    {e.printStackTrace();}

                }
            });
        }
    }
}
