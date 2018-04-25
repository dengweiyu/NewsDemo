package demo.ifeimo.com.newsdemo.Model;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.ifeimo.com.newsdemo.Interface.APIService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Wing on 2018/3/10.
 */

public class BaseModel implements NewsContract.Model {

    @Override
    public void loadData(final int type, final NewsContract.OnLoadFirstDataListener listener, int page) {
        APIService apiManager = RetrofitWrapper.getInstance().create(APIService.class);//这里采用的是Java的动态代理模式
        apiManager.getNewsData(TypeUrl.getTypeUrl(type), Constant.APIKEY, "10", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsItem, List<NewsItem.NewslistBean>>() {
                    @Override
                    public List<NewsItem.NewslistBean> call(NewsItem newsgson) { //
                        List<NewsItem.NewslistBean> newsList = new ArrayList<NewsItem.NewslistBean>();
                        for (NewsItem.NewslistBean newslistBean : newsgson.getNewslist()) {
                            NewsItem.NewslistBean new1 = new NewsItem.NewslistBean();
                            new1.setTitle(newslistBean.getTitle());
                            new1.setCtime(newslistBean.getCtime());
                            new1.setDescription(newslistBean.getDescription());
                            new1.setPicUrl(newslistBean.getPicUrl().replace("_ss", ""));
                            new1.setUrl(newslistBean.getUrl());
                            Map<String, Object> extra = new HashMap<>();
                            extra.put("type", TypeUrl.getTypeUrl(type));
                            new1.setExtra(extra);
                            newsList.add(new1);
                        }
                        return newsList; // 返回类型
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsItem.NewslistBean>>() {
                    @Override
                    public void onNext(List<NewsItem.NewslistBean> newsList) {
                        //成功  数据传出去
                        listener.onSuccess(newsList);
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                        listener.onFailure("请求失败", e);
                    }
                });


    }
}
