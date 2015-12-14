package com.lkmy.illegal.car.adapter.pageadapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.lkmy.illegal.car.adapter.pageadapter.base.ListPagerAdapter;
import com.lkmy.illegal.car.model.Carousel;
import com.lkmy.illegal.car.ui.activity.WebActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 01:58
 * 描述:
 */
public class AutoViewPagerAdapter extends ListPagerAdapter {
    private Activity activity;


    public AutoViewPagerAdapter(Activity activity, List<Carousel> carousels) {
        super(carousels);
        this.activity = activity;
    }


    @Override
    public View newView(int position) {
        Carousel carousel = (Carousel) list.get(position);
        ImageView view = new ImageView(activity);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(carousel.getImageUrl(), view);
        view.setOnClickListener(new ItemClickListener(position));
        return view;
    }


    /**
     * 条目点击事件监听类
     */
    protected class ItemClickListener implements View.OnClickListener {
        private int position = 0;
        private Carousel carousel;

        public ItemClickListener(int position) {
            this.position = position;
            carousel = (Carousel) list.get(position);

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), WebActivity.class);
            intent.setData(Uri.parse(carousel.getOpenUrl()));
            activity.startActivity(intent);

        }
    }

}
