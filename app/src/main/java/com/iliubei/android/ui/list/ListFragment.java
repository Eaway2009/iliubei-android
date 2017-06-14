package com.iliubei.android.ui.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.ArticleListItemEntity;
import com.iliubei.android.entity.commonEntity.BeforeDailyEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.mvpframe.base.BaseFrameFragment;
import com.iliubei.android.ui.adapter.ArticleListAdapter;
import com.iliubei.android.ui.widget.LoadMoreListViewWrap;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xn058827 on 2017/5/27.
 */

public class ListFragment extends BaseFrameFragment<ListPresenter, ListModel> implements ListContract.View {
    private static final String TAG = "ListFragment";
    public int themeId;

    @BindView(R.id.recyclerView)
    ListView mRecyclerView;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefresh;

    private ArticleListAdapter mArticleListAdapter;
    private LoadMoreListViewWrap mLoadMoreListViewWrap;

    private List<ArticleListItemEntity> mArticleList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        ButterKnife.bind(this, getContentView());

    }

    @Override
    public void initData() {
        mArticleList = new ArrayList<>();
        mArticleListAdapter = new ArticleListAdapter(getContext());
    }

    @Override
    public void initView() {
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

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                View lastchildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
//                int lastChildBottomY = lastchildView.getBottom();
//                int recyclerBottomY = recyclerView.getBottom() - recyclerView.getPaddingBottom();
//                int lastPosition = recyclerView.getLayoutManager().getPosition(lastchildView);
//            }
//        });
    }

    @Override
    public void initLoad() {
        getData();
    }

    public void getData() {
        mPresenter.getLatestDaily(themeId);
    }

    @Override
    public <T> void refreshHomeList(T t) {
        mArticleList.clear();
        ArticleListEntity themeContentListEntity = (ArticleListEntity)t;
        mArticleList.addAll(themeContentListEntity.getArticles());
        mArticleListAdapter.setDataList(mArticleList);
        mArticleListAdapter.notifyDataSetChanged();

        mSwipeRefresh.setRefreshing(false);
    }
}
