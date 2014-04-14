package com.michaelbarany.examples.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;

public abstract class AbstractInteractiveActivity extends ActionBarActivity {
    protected abstract String[] getObservableActions();
    protected abstract void onEventReceived(String action, Intent intent);

    @Override
    protected void onResume() {
        super.onResume();

        for (String action : getObservableActions()) {
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(
                mReceiver,
                new IntentFilter(action)
            );
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mReceiver);
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onEventReceived(intent.getAction(), intent);
        }
    };
}
