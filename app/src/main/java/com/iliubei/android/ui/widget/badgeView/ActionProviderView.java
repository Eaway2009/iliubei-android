package com.iliubei.android.ui.widget.badgeView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iliubei.android.R;

/**
 * Created by eaway on 17/1/17.
 */

public class ActionProviderView extends ActionProvider {

    private ImageView mImageView;
    private TextView mTextView;

    public ActionProviderView(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        int size = getContext().getResources().getDimensionPixelSize(android.support.design.R.dimen.abc_action_bar_default_height_material);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(size, size);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_menu_action_provider, null, false);
        view.setLayoutParams(params);

        mImageView = (ImageView) view.findViewById(R.id.icon);
        mTextView = (TextView) view.findViewById(R.id.num_tv);

        return view;
    }

    public void setImage(Drawable icon) {
        mImageView.setImageDrawable(icon);
    }

    public void setNumInt(String num) {
        mTextView.setText(num);
    }
}
