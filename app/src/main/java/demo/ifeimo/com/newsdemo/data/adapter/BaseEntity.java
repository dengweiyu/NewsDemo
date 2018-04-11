package demo.ifeimo.com.newsdemo.data.adapter;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Wing on 2018/4/7.
 */

public class BaseEntity implements Serializable {

    protected final String tag = this.getClass().getSimpleName();
    protected final String action = this.getClass().getName();
    protected Map<String, Object> extra;

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public String toString() {
        return this.toJSON();
    }

    public Object clone() {
        BaseEntity baseEntity = null;
        try {
            baseEntity = (BaseEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return baseEntity;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
