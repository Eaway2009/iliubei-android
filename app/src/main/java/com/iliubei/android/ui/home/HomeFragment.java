package com.iliubei.android.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.global.Constants;
import com.iliubei.android.mvpframe.base.BaseFrameFragment;
import com.iliubei.android.ui.adapter.HYArticleListAdapter;
import com.iliubei.android.ui.adapter.HomeHeaderItem;
import com.iliubei.android.ui.drawer.DisplaybleItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaway on 2017/4/4.
 */

public class HomeFragment extends BaseFrameFragment<HomePresenter, HomeModel> implements HomeContract.View {
    private static final String TAG = "HomeFragment";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefresh;

    private HYArticleListAdapter mArticleListAdapter;

    private List<DisplaybleItem> mArticleList;

    public int themeId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ButterKnife.bind(this, getContentView());

    }

    @Override
    public void initData() {
        mArticleList = new ArrayList<>();
        mArticleListAdapter = new HYArticleListAdapter(getContext(), mArticleList);
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mArticleListAdapter);
    }

    @Override
    public void initListener() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

    }

    @Override
    public void initLoad() {
        getData();
    }

    public void getData() {
        mPresenter.getIndexPage();
    }

    @Override
    public <T> void refreshHomeList(T t) {
        mArticleList.clear();
        LatestDailyEntity latestDailyEntity = (LatestDailyEntity) t;
        Log.i(TAG, "refreshHomeList: " + latestDailyEntity.toString());
        mArticleList.add(new HomeHeaderItem(latestDailyEntity.getBanner()));
        mArticleList.addAll(latestDailyEntity.getAllPager());
        mArticleListAdapter.notifyDataSetChanged();
        mRecyclerView.scrollToPosition(0);
        mSwipeRefresh.setRefreshing(false);
    }

}

