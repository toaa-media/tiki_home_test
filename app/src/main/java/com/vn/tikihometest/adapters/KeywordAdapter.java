package com.vn.tikihometest.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vn.tikihometest.R;
import com.vn.tikihometest.adapters.base.BaseAdapter;
import com.vn.tikihometest.interfaces.IKeyword;

import java.util.List;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The adapter is used for showing the list of keyword in {@link android.support.v7.widget.RecyclerView}
 */
public class KeywordAdapter extends BaseAdapter<IKeyword, KeywordHolder> {

    public KeywordAdapter(List<IKeyword> items) {
        super(items);
    }

    @NonNull
    @Override
    public KeywordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new KeywordHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_keyword, viewGroup, false));
    }
}
