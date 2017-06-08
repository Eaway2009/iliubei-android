package com.iliubei.android.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.commonEntity.LatestDailyEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.entity.themeDaily.ThemeContentListEntity;
import com.iliubei.android.global.Constants;
import com.iliubei.android.mvpframe.base.BaseFrameFragment;
import com.iliubei.android.ui.adapter.HYArticleListAdapter;
import com.iliubei.android.ui.adapter.HomeHeaderItem;
import com.iliubei.android.ui.adapter.ThemeHeaderItem;
import com.iliubei.android.ui.adapter.ThemeSectionItem;
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

    public String TYPE = Constants.StoryType.STORY_HOME;

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

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (TYPE.equals(Constants.StoryType.STORY_THEME)) return;
                View lastchildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                int lastChildBottomY = lastchildView.getBottom();
                int recyclerBottomY = recyclerView.getBottom() - recyclerView.getPaddingBottom();
                int lastPosition = recyclerView.getLayoutManager().getPosition(lastchildView);
            }
        });
    }

    @Override
    public void initLoad() {
        getData();
    }

    public void getData() {
        if (TYPE.equals(Constants.StoryType.STORY_HOME)) {
            mPresenter.getLatestDaily();
        } else {
//            mPresenter.getOtherThemeList(themeId, 1);
        }
    }

    @Override
    public <T> void refreshHomeList(T t) {
        mArticleList.clear();

        if (TYPE == Constants.StoryType.STORY_HOME) {
            LatestDailyEntity latestDailyEntity = (LatestDailyEntity)t;
            Log.i(TAG, "refreshHomeList: "+latestDailyEntity.toString());
            mArticleList.add(new HomeHeaderItem(latestDailyEntity.getBanner()));
            mArticleList.addAll(latestDailyEntity.getAllPager());
        } else {
            ArticleListEntity themeContentListEntity = (ArticleListEntity)t;

//            mArticleList.add(new ThemeHeaderItem(themeContentListEntity.getImage(), themeContentListEntity.getDescription()));
//            mArticleList.add(new ThemeSectionItem(themeContentListEntity.getEditors()));
            mArticleList.addAll(themeContentListEntity.getArticles());
        }

        mArticleListAdapter.notifyDataSetChanged();
        mRecyclerView.scrollToPosition(0);
        mSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void loadBeforeDaily(BeforeDailyEntity beforeDailyEntity) {
        mdate = beforeDailyEntity.getDate();

        mArticleList.add(new HomeSectionItem(mdate));
        mArticleList.addAll(beforeDailyEntity.getStories());
        mArticleListAdapter.notifyDataSetChanged();
    }

}

