package com.vn.tikihometest.adapters;

import android.view.View;

import com.vn.tikihometest.BR;
import com.vn.tikihometest.adapters.base.BaseHolder;
import com.vn.tikihometest.interfaces.IKeyword;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The holder is used for binding data of keyword in adapter.
 */
public class KeywordHolder extends BaseHolder<IKeyword> {

    public KeywordHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void bindData(IKeyword item, int position) {
        dataBinding.setVariable(BR.data, item);
        dataBinding.executePendingBindings();
    }

}
