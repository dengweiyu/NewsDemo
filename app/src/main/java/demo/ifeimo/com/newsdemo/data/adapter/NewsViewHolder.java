package demo.ifeimo.com.newsdemo.data.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import demo.ifeimo.com.newsdemo.Model.NewsItem;
import demo.ifeimo.com.newsdemo.R;

/**
 * Created by Wing on 2018/4/10.
 */

public class NewsViewHolder extends BaseViewHolder<NewsItem.NewslistBean> {
    private ImageView imageView;
    private TextView textTime;
    private TextView textTitle;
    private TextView textContent;

    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.mian_list);

        imageView = $(R.id.main_item_img);
        textTime = $(R.id.main_item_tv);
        textTitle = $(R.id.main_item_title);
        textContent = $(R.id.main_item_content);


    }

    @Override
    public void setData(NewsItem.NewslistBean data) {
        textTitle.setText(data.getTitle());
        textTime.setText(data.getCtime());
        textContent.setText(data.getDescription());
        if (data.getPicUrl() != null && data.getPicUrl() != "null" && data.getPicUrl().length() != 0) {
            showImage(imageView, getContext(), data.getPicUrl());
        } else {
            imageView.setVisibility(View.GONE);
        }
    }


    private void showImage(ImageView iv, Context context, String ImageUrl) {
        Glide.with(context).load(ImageUrl).placeholder(R.drawable.img_background).centerCrop().into(iv);
    }

}
