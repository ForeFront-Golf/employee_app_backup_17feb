package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.rhinodesktop.activityanimatorutility.Constants;

import java.io.File;


/**
 * Created by hunter on 2018-02-14.
 */

/**
 * External activity class for opening a pdf in a pdf viewer application.
 */
public class ExternalPdfActivity extends ExternalActivityWithoutResult {

    private String fileProviderAuth;
    private File pdfFile;

    /**
     *
     * @param activity A reference to the calling activity.
     * @param fileProviderAuth The authority for the app's file provider.
     *        @see <a href="https://developer.android.com/reference/android/support/v4/content/FileProvider.html"></a>
     *        for more information.
     * @param pdfFile The pdf file to view.
     */
    public ExternalPdfActivity(Activity activity, String fileProviderAuth, File pdfFile) {
        super(activity);
        this.fileProviderAuth = fileProviderAuth;
        this.pdfFile = pdfFile;
    }

    @Override
    protected Intent createIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri fileUri = FileProvider.getUriForFile(activity, fileProviderAuth, pdfFile);
        intent.setDataAndType(fileUri, Constants.PDF_TYPE);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_NO_HISTORY);
        return intent;
    }

    @Override
    protected String getErrorMsg() {
        return Constants.CANNOT_OPEN_PDF;
    }
}
