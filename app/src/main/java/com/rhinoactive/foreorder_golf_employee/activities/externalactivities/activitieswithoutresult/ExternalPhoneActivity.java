package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.rhinodesktop.activityanimatorutility.Constants;

/**
 * Created by hunter on 2018-02-14.
 */

/**
 * External activity class for making a phone call.
 */
public class ExternalPhoneActivity extends ExternalActivityWithoutResult {

    private String phoneNumber;

    /**
     * @param activity A reference to the calling activity.
     * @param phoneNumber The phone number to call.
     */
    public ExternalPhoneActivity(Activity activity, String phoneNumber) {
        super(activity);
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected Intent createIntent() {

            Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
            String number = Constants.TEL_URI + phoneNumber;
            phoneIntent.setData(Uri.parse(number));
            return phoneIntent;



//        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
//        String number = Constants.TEL_URI + phoneNumber;
//        phoneIntent.setData(Uri.parse(number));
//        return phoneIntent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_PHONE;
    }
}
