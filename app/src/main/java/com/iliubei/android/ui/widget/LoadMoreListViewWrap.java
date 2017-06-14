package com.iliubei.android.ui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.iliubei.android.R;

import java.util.ArrayList;
/**
 * [增加下滑自动加载更多的ListView]
 *
 * @author eaway
 */
public class LoadMoreListViewWrap {

    private final static String TAG = LoadMoreListViewWrap.class
            .getSimpleName();

    private View mFooterView;

    private ListView mListView;

    private AbsListView.OnScrollListener mUserOnScrollListener;

    private boolean mIsRefreshing = false;

    private boolean mIsShowError = false;

    public LoadMoreListViewWrap(ListView listview) {
        this.mListView = listview;
        listview.setOnScrollListener(mScrollListener);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener l) {
        this.mUserOnScrollListener = l;
    }

    AbsListView.OnScrollListener mScrollListener = new AbsListView.OnScrollListener() {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (mUserOnScrollListener != null) {
                mUserOnScrollListener.onScrollStateChanged(view, scrollState);
            }

//			Log.v(TAG, "onScrollStateChanged scrollState:" + scrollState);

            if (mIsRefreshing || mIsShowError) {
                return;
            }

            if (view.getAdapter() == null) {
                return;
            }

            if (mRefreshListener == null) {
                return;
            }

            if (!mRefreshListener.isCanLoadListMore()) {
                return;
            }

            if (mListView.getFooterViewsCount() == 0) {
                showFooterView();
            }

            if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                if (view.getLastVisiblePosition() != view.getAdapter()
                        .getCount() - 1) {
                    return;
                }
                onRefreshListData();
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem,
                             int visibleItemCount, int totalItemCount) {

            if (mUserOnScrollListener != null) {
                mUserOnScrollListener.onScroll(view, firstVisibleItem,
                        visibleItemCount, totalItemCount);
            }
        }
    };

    private void showFooterView() {
        Log.v(TAG, "showFooterView");
        if (mFooterView == null) {
            LayoutInflater inflater = (LayoutInflater) mListView.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mFooterView = inflater.inflate(R.layout.loading_more_view, null);
            int footerPadding = (int) (10 * mListView.getResources()
                    .getDisplayMetrics().density);
            mFooterView.findViewById(R.id.tv_loading_tip).setPadding(0,
                    footerPadding, 0, footerPadding);
        }
        mFooterView.findViewById(R.id.progressbar_loading).setVisibility(
                View.VISIBLE);
        mFooterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        TextView tipTextView = (TextView) mFooterView
                .findViewById(R.id.tv_loading_tip);
        tipTextView.setText("正在加载更多...");
        if (mListView.getFooterViewsCount() == 0) {
            mListView.addFooterView(mFooterView);
        }
    }

    public void showErrorFooterView() {
        mIsRefreshing = false;
        mIsShowError = true;
        if (mFooterView == null) {
            return;
        }
        mFooterView.findViewById(R.id.progressbar_loading).setVisibility(
                View.GONE);
        TextView tipTextView = (TextView) mFooterView
                .findViewById(R.id.tv_loading_tip);
        tipTextView.setText("加载失败，点击重试");
        mFooterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setOnClickListener(null);
                showFooterView();
                onRefreshListData();
            }
        });
        if (mListView.getFooterViewsCount() == 0) {
            mListView.addFooterView(mFooterView);
        }
    }

    private void onRefreshListData() {
        mIsRefreshing = true;
        mIsShowError = false;
        if (mRefreshListener != null) {
            mRefreshListener.onRefreshMoreListData();
        }
    }

    public void setAdapter(ListAdapter adapter) {
        ArrayList<ListView.FixedViewInfo> mHeaderViewInfos = new ArrayList<ListView.FixedViewInfo>();
        ArrayList<ListView.FixedViewInfo> mFooterViewInfos = new ArrayList<ListView.FixedViewInfo>();
        ListAdapter listAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos,	adapter);
        listAdapter.registerDataSetObserver(mDataseDataSetObserver);
        // 在Adapter设置前，没有设置HeaderView或者FooterView的情况下，add进去的footer会无法显示出来
        showFooterView();
        mListView.setAdapter(listAdapter);
        if (adapter instanceof BaseAdapter) {
            //触发 mDataseDataSetObserver
            ((BaseAdapter)adapter).notifyDataSetChanged();
        }
    }

    /**
     * 监听adapter的数据事件，屏幕不足一页时，将底部FooterView移除
     */
    DataSetObserver mDataseDataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
//			Log.v(TAG, "onChanged");
            if (!mRefreshListener.isCanLoadListMore()
                    && mListView.getFooterViewsCount() > 0) {
                refreshComplete();
            }
        }
    };

    public void refreshComplete() {
//		Log.v(TAG, "refreshComplete");
        mIsRefreshing = false;
        mIsShowError = false;
        if (mFooterView != null && mListView.getFooterViewsCount() > 0) {
            mListView.removeFooterView(mFooterView);
        }
    }

    public boolean isRefreshing() {
        return mIsRefreshing;
    }

    public boolean isShowMoreView() {
        return mListView.getFooterViewsCount() > 0;
    }

    private OnRefreshListener mRefreshListener;

    public void setOnRefreshListener(OnRefreshListener l) {
        mRefreshListener = l;
    }

    public OnRefreshListener getOnRefreshListener() {
        return mRefreshListener;
    }

    public interface OnRefreshListener {
        void onRefreshMoreListData();
        boolean isCanLoadListMore();
    }
}

