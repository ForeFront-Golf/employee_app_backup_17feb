package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.rhinodesktop.activityanimatorutility.Constants;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by hunter on 2018-02-14.
 */

/**
 * External activity class for opening an external link.
 */
public class ExternalLinkActivity extends ExternalActivityWithoutResult {

    private String url;

    /**
     * @param activity A reference to the calling activity.
     * @param url The url of the external link.
     */
    public ExternalLinkActivity(Activity activity, String url) {
        super(activity);
        this.url = url;
    }

    @Override
    protected Intent createIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_LINK;
    }
}
