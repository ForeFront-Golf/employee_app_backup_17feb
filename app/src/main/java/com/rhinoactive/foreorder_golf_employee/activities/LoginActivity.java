package com.rhinoactive.foreorder_golf_employee.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.rhinoactive.foreorder_golf_employee.R;
import com.rhinoactive.foreorder_golf_employee.events.LoginEvent;
import com.rhinoactive.foreorder_golf_employee.managers.apimanagers.AccountApiManager;
import com.rhinoactive.foreorder_golf_employee.models.Club;
import com.rhinoactive.foreorder_golf_employee.models.Session;
import com.rhinoactive.foreorder_golf_employee.models.User;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderApp;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderDialogUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderResourceUtils;
import com.rhinoactive.foreorder_golf_employee.utils.ForeOrderSharedPrefUtils;
import com.rhinoactive.foreorder_library_android.events.SessionValidCheckEvent;
import com.rhinoactive.foreorder_library_android.utils.Constants;
import com.rhinoactive.generalutilities.KeyboardUtils;
import com.rhinoactive.generalutilities.MainThreadRunner;
import com.rhinoactive.generalutilities.animations.AnimationUtils;
import com.rhinoactive.generalutilities.models.ShowViewAnimation;
import com.rhinoactive.imageutility.AwsMobileClientUtils;
import com.rhinoactive.imageutility.legaldocutils.DocS3LinkUtils;
import com.rhinoactive.imageutility.legaldocutils.LegalDocNameAndPath;
import com.rhinodesktop.activityanimatorutility.activityutils.ActivityAndAnimateManager;
import com.rhinodesktop.activityanimatorutility.models.AnimationType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import io.realm.Realm;

public class LoginActivity extends ToolbarActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LinearLayout loginLayout;
    private MaterialDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AwsMobileClientUtils.initAwsMobileClient(this, ForeOrderApp.getAppContext());
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_login);
        initViews();
        String notificationClubId = getIntent().getStringExtra(Constants.CLUB_ID);
        if (notificationClubId != null) {
            ForeOrderSharedPrefUtils.setNotificationClubId(this, Integer.parseInt(notificationClubId));
        }
        checkPreviousSessionValidity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onSessionValidCheck(SessionValidCheckEvent event) {
        boolean isSessionValid = event.isSuccessful();
        if (isSessionValid) {
            proceedToMainActivity();
        } else {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.where(User.class).findAll().deleteAllFromRealm();
                        realm.where(Session.class).findAll().deleteAllFromRealm();
                        realm.where(Club.class).findAll().deleteAllFromRealm();
                    }
                });
            }
            AnimationUtils.getInstance().showAnimation(loginLayout, ShowViewAnimation.SLIDE_UP, Constants.ANIM_DURATION);
        }
    }

    @Subscribe
    public void onLoginEvent(LoginEvent loginEvent) {
        progressDialog.dismiss();
        if (loginEvent.isSuccessful()) {
            proceedToMainActivity();
        } else {
            enableLoginButton(true);
        }
    }

    public void login(View v) {
        enableLoginButton(false);
        progressDialog = ForeOrderDialogUtils.getInstance().showProgressDialog(LoginActivity.this, Constants.LOGGING_IN, null);
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        AccountApiManager.loginUser(email, password);
    }

    private void initViews() {
        RelativeLayout mainLayout = findViewById(R.id.main_layout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.closeKeyboard(LoginActivity.this);
            }
        });
        emailEditText = findViewById(R.id.email_username_login);
        passwordEditText = findViewById(R.id.edittext_password_login);
        loginButton = findViewById(R.id.button_login);
        loginLayout = findViewById(R.id.llayout_login);
        initLegalDocLinks();
    }

    private void checkPreviousSessionValidity() {
        Realm realm = Realm.getDefaultInstance();
        Session session = realm.where(Session.class).findFirst();
        if (session != null && session.getSessionId() != null) {
            AccountApiManager.checkValidityOfCurrentSession();
        } else {
            loginLayout.setVisibility(View.VISIBLE);
        }
        realm.close();
    }

    private void enableLoginButton(final boolean enabled) {
        MainThreadRunner.runFromUiThread(new Runnable() {
            @Override
            public void run() {
                loginButton.setEnabled(enabled);
            }
        });
    }

    private void proceedToMainActivity() {
        MainThreadRunner.runFromUiThread(new Runnable() {
            @Override
            public void run() {
                ActivityAndAnimateManager.Builder builder = new ActivityAndAnimateManager.Builder(LoginActivity.this, MainActivity.class, AnimationType.FADE_IN);
                builder.clearStack();
                builder.buildActivityAndTransition();
            }
        });
    }

    private void initLegalDocLinks() {
        TextView legalDocsTextView = LoginActivity.this.findViewById(R.id.textview_legal_doc_links);
        TextView terms = LoginActivity.this.findViewById(R.id.textview_terms);
        TextView privacy = LoginActivity.this.findViewById(R.id.textview_privacy);




        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final String googleDocsUrl = "http://docs.google.com/viewer?url=https://forefront-userfiles-mobilehub-qa.s3.ap-southeast-1.amazonaws.com/public/terms/ForeOrderTerms.pdf";

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse(googleDocsUrl), "text/html");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse(Constants.TERMS_OF_USE_URL), "text/html");
//                startActivity(intent);


                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(Constants.TERMS_OF_USE_URL), "application/pdf");
                startActivity(browserIntent);

            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setDataAndType(Uri.parse(Constants.PRIVACY_POLICY_URL), "application/pdf");
                startActivity(browserIntent);
            }
        });
//        ForeOrderResourceUtils resourceUtils = ForeOrderResourceUtils.getInstance();
//        String precedingText = resourceUtils.strRes(R.string.terms_and_privacy_policy_login) + "\n";
//
//        String fileProviderAuth = resourceUtils.strRes(R.string.file_provider_authority);
//        String termsName = resourceUtils.strRes(R.string.terms_of_use);
//        String privacyName = resourceUtils.strRes(R.string.privacy_policy);
//        LegalDocNameAndPath terms = new LegalDocNameAndPath(termsName, Constants.TERMS_OF_USE_URL);
//        LegalDocNameAndPath privacy = new LegalDocNameAndPath(privacyName, Constants.PRIVACY_POLICY_URL);
//        DocS3LinkUtils.setLegalDocLinkSpannableString(legalDocsTextView, precedingText, terms, privacy, fileProviderAuth, this);
    }
}
