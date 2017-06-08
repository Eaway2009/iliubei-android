package com.iliubei.android.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.ArticleListItemEntity;
import com.iliubei.android.entity.commonEntity.StoriesEntity;
import com.iliubei.android.loader.GlideImageLoader;
import com.iliubei.android.ui.detail.ArticleDetailActivity;
import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class ArticleListAdapter extends CommonListAdapter<ArticleListItemEntity> {

    public ArticleListAdapter(Context context) {
        super(context, R.layout.item_story_list_content);
    }

    @Override
    protected void convert(ViewsHolder holder, ArticleListItemEntity item, int position) {
        final Context context = holder.getConvertView().getContext();

        final ArticleListItemEntity storiesEntity = (ArticleListItemEntity) item;

        ((TextView)holder.getView(R.id.story_title_tv)).setText(storiesEntity.getTitle());

        if (storiesEntity.getImg() != null) {
            ImageView stroyImg = holder.getView(R.id.story_iv);
            //Glide.with(holder.getConvertView().getContext()).load(storiesEntity.getImages().get(0)).into(stroyImg);
            GlideImageLoader.getInstance().displayImage(context, storiesEntity.getImg(), stroyImg);

            holder.getView(R.id.story_frame_iv).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.story_frame_iv).setVisibility(View.GONE);
        }

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra("articleId", storiesEntity.getAid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void setDataList(List<ArticleListItemEntity> list) {
        super.setDataList(list);
        notifyDataSetChanged();
    }
}
