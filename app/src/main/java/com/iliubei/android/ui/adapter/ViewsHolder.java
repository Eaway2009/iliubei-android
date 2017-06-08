package com.iliubei.android.ui.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewsHolder {

    private static final String TAG = ViewsHolder.class.getSimpleName();

    private SparseArray<View> mSparse;
    private View mConvertView;

    public View getConvertView() {
        return mConvertView;
    }

    public ViewsHolder(View convertView) {
        this.mConvertView = convertView;
        mSparse = new SparseArray<View>();
    }

    public static ViewsHolder getViewHolder(Context context,int position, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId,null);
            ViewsHolder viewHoloder = new ViewsHolder(convertView);
            convertView.setTag(viewHoloder);
            return viewHoloder;
        }
        return (ViewsHolder)convertView.getTag();
    }

    public <T extends  View>T getView(int viewId) {

        View view = mSparse.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mSparse.put(viewId,view);
        }

        return (T)view;
    }

}
