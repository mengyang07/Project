package com.lkmy.illegal.car.delegate;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.model.CarLllegal;
import com.lkmy.illegal.car.model.DisplayableItem;
import com.lkmy.library.delegate.AbsAdapterDelegate;
import com.lkmy.library.delegate.BaseAdapterViewHolder;

import java.util.List;

/**
 * Created by 凯 on 2015/10/31.
 */
public class CarLllegalDelegate extends AbsAdapterDelegate<List<DisplayableItem>> {

    private LayoutInflater inflater;

    public CarLllegalDelegate(Activity activity, int viewType) {
        super(viewType);
        this.inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<DisplayableItem> items, int position) {
        return items.get(position) instanceof CarLllegal;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new BaseAdapterViewHolder(inflater.inflate(R.layout.carlllegal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<DisplayableItem> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        BaseAdapterViewHolder vh = (BaseAdapterViewHolder) holder;
        CarLllegal carLllegal = (CarLllegal) items.get(position);

        vh.getTextView(R.id.carlllegal_time).setText(carLllegal.getTime());
        vh.getTextView(R.id.carlllegal_add).setText(carLllegal.getAddress());
        vh.getTextView(R.id.carlllegal_content).setText(carLllegal.getContent());

    }


}
