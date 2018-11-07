package com.vn.tikihometest;

import android.databinding.BindingAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

/**
 * Created by namhoainguyen on 11/6/18.
 *
 * This class is used to specify the adapters for data binding.
 */
public class DataBindingManager {

    /**
     * Sets an adapter to the input {@link RecyclerView}
     *
     * @param recyclerView the input recyclerView
     * @param adapter      the adapter
     */
    @BindingAdapter("recyclerAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        if (adapter != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    /**
     * Sets a layout manager object to the input {@link RecyclerView}
     *
     * @param recyclerView  the input recyclerView
     * @param layoutManager the layout manager
     */
    @BindingAdapter("recyclerLayoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    /**
     * Sets background color to {@link CardView}
     *
     * @param cardView the cardView
     * @param color    the background color
     */
    @BindingAdapter("cardBackgroundColor")
    public static void setBackgroundColor(CardView cardView, int color) {
        cardView.setCardBackgroundColor(color);
    }

}
