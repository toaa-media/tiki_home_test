package com.vn.tikihometest.fragments;

import com.vn.tikihometest.fragments.base.BaseBindingFragment;
import com.vn.tikihometest.vms.MainVM;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is fragment for main screen.
 */
public class MainFragment extends BaseBindingFragment<MainVM> {

    @Override
    protected MainVM createViewModel() {
        return new MainVM(getContext());
    }
}
