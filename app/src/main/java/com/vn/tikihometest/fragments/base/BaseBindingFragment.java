package com.vn.tikihometest.fragments.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vn.tikihometest.interfaces.IViewModel;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a base class for fragment using data binding.
 */
public abstract class BaseBindingFragment<T extends IViewModel> extends Fragment {

    /**
     * The view model associating with the current fragment.
     */
    private T vm;
    /**
     * The ViewDataBinding of fragment root view.
     */
    private ViewDataBinding dataBinding;

    /**
     * Creates new instance of view model.
     *
     * @return the instance of view model.
     */
    protected abstract T createViewModel();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        vm = createViewModel();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, vm.getLayoutResId(), container, false);
        dataBinding.setVariable(vm.getVariableId(), vm);
        return dataBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vm.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        vm.onConfigurationChanged(newConfig);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        vm.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Gets the view model instance.
     *
     * @return the view model instance.
     */
    public T getVm() {
        return vm;
    }

    /**
     * Gets the ViewDataBinding instance.
     *
     * @return the ViewDataBinding instance.
     */
    public ViewDataBinding getDataBinding() {
        return dataBinding;
    }

}
