package com.iliubei.android.ui.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.ArticleListItemEntity;
import com.iliubei.android.entity.themeDaily.ArticleListEntity;
import com.iliubei.android.mvpframe.base.BaseFrameFragment;
import com.iliubei.android.ui.adapter.ArticleListAdapter;
import com.iliubei.android.ui.widget.LoadMoreListViewWrap;
import com.iliubei.android.util.ToastUtils;

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
    public int page = 1;

    @BindView(R.id.recyclerView)
    ListView mRecyclerView;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLoadMoreLayout mSwipeRefresh;

    private ArticleListAdapter mArticleListAdapter;

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

        mSwipeRefresh.setOnLoadListener(new SwipeRefreshLoadMoreLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                getData(page);
            }
        });
    }

    @Override
    public void initLoad() {
        getData();
    }

    public void getData() {
        mPresenter.getLatestArticles(themeId);
    }

    public void getData(int page) {
        mPresenter.getArticleList(themeId, page);
    }

    @Override
    public <T> void refreshList(T t) {
        mArticleList.clear();
        ArticleListEntity themeContentListEntity = (ArticleListEntity) t;
        page = 2;
        mArticleList.addAll(themeContentListEntity.getArticles());
        mArticleListAdapter.setDataList(mArticleList);
        mArticleListAdapter.notifyDataSetChanged();

        mSwipeRefresh.setRefreshing(false);
        mSwipeRefresh.setLoading(false);
    }

    @Override
    public <T> void loadedList(T t) {
        ArticleListEntity themeContentListEntity = (ArticleListEntity) t;
        if (themeContentListEntity.getArticles() == null || themeContentListEntity.getArticles().size() < 1) {
            ToastUtils.showToast(getActivity(), getString(R.string.list_fragment_last_page));
            return;
        }
        page++;
        mArticleList.addAll(themeContentListEntity.getArticles());
        mArticleListAdapter.setDataList(mArticleList);
        mArticleListAdapter.notifyDataSetChanged();

        mSwipeRefresh.setRefreshing(false);
        mSwipeRefresh.setLoading(false);
    }
}
