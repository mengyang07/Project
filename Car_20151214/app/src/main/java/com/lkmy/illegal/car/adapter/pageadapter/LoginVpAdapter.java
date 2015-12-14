package com.lkmy.illegal.car.adapter.pageadapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.adapter.pageadapter.base.DigitGroupPagerAdapter;
import com.lkmy.illegal.car.ui.activity.MainActivity;
import com.lkmy.library.delegate.BaseAdapterViewHolder;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 02:14
 * 描述:在首次打开程序时LoginActivity中ViewPager的Adapter
 */
public class LoginVpAdapter extends DigitGroupPagerAdapter implements View.OnClickListener {

    private Activity activity;

    public LoginVpAdapter(int[] pics, Activity activity) {
        super(pics);
        this.activity = activity;
    }

    @Override
    public View newView(int position) {
        BaseAdapterViewHolder v = new BaseAdapterViewHolder(activity.getLayoutInflater().inflate(R.layout.login_page_layout, null));
        ImageView view = v.getImageView(R.id.login_viewpager_imagerview);
        view.setBackgroundResource(mData[position]);
        if (getCount() == position + 1) {
            Button button = v.getButton(R.id.login_viewpager_button);
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(this);
        }

        return v.getItemView();
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }


}
