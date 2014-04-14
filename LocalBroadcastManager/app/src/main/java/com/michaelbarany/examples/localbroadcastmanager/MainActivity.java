package com.michaelbarany.examples.localbroadcastmanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.michaelbarany.examples.localbroadcastmanager.services.LoginService;

public class MainActivity extends AbstractInteractiveActivity {
    private TextView mStatus;

    @Override
    protected String[] getObservableActions() {
        return new String[] {
            AppIntent.ACTION_ACCOUNT_AUTHENTICATED,
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatus = (TextView) findViewById(R.id.status);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);

        Spannable text = new SpannableString("Status: Not Authenticated");
        text.setSpan(new ForegroundColorSpan(Color.RED), 8, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mStatus.setText(text);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginService.class);
                i.putExtra("email", email.getText());
                i.putExtra("password", password.getText());
                startService(i);
            }
        });
    }

    @Override
    protected void onEventReceived(String action, Intent intent) {
        switch (action) {
            case AppIntent.ACTION_ACCOUNT_AUTHENTICATED:
                Spannable text = new SpannableString("Status: Authenticated");
                text.setSpan(new ForegroundColorSpan(Color.GREEN), 8, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mStatus.setText(text);
                break;
        }
    }
}
