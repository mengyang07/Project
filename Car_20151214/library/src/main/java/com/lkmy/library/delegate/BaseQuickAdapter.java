package com.lkmy.library.delegate;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lk on 15/10/30.
 */

public abstract class BaseQuickAdapter<T> extends AbsAdapterDelegate<List<T>> {

    private LayoutInflater inflater;
    private int layoutId;

    public BaseQuickAdapter(Activity activity, int viewType, int layoutId) {
        super(viewType);
        inflater = activity.getLayoutInflater();
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new BaseAdapterViewHolder(inflater.inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<T> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder) {
        T item = items.get(position);
        convert((BaseAdapterViewHolder) holder, item);
    }

    protected abstract void convert(BaseAdapterViewHolder helper, T item);

}
