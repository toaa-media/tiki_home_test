package com.vn.tikihometest.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a base class for activity.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private boolean isAlive, isBackground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isAlive = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isBackground = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isBackground = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isAlive = false;
    }

    /**
     * Checks the activity is still alive or not
     *
     * @return true if it is alive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Checks the activity is in background or not.
     *
     * @return true if it is in background.
     */
    public boolean isBackground() {
        return isBackground;
    }
}
