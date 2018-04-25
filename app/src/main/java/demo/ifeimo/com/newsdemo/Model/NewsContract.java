package demo.ifeimo.com.newsdemo.Model;

import java.util.List;

/**
 * Created by Wing on 2018/4/7.
 */

public class NewsContract {
    public interface View {
        void returnData(List<NewsItem.NewslistBean> datas);
    }

    public interface OnLoadFirstDataListener {
        void onSuccess(List<NewsItem.NewslistBean> list);

        void onFailure(String str, Throwable e);
    }

    public interface Presenter {
        void loadData(int type, int page);
    }

    public interface Model {
        void loadData(int type, OnLoadFirstDataListener listener, int page);
    }
}
