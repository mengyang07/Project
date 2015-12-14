package com.lkmy.illegal.car.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.model.CarLllegalList;
import com.lkmy.illegal.car.model.DisplayableItem;
import com.lkmy.illegal.car.model.weather.Weather;
import com.lkmy.illegal.car.util.ThreadUtil;
import com.lkmy.illegal.car.widget.loadmore.LoadMoreRecyclerView;
import com.lkmy.library.loadingview.MultiStateView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者:李凯
 * 创建时间:2015/12/1 00:15
 * 描述:
 */
public class CarLlllegalFrgament2 extends BaseFragment {

    private CarLlllegalAdapter carLlllegalAdapter;
    private LoadMoreRecyclerView recyclerView;
    private List<DisplayableItem> displayableItems = new ArrayList<>();
    private PtrFrameLayout ptrFrameLayout;
    private PtrClassicDefaultHeader header;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void initView(Bundle savedInstanceState) {

        setContentView(R.layout.frgament_carllllegal);
        ptrFrameLayout = getViewById(R.id.fragment_car_ptr_layout);
        recyclerView = getViewById(R.id.fragment_car_recyclerview);
        header = new PtrClassicDefaultHeader(getContext());

    }


    @Override
    protected void setListener() {
        linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAutoLoadMoreEnable(true);
        carLlllegalAdapter = new CarLlllegalAdapter(getActivity(), displayableItems);
        recyclerView.setAdapter(carLlllegalAdapter);
        recyclerView.setLoadMoreListener(new LoadMoreRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mEngine.loadMoreData(1).enqueue(new Callback<CarLllegalList>() {
                            @Override
                            public void onResponse(Response<CarLllegalList> response, Retrofit retrofit) {
                                carLlllegalAdapter.addMoreDatas(response.body().getData());
                                recyclerView.notifyMoreFinish(false);
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }
                }, 2000);
            }
        });

        ptrFrameLayout.setPullToRefresh(true);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0)
                    return true;
                else return false;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mEngine.loadNewData(1).enqueue(new Callback<CarLllegalList>() {
                            @Override
                            public void onResponse(Response<CarLllegalList> response, Retrofit retrofit) {
                                carLlllegalAdapter.addNewDatas(response.body().getData());
                                recyclerView.switchLayoutManager(linearLayoutManager);
                                ptrFrameLayout.refreshComplete();

                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });

                    }
                }, 2000);
            }


        });
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mEngine.loadWeather("上海", "Ol9hrA1yFqaxdYmcB6GGaxc9", "json").enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Response<Weather> response, Retrofit retrofit) {
                Log.e("1", response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("1", t.getMessage().toString());

            }
        });
    }


    @Override
    protected void load() {
        mEngine.loadInitDatas().enqueue(new Callback<CarLllegalList>() {
            @Override
            public void onResponse(Response<CarLllegalList> response, Retrofit retrofit) {
                multiStateViewManager.setState(MultiStateView.VIEW_STATE_CONTENT);
                carLlllegalAdapter.setDatas(response.body().getData());
            }

            @Override
            public void onFailure(Throwable t) {
                multiStateViewManager.setState(MultiStateView.VIEW_STATE_ERROR);
            }
        });
    }


}
