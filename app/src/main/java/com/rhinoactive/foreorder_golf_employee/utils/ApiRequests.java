package com.rhinoactive.foreorder_golf_employee.utils;

import android.os.Build;

import com.rhinoactive.foreorder_golf_employee.BuildConfig;
import com.rhinoactive.foreorder_golf_employee.models.ClubMenus;
import com.rhinoactive.foreorder_golf_employee.models.Menu;
import com.rhinoactive.foreorder_golf_employee.models.MenuOrders;
import com.rhinoactive.foreorder_golf_employee.models.Order;
import com.rhinoactive.foreorder_golf_employee.models.Session;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.models.UserLocation;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.generalutilities.apirequestutilities.ApiRequestsUtility;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by Hunter Andrin on 2017-04-28.
 */

public class ApiRequests extends ApiRequestsUtility {

    private static ApiRequests apiRequests = null;

    private ApiRequests() {
    }

    public static ApiRequests getInstance() {
        if (apiRequests == null) {
            apiRequests = new ApiRequests();
        }
        return apiRequests;
    }

    public Call validateSession() throws GeneralSecurityException {
        String validateUrl = Constants.VALIDATE;
        return getRequest(validateUrl);
    }

    public Call invalidateSession(int userId) throws GeneralSecurityException {
        String logoutUrl = Constants.USER + "/" + userId + "/" + Constants.LOGOUT;
        Map<String, Object> params = new HashMap<>();
        return putRequest(logoutUrl, params);
    }

    public Call login(String email, String password) throws GeneralSecurityException {
        String loginUrl = Constants.LOGIN + "?" + Constants.FULL_TRUE;
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.EMAIL, email);
        params.put(Constants.PASSWORD, password);
        return postRequest(loginUrl, params);
    }

    public Call getMenusForClub(ClubMenus clubMenus) throws GeneralSecurityException {
        int clubId = clubMenus.getClub().getClubId();
        String menusUrl = Constants.CLUB + "/" + clubId + "/" + Constants.MENU;
        if (clubMenus.getListOfMenuOrders().size() > 0) {
            long modifiedAt = OrderDataUtils.getLastModifiedMenuTime(clubMenus.getListOfMenuOrders());
            menusUrl = menusUrl + "?" + Constants.MODIFIED_AT + "=" + modifiedAt;
        }
        return getRequest(menusUrl);
    }

    public Call getOrdersForMenus(int clubId, List<MenuOrders> listOfMenuOrders) throws GeneralSecurityException {
        String ordersUrl = Constants.CLUB + "/" + clubId + "/" + Constants.ORDER + "?" + Constants.FULL_TRUE;
        String menuParameter = "&" + getStringArrayOfMenuIds();
        ordersUrl = ordersUrl + menuParameter;
        if (OrderDataUtils.menusHaveOrders(listOfMenuOrders)) {
            long modifiedAt = OrderDataUtils.getLastModifiedOrderTime(listOfMenuOrders);
            ordersUrl = ordersUrl + "&" + Constants.MODIFIED_AT + "=" + modifiedAt;
        }
        return getRequest(ordersUrl);
    }

    public Call markOrderComplete(Order order) throws GeneralSecurityException {
        Integer clubId = order.getClubId();
        Integer orderId = order.getOrderId();
        String orderUrl = Constants.CLUB + "/" + clubId + "/" + Constants.ORDER + "/" + orderId;
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.FULFILLED, true);
        params.put(Constants.CURRENT_STATE, Constants.COMPLETED);
        return putRequest(orderUrl, params);
    }

    public Call markOrderReceived(Order order) throws GeneralSecurityException {
        Integer clubId = order.getClubId();
        Integer orderId = order.getOrderId();
        String orderUrl = Constants.CLUB + "/" + clubId + "/" + Constants.ORDER + "/" + orderId;
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.CURRENT_STATE, Constants.RECEIVED);
        return putRequest(orderUrl, params);
    }

    public Call updateCurrentUserLocation(User user) throws GeneralSecurityException {
        String locationUrl = Constants.USER + "/" + user.getUserId() + "/" + Constants.LOCATION;
        UserLocation userLocation = user.getUserLocation();
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.LAT, userLocation.getLat());
        params.put(Constants.LON, userLocation.getLon());
        return postRequest(locationUrl, params);
    }

    public Call getUserLocations(ClubMenus clubMenus) throws GeneralSecurityException {
        int clubId = clubMenus.getClub().getClubId();
        String usersAtClubUrl = Constants.CLUB + "/" + clubId + "/" + Constants.LOCATION + "?" + getStringArrayOfMenuIds();
        return getRequest(usersAtClubUrl);
    }

    @Override
    protected Request.Builder buildRequest(String url) {
        Request.Builder builder = super.buildRequest(url);
        builder.addHeader(com.rhinoactive.generalutilities.Constants.ACCEPT, APPLICATION_JSON);
        return builder;
    }

    @Override
    protected String getServerUrl() {
        return Constants.SERVER_URL;
    }

    @Override
    protected String getAuthorizationValue() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Session> sessionResults = realm.where(Session.class).sort("createdAt").findAll();
        if (sessionResults.isEmpty()) {
            realm.close();
            return "";
        } else {
            String sessionId = sessionResults.last().getSessionId();
            realm.close();
            return sessionId;
        }
    }

    @Override
    protected String getAppVersionNumber() {
//        return BuildConfig.VERSION_NAME;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.APP_NAME_EMPLOYEE);
        sb.append(String.format("/%s", BuildConfig.VERSION_NAME));
        sb.append(String.format(" (Android; %s)", Build.VERSION.RELEASE));
        return sb.toString();

    }

    private String getStringArrayOfMenuIds() {
        Realm realm = Realm.getDefaultInstance();
        List<Menu> menuList = realm.where(Menu.class)
                .equalTo("clubId", ForeOrderSharedPrefUtils.getCurrentClubId(ForeOrderApp.getAppContext()))
                .findAll();
        StringBuilder menuParameter = new StringBuilder(Constants.MENU_IDS + "=[");
        for (Menu menu : menuList) {
            menuParameter.append(menu.getMenuId()).append(",");
        }

        menuParameter.setLength(menuParameter.length() - 1);
        menuParameter.append("]");
        realm.close();
        return menuParameter.toString();
    }
}
