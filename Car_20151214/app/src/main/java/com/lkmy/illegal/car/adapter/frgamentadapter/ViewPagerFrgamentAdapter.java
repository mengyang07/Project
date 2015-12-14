package com.lkmy.illegal.car.adapter.frgamentadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lkmy.illegal.car.model.FragmentModel;
import com.lkmy.illegal.car.adapter.UnderButtonAdapter;

import java.util.List;

/**
 * Created by 凯 on 2015/11/2.
 */
public class ViewPagerFrgamentAdapter extends FragmentStatePagerAdapter implements UnderButtonAdapter {
    private List<FragmentModel> data;

    public ViewPagerFrgamentAdapter(FragmentManager fm, List<FragmentModel> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position).getFragment();
    }


    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public String getTitleText(int index) {
        return data.get(index).getTitleText();
    }

    @Override
    public int getImageRes(int index) {
        return data.get(index).getImageRes();
    }

}