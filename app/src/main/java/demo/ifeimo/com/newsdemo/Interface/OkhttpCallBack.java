package demo.ifeimo.com.newsdemo.Interface;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Wing on 2018/3/10.
 */
public interface OkhttpCallBack {

    void onSuccess(JSONObject data);

    void onFailure(IOException msg);

    void onError();

    void onComplete();

    void setList();

}
