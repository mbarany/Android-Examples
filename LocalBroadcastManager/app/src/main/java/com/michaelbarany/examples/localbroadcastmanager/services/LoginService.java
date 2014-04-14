package com.michaelbarany.examples.localbroadcastmanager.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.michaelbarany.examples.localbroadcastmanager.AppIntent;

public class LoginService extends IntentService {
    private static final String NAME = "LoginService";

    public LoginService() {
        super(NAME);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do login stuff
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent i = new Intent(AppIntent.ACTION_ACCOUNT_AUTHENTICATED);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(i);
    }
}
