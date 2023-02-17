package com.rhinoactive.foreorder_golf_employee.activities;

import androidx.annotation.NonNull;
import androidx.legacy.app.ActivityCompat;

import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderDialogUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.generalutilities.GpsUtils;
import com.rhinoactive.permissionutilities.ActivityPermissionManager;
import com.rhinoactive.permissionutilities.interfaces.PermissionRequestResultCallback;
import com.rhinoactive.permissionutilities.models.Permission;
import com.rhinodesktop.locationutilities.GoogleApiAvailabilityUtils;
import com.rhinodesktop.locationutilities.newlocationupdates.utils.LocationServiceUtils;

/**
 * Created by Hunter Andrin on 2017-05-10.
 */

public abstract class TrackUserLocationActivity extends DrawerAppBarActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static int locationUpdateInterval = 30000;

    private ActivityPermissionManager permissionManager;
    private static final String LOCATION_PERMISSION_RATIONALE = ForeOrderResourceUtils.getInstance().strRes(R.string.permission_rationale_location_employer);
    private static final String LOCATION_RATIONALE_TITLE = ForeOrderResourceUtils.getInstance().strRes(R.string.location_permission_rationale_title);
    private static final String LOCATION_PERMISSION_DENIED = ForeOrderResourceUtils.getInstance().strRes(R.string.location_permission_denied);
    private static final String LOCATION_PERMISSION_REQUIRED = ForeOrderResourceUtils.getInstance().strRes(R.string.permission_required);

    //This is in the onStart as opposed to the onCreate so that the location service starts after the user enables their gps tracking
    @Override
    public void onStart() {
        super.onStart();
        GoogleApiAvailabilityUtils.displayErrorIfGooglePlayServicesUnavailable(this);
        permissionManager = new ActivityPermissionManager(Permission.LOCATION_PERMISSION, this);
        boolean locationPermissionGranted = permissionManager.isPermissionGranted();
        if (locationPermissionGranted) {
            connectLocationTracker();
        } else {
            permissionManager.requestPermissionWithRationalDialog(LOCATION_PERMISSION_RATIONALE, LOCATION_RATIONALE_TITLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.handlePermissionResult(requestCode, permissions, grantResults, new PermissionRequestResultCallback() {
            @Override
            public void permissionGranted() {
                connectLocationTracker();
            }

            @Override
            public void permissionDenied() {
                permissionManager.displayPermissionDeniedDialog(true, LOCATION_PERMISSION_DENIED, LOCATION_PERMISSION_REQUIRED);
            }
        });
    }

    private void connectLocationTracker() {
        boolean isGpsEnabled = GpsUtils.isGpsEnabled(this);
        if (isGpsEnabled) {
            LocationServiceUtils.getInstance().startService(this, locationUpdateInterval);
        } else {
            GpsUtils.buildDialogForNoGps(this, ForeOrderDialogUtils.getInstance(), this.getResources()
                    .getString(R.string.gps_not_enabled_content_employer));
        }
    }
}
