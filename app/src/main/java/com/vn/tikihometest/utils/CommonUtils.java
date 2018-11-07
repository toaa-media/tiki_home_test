package com.vn.tikihometest.utils;

import android.graphics.Color;

import java.util.List;
import java.util.Random;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a utility class to define helper methods.
 */
public class CommonUtils {

    /**
     * Gets the random color.
     *
     * @return the random color.
     */
    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
    }

    /**
     * Gets ObservableTransformer instance that will be subscribed on the background thread and observed on the main thread.
     *
     * @return the instance of ObservableTransformer.
     */
    public static <T> ObservableTransformer<T, T> getObservableTransformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Checks the list is whether empty or not.
     *
     * @param list the list.
     * @return true if it is empty.
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

}
