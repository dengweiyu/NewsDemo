package demo.ifeimo.com.newsdemo.data.adapter;

import android.content.Entity;

/**
 * Created by Wing on 2018/4/7.
 */

public class BaseResponseEntity extends BaseEntity {
    private int code;
    private String msg = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
