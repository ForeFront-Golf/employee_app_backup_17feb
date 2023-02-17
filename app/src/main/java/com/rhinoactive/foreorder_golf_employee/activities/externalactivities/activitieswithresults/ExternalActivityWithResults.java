package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithresults;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.rhinodesktop.activityanimatorutility.activityutils.externalactivities.ExternalActivity;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;
import com.rhinodesktop.activityanimatorutility.models.resultsrunners.ActivityResultRunner;
import com.rhinodesktop.activityanimatorutility.models.resultsrunners.FragmentResultRunner;
import com.rhinodesktop.activityanimatorutility.models.resultsrunners.ResultRunner;

/**
 * Created by hunter on 2018-02-15.
 */

/**
 * Abstract base class for a number of external activities that DO return a result.
 */
public abstract class ExternalActivityWithResults extends ExternalActivity {

    protected abstract int getRequestCode();

    private ResultRunner resultRunner;

    /**
     * Base constructor for an external activity that will return a result to an activity.
     *
     * @param activity The result will be returned to this activity's
     *  method.
     */
    public ExternalActivityWithResults(Activity activity) {
        super(activity);
        this.resultRunner = new ActivityResultRunner(activity);
    }

    /**
     * Base constructor for an external activity that will return a result to a fragment.
     *
     * @param fragment The result will be returned to this fragment's
     * {@link Fragment#onActivityResult(int, int, Intent)} method.
     */
    public ExternalActivityWithResults(Fragment fragment) {
        super(fragment.getActivity());
        this.resultRunner = new FragmentResultRunner(fragment);
    }

    /**
     * Base constructor for an external activity that will return a result to a support fragment.
     *
     */
//    public ExternalActivityWithResults(Fragment fragment) {
//        super(fragment.getActivity());
//        this.resultRunner = new SupportFragmentResultRunner(fragment);
//    }

    @Override
    protected void startActivity(Intent intent, AnimationType fadeIn) {
        int requestCode = getRequestCode();
        resultRunner.runActivityForResult(intent, requestCode, fadeIn);
    }
}
