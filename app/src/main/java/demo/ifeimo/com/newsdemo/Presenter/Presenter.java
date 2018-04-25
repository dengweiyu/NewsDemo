package demo.ifeimo.com.newsdemo.Presenter;


import android.content.Context;
import android.util.Log;

import java.util.List;

import demo.ifeimo.com.newsdemo.Model.BaseModel;
import demo.ifeimo.com.newsdemo.Model.NewsContract;
import demo.ifeimo.com.newsdemo.Util.netWorkUtil;
import demo.ifeimo.com.newsdemo.Model.NewsItem;

/**
 * Created by Wing on 2018/3/10.
 */

public class Presenter implements NewsContract.Presenter, NewsContract.OnLoadFirstDataListener {
    private NewsContract.View view;
    private NewsContract.Model model;
    private Context context;

    public Presenter(NewsContract.View view, Context context) {
        this.view = view;
        this.model = new BaseModel();
        this.context = context;
    }


    @Override
    public void loadData(int type, int page) {
        if (netWorkUtil.isNetworkConnected(context) == false) {
            Log.e("NetWork", " is not connected");
            return;
        }
        model.loadData(type, this, page);
    }


    @Override
    public void onSuccess(List<NewsItem.NewslistBean> list) {
        view.returnData(list);
    }

    @Override
    public void onFailure(String str, Throwable e) {
        netWorkUtil.isNetworkConnected(context);
    }

}
