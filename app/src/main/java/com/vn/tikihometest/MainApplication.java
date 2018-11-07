package com.vn.tikihometest;

import android.app.Application;

/**
 * Created by namhoainguyen on 11/6/18.
 */
public class MainApplication extends Application {

    private static MainApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    /**
     * Returns the current application instance.
     *
     * @return the application instance.
     */
    public static MainApplication application() {
        return application;
    }
}
