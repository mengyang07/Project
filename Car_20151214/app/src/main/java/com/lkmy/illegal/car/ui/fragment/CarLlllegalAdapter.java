package com.lkmy.illegal.car.ui.fragment;

import android.app.Activity;

import com.lkmy.illegal.car.delegate.CarLllegalDelegate;
import com.lkmy.illegal.car.model.DisplayableItem;
import com.lkmy.illegal.car.widget.loadmore.LoadMoreRecyclerView;
import com.lkmy.library.delegate.ListDelegationAdapter;

import java.util.List;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:15
 * 描述:
 */

public class CarLlllegalAdapter extends ListDelegationAdapter {

    public CarLlllegalAdapter(Activity activity, List<DisplayableItem> items) {

        this.items = items;
        // Delegates


        this.delegatesManager.addDelegate(new CarLllegalDelegate(activity, LoadMoreRecyclerView.TYPE_LIST));

    }



}