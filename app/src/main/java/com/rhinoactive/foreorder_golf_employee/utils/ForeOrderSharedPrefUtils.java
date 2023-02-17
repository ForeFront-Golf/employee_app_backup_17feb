package com.rhinoactive.foreorder_golf_employee.utils;

import android.content.Context;
import android.preference.PreferenceManager;

import com.rhinoactive.foreorder_library_android.utils.Constants;

/**
 * Created by sungwook on 2018-04-24.
 */

public class ForeOrderSharedPrefUtils {

    public static boolean shouldDefaultToClubLocation(Context context) {
        return getBooleanFromSharedPrefs(context, Constants.SHOULD_DEFAULT_MAP_TO_CLUB_LOCATION);
    }

    public static void setShouldDefaultToClubLocation(Context context, boolean shouldDefault) {
        saveBooleanToSharedPrefs(context, Constants.SHOULD_DEFAULT_MAP_TO_CLUB_LOCATION, shouldDefault);
    }

    public static double getPreviousLatitudeOnMap(Context context) {
        return getDoubleFromSharedPrefs(context, Constants.GET_PREVIOUS_LATITUDE);
    }

    public static void setPreviousLatitudeOnMap(Context context, double previousLatitude) {
        saveDoubleToSharedPrefs(context, Constants.GET_PREVIOUS_LATITUDE, previousLatitude);
    }

    public static double getPreviousLongitudeOnMap(Context context) {
        return getDoubleFromSharedPrefs(context, Constants.GET_PREVIOUS_LONGITUDE);
    }

    public static void setPreviousLongitudeOnMap(Context context, double previousLongitude) {
        saveDoubleToSharedPrefs(context, Constants.GET_PREVIOUS_LONGITUDE, previousLongitude);
    }

    public static float getPreviousZoomLevel(Context context) {
        return getFloatFromSharedPrefs(context, Constants.GET_PREVIOUS_ZOOM_LEVEL);
    }

    public static void setPreviousZoomLevel(Context context, float previousLongitude) {
        saveFloatToSharedPrefs(context, Constants.GET_PREVIOUS_ZOOM_LEVEL, previousLongitude);
    }

    public static int getNotificationClubId(Context context) {
        return getIntegerFromSharedPrefs(context, Constants.GET_NOTIFICATION_CLUB_ID);
    }

    public static void setNotificationClubId(Context context, int notificationClubId) {
        saveIntegerToSharedPrefs(context, Constants.GET_NOTIFICATION_CLUB_ID, notificationClubId);
    }

    public static int getPreviousClubId(Context context) {
        return getIntegerFromSharedPrefs(context, Constants.GET_PREVIOUS_CLUB_ID);
    }

    public static void setPreviousClubId(Context context, int previousClubId) {
        saveIntegerToSharedPrefs(context, Constants.GET_PREVIOUS_CLUB_ID, previousClubId);
    }

    public static int getCurrentClubId(Context context) {
        return getIntegerFromSharedPrefs(context, Constants.KEY_CURRENT_CLUB_ID);
    }

    public static void setCurrentClubId(Context context, int currentClubId) {
        saveIntegerToSharedPrefs(context, Constants.KEY_CURRENT_CLUB_ID, currentClubId);
    }

    public static int getCurrentUserId(Context context) {
        return getIntegerFromSharedPrefs(context, Constants.KEY_CURRENT_USER_ID);
    }

    public static void setCurrentUserId(Context context, int currentUserId) {
        saveIntegerToSharedPrefs(context, Constants.KEY_CURRENT_USER_ID, currentUserId);
    }

    private static Integer getIntegerFromSharedPrefs(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, -1);
    }

    private static void saveIntegerToSharedPrefs(Context context, String key, int value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(key, value)
                .apply();
    }

    private static boolean getBooleanFromSharedPrefs(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false);
    }

    private static void saveBooleanToSharedPrefs(Context context, String key, boolean value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    private static float getFloatFromSharedPrefs(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(key, 15);
    }

    private static void saveFloatToSharedPrefs(Context context, String key, float value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putFloat(key, value)
                .apply();
    }

    private static double getDoubleFromSharedPrefs(Context context, String key) {
        return Double.longBitsToDouble(PreferenceManager.getDefaultSharedPreferences(context).getLong(key, 0));
    }

    private static void saveDoubleToSharedPrefs(Context context, String key, double value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putLong(key, Double.doubleToRawLongBits(value))
                .apply();
    }
}
