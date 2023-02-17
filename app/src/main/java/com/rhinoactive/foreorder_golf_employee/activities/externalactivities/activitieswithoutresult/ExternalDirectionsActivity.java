package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.rhinodesktop.activityanimatorutility.Constants;

/**
 * Created by hunter on 2018-02-14.
 */

/**
 * External activity class for opening google maps navigation.
 *
 * Google maps navigation will provide an optimized route to an address.
 */
public class ExternalDirectionsActivity extends ExternalActivityWithoutResult {

    private String address;
    /**
     * @param activity A reference to the calling activity.
     * @param address The address to navigate to. Should be in the form of a street address.
     *               Example: "205 Horton St E #201, London, ON"
     */
    public ExternalDirectionsActivity(Activity activity, String address) {
        super(activity);
        this.address = address;
    }

    @Override
    protected Intent createIntent() {
        Intent directionsIntent = new Intent(Intent.ACTION_VIEW);
        String formattedAddress = Constants.GOOGLE_MAPS_URI + Uri.encode(address);
        directionsIntent.setData(Uri.parse(formattedAddress));
        directionsIntent.setPackage(Constants.GOOGLE_MAPS_PACKAGE);
        return directionsIntent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_GOOGLE_MAPS;
    }
}
