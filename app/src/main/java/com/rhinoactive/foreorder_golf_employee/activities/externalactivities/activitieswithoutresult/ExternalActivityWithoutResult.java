package com.rhinoactive.foreorder_golf_employee.activities.externalactivities.activitieswithoutresult;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAnimationUtils;
import com.rhinodesktop.activityanimatorutility.activityutils.externalactivities.ExternalActivity;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

/**
 * Created by hunter on 2018-02-14.
 */

/**
 * Abstract base class for a number of external activities that DO NOT return a result.
 */
public abstract class ExternalActivityWithoutResult extends ExternalActivity {

    public ExternalActivityWithoutResult(Activity activity) {
        super(activity);
    }

    @Override
    protected void startActivity(Intent intent, AnimationType fadeIn) {
        ActivityAnimationUtils.startActivityWithAnimation(intent, (AppCompatActivity) activity, fadeIn);
    }
}
