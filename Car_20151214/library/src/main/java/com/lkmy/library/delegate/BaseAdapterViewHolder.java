package com.lkmy.library.delegate;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by lk on 15/10/30.
 */
public class BaseAdapterViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public BaseAdapterViewHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<View>();
    }

    public View getItemView() {
        return this.itemView;
    }

    public TextView getTextView(int viewId) {
        return retrieveView(viewId);
    }

    public Button getButton(int viewId) {
        return retrieveView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return retrieveView(viewId);
    }

    public ProgressBar getProgressBar(int viewId) {
        return retrieveView(viewId);
    }

    public RatingBar getRatingBar(int viewId) {
        return retrieveView(viewId);
    }

    public ViewPager getViewPager(int viewId) {
        return retrieveView(viewId);
    }

    public View getView(int viewId) {
        return retrieveView(viewId);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
