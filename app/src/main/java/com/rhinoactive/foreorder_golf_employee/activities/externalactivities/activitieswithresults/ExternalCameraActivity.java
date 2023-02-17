package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithresults;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;

import com.rhinodesktop.activityanimatorutility.Constants;

import java.io.File;


/**
 * Created by hunter on 2018-03-19.
 */

/**
 * External camera activity that will return a full sized version of the captured image.
 *
 * Note: this class uses the {@link Constants#TAKE_PIC_RQST} as the request code.
 */
public class ExternalCameraActivity extends ExternalActivityWithResults {

    private String fileProviderAuth;
    private File imageFile;

    /**
     * Constructor for an external camera activity that will return the captured media data to an activity.
     *
     * @param activity The captured media data will be returned to this activity's
     *                 {@link Activity#onActivityResult(int, int, Intent)} method.
     * @param fileProviderAuth The authority for the app's file provider.
     *        @see <a href="https://developer.android.com/reference/android/support/v4/content/FileProvider.html"></a>
     *        for more information.
     * @param imageFile The image file to save the captured media to.
     */
    public ExternalCameraActivity(Activity activity, String fileProviderAuth, File imageFile) {
        super(activity);
        setGlobals(fileProviderAuth, imageFile);
    }

    /**
     * Constructor for an external camera activity that will return the captured media data to a fragment.
     *
     * @param fragment The captured media data will be returned to this fragment's
     *                 {@link Fragment#onActivityResult(int, int, Intent)} method.
     * @param fileProviderAuth The authority for the app's file provider.
     *        @see <a href="https://developer.android.com/reference/android/support/v4/content/FileProvider.html"></a>
     *        for more information.
     * @param imageFile The image file to save the captured media to.
     */
    public ExternalCameraActivity(Fragment fragment, String fileProviderAuth, File imageFile) {
        super(fragment);
        setGlobals(fileProviderAuth, imageFile);
    }

    /**
     * Constructor for an external camera activity that will return the captured media data to a support fragment.
     *
     * @param fragment The captured media data will be returned to this support fragment's
     *                 {@link android.support.v4.app.Fragment#onActivityResult(int, int, Intent)} method.
     * @param fileProviderAuth The authority for the app's file provider.
     *        @see <a href="https://developer.android.com/reference/android/support/v4/content/FileProvider.html"></a>
     *        for more information.
     * @param imageFile The image file to save the captured media to.
     */
//    public ExternalCameraActivity(Fragment fragment, String fileProviderAuth, File imageFile) {
//        super(fragment);
//        setGlobals(fileProviderAuth, imageFile);
//    }

    @Override
    protected Intent createIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri photoURI = FileProvider.getUriForFile(activity, fileProviderAuth, imageFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        return cameraIntent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_CAMERA;
    }

    @Override
    protected int getRequestCode() {
        return Constants.TAKE_PIC_RQST;
    }

    private void setGlobals(String fileProviderAuth, File imageFile) {
        this.fileProviderAuth = fileProviderAuth;
        this.imageFile = imageFile;
    }
}
