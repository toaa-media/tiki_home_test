package com.vn.tikihometest.interfaces;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.LayoutRes;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The interface for view model.
 */
public interface IViewModel {

    /**
     * Gets the layout resource id for data binding.
     *
     * @return the layout resource id.
     */
    @LayoutRes
    int getLayoutResId();

    /**
     * Gets variable id for data binding.
     *
     * @return the variable id.
     */
    int getVariableId();

    /**
     * Called by the system when the device configuration changes while your activity is running.
     *
     * @param newConfig the new device configuration.
     */
    void onConfigurationChanged(Configuration newConfig);

    /**
     * Called when an activity you launched exits, giving you the requestCode you started it with, the resultCode it returned, and any additional data from it
     *
     * @param requestCode The integer request code.
     * @param resultCode  The integer result code.
     * @param data        An Intent, which can return result data to the caller
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);

    /**
     * Called when the view model is created.
     */
    void onCreate();

    /**
     * Called when the view model is destroyed.
     */
    void onDestroy();
}
