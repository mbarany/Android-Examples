package com.michaelbarany.examples.imagespan;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.widget.Button;

public class MainActivity extends Activity {
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findButtons();
        button1();
        button2();
        button3();
        button4();
        button5();
        button6();
    }

    private void button1() {
        Spannable buttonLabel = new SpannableString("  " + mButton1.getText());
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
        int height = 45;
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BOTTOM),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton1.setText(buttonLabel);
    }

    private void button2() {
        String text = "" + mButton2.getText();
        int textLength = text.length();
        Spannable buttonLabel = new SpannableString(text + "  ");
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
        int height = 45;
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BOTTOM),
            textLength + 1,
            textLength + 2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton2.setText(buttonLabel);
    }

    private void button3() {
        Spannable buttonLabel = new SpannableString("  " + mButton3.getText());
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
        int height = 30;
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BOTTOM),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton3.setText(buttonLabel);
    }

    private void button4() {
        Spannable buttonLabel = new SpannableString("  " + mButton4.getText());
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
        int height = 30;
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BASELINE),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton4.setText(buttonLabel);
    }

    private void button5() {
        Spannable buttonLabel = new SpannableString("  " + mButton5.getText());
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
        int height = 100;
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BOTTOM),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton5.setText(buttonLabel);
    }

    private void button6() {
        Spannable buttonLabel = new SpannableString("  " + mButton6.getText());
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher);

        float textSizeSp = mButton6.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
        int heightSp = 6 + (int) textSizeSp;
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, heightSp, getResources().getDisplayMetrics());
        d.setBounds(0, 0, height, height);
        buttonLabel.setSpan(
            new ImageSpan(d, ImageSpan.ALIGN_BOTTOM),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        mButton6.setText(buttonLabel);
    }

    private void findButtons() {
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
    }
}
