package com.vn.tikihometest.vms.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.BaseObservable;

import com.vn.tikihometest.interfaces.IViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a base class for view model.
 */
public abstract class BaseVM extends BaseObservable implements IViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected Context context;

    public BaseVM(Context context) {
        this.context = context;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // nothing to do.
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // nothing to do.
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        compositeDisposable.clear();
    }
}
