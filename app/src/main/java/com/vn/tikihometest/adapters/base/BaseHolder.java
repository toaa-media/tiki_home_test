package com.vn.tikihometest.adapters.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a base class for RecyclerView ViewHolder.
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    protected ViewDataBinding dataBinding;

    public BaseHolder(View itemView) {
        super(itemView);
        dataBinding = DataBindingUtil.bind(itemView);
    }

    /**
     * Fills data from the object to the view.
     *
     * @param item     the item object.
     * @param position the position.
     */
    protected abstract void bindData(T item, int position);
}
