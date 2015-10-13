package com.example.cokepedreira.ocalimochoapp;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by David on 13/10/15.
 */
public class BaseActivity extends AppCompatActivity {
    private final static int THEME_LIGHT = 1;
    private final static int THEME_DARK = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();
    }
    public void updateTheme() {
        if (Utility.getTheme(getApplicationContext()) <= THEME_LIGHT) {
            setTheme(R.style.AppTheme_Light);

        } else if (Utility.getTheme(getApplicationContext()) == THEME_DARK) {
            setTheme(R.style.AppTheme);
            }

    }
}
