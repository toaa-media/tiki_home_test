package com.vn.tikihometest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.vn.tikihometest.R;
import com.vn.tikihometest.activities.base.BaseActivity;
import com.vn.tikihometest.fragments.MainFragment;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is main activity class that will handle all the behaviors of the application.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment(new MainFragment());
    }

    /**
     * Starts new fragment on top the screen.
     *
     * @param fragment the fragment.
     */
    private void startFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragment).commitAllowingStateLoss();
    }

}
