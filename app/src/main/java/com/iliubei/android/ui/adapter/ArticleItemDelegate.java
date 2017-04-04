package com.iliubei.android.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.StoriesEntity;
import com.iliubei.android.loader.GlideImageLoader;
import com.iliubei.android.ui.detail.ArticleDetailActivity;
import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by yiyi on 2017/1/6.
 */

public class ArticleItemDelegate implements ItemViewDelegate<DisplaybleItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list_content;
    }

    @Override
    public boolean isForViewType(DisplaybleItem item, int position) {
        return item instanceof StoriesEntity;
    }

    @Override
    public void convert(ViewHolder holder, DisplaybleItem displaybleItem, int position) {
        final Context context = holder.getConvertView().getContext();

        final StoriesEntity storiesEntity = (StoriesEntity) displaybleItem;

        holder.setText(R.id.story_title_tv, storiesEntity.getTitle());

        if (storiesEntity.getImg() != null) {
            ImageView stroyImg = holder.getView(R.id.story_iv);
            //Glide.with(holder.getConvertView().getContext()).load(storiesEntity.getImages().get(0)).into(stroyImg);
            GlideImageLoader.getInstance().displayImage(context, storiesEntity.getImg(), stroyImg);

            if (!TextUtils.isEmpty(storiesEntity.getImg())) {
                holder.getView(R.id.multi_pic_iv).setVisibility(View.VISIBLE);
            } else {
                holder.getView(R.id.multi_pic_iv).setVisibility(View.GONE);
            }

            holder.getView(R.id.story_frame_iv).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.story_frame_iv).setVisibility(View.GONE);
        }

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra("articleId", storiesEntity.getId());
                context.startActivity(intent);
            }
        });

    }
}
