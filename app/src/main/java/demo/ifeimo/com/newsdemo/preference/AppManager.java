package demo.ifeimo.com.newsdemo.preference;

import android.app.Activity;

import java.util.HashSet;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Wing on 2018/4/14.
 */

public class AppManager {
    protected final String action = this.getClass().getName();
    protected final String tag = this.getClass().getSimpleName();
    private Stack<Activity> activities;



    private static AppManager instance;

    /*单一实例*/
    public static AppManager getInstance() {
        if (null == instance) {
            instance = new AppManager();
        }
        return instance;
    }

}
