package demo.ifeimo.com.newsdemo.Interface;

import demo.ifeimo.com.newsdemo.data.adapter.BaseEntity;

/**
 * Created by Wing on 2018/4/7.
 */

public class BaseHttpResult<T> extends BaseEntity {
    private String msg = "";
    public T newslist;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getNewslist() {
        return newslist;
    }

    public void setNwslist(T newslist) {
        this.newslist = newslist;
    }

}
