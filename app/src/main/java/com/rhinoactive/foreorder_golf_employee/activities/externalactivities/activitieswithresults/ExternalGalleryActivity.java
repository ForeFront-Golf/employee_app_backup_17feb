package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithresults;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.rhinodesktop.activityanimatorutility.Constants;

/**
 * Created by hunter on 2018-02-14.
 */

/**
 * Note: this class uses the {@link Constants#PICK_IMG_RQST} as the request code.
 */
public class ExternalGalleryActivity extends ExternalActivityWithResults {

    /**
     * Constructor for an external gallery activity that will return the selected media data to an activity.
     *
     * @param activity The selected media data will be returned to this activity's
     *                 {@link Activity#onActivityResult(int, int, Intent)} method.
     */
    public ExternalGalleryActivity(Activity activity) {
        super(activity);
    }

    /**
     * Constructor for an external gallery activity that will return the selected media data to a fragment.
     *
     * @param fragment The selected media data will be returned to this fragment's
     *                 {@link Fragment#onActivityResult(int, int, Intent)} method.
     */
    public ExternalGalleryActivity(Fragment fragment) {
        super(fragment);
    }

    /**
     * Constructor for an external gallery activity that will return the selected media data to a support fragment.
     *
     * @param fragment The selected media data will be returned to this support fragment's
     *                 {@link Fragment#onActivityResult(int, int, Intent)} method.
     */
//    public ExternalGalleryActivity(Fragment fragment) {
//        super(fragment);
//    }

    @Override
    protected Intent createIntent() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType(Constants.IMAGE_TYPE);
        return galleryIntent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_GALLERY;
    }

    @Override
    protected int getRequestCode() {
        return Constants.PICK_IMG_RQST;
    }
}
