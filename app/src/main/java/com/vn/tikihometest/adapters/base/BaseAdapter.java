package com.vn.tikihometest.adapters.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This is a base class for RecyclerView adapter.
 */
public abstract class BaseAdapter<T, H extends BaseHolder<T>> extends RecyclerView.Adapter<H> {

    private List<T> items;

    public BaseAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public void onBindViewHolder(@NonNull H holder, int position) {
        holder.bindData(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    /**
     * Sets the list of items to adapter.
     *
     * @param items the list of items
     */
    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    /**
     * Clears all items in adapter.
     */
    public void clearAll() {
        if (items != null) {
            items.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * Gets the item representing at a position.
     *
     * @param position the position
     * @return the item object.
     */
    public T getItem(int position) {
        if (items == null || position < 0 || position > items.size() - 1) return null;
        return items.get(position);
    }

    /**
     * Gets all items in adapter.
     *
     * @return the list of items.
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * Gets position of an item.
     *
     * @param t the item.
     * @return the position.
     */
    public int getPosition(T t) {
        return items.indexOf(t);
    }
}
