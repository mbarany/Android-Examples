package com.michaelbarany.examples.countdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends ActionBarActivity {
    private TextView mTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextField = (TextView) findViewById(R.id.text);

        new CountDownTimer(86400000, 1000) {
            public void onTick(long millisUntilFinished) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                mTextField.setText("Remaining: " + sdf.format(new Date(millisUntilFinished)));
            }

            public void onFinish() {
                mTextField.setText("Done!");
            }
        }.start();
    }
}
