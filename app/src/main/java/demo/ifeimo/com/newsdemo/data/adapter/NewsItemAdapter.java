package demo.ifeimo.com.newsdemo.data.adapter;

import android.content.Context;

import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import demo.ifeimo.com.newsdemo.Model.NewsItem;

/**
 * Created by y on 2018/3/6.
 */

public class NewsItemAdapter extends RecyclerArrayAdapter<NewsItem.NewslistBean> {


    public NewsItemAdapter(Context context) {
        super(context);

    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }


}


