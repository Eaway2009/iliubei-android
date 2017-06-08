package com.iliubei.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by xn058827 on 2017/5/27.
 */

public abstract class CommonListAdapter<T> extends BaseAdapter {

    protected  String TAG = this.getClass().getSimpleName();
    private List<T> mData;
    private int mLayoutId;
    protected Context mContext;

    public CommonListAdapter(Context context,int layoutId) {
        this.mLayoutId = layoutId;
        this.mContext = context;
    }

    public List<T> getDatas(){
        return mData;
    }

    /**
     * 添加数据
     * @param list
     */
    public void addMore(List<T> list) {
        if (mData == null) {
            mData = new ArrayList<T>();
        }
        mData.addAll(list);
    }

    /**
     * 重置数据
     * @param list
     */
    public void setDataList(List<T> list) {
        this.mData = list;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewsHolder viewHolder = ViewsHolder.getViewHolder(mContext, position, convertView, parent, mLayoutId);
        convert(viewHolder,getItem(position),position);
        return viewHolder.getConvertView();
    }

    protected abstract void convert(ViewsHolder viewHolder,T item,int position);
}
