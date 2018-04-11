package demo.ifeimo.com.newsdemo.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import demo.ifeimo.com.newsdemo.R;

/**
 * Created by y on 2018/3/6.
 */

public class SlidingMenuView extends SlidingMenu {

    public SlidingMenuView(Context context) {
        super(context);

    }

    public SlidingMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public SlidingMenuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void setMode(int mode) {
        super.setMode(mode);
    }

    @Override
    public void setTouchModeAbove(int i) {
        super.setTouchModeAbove(i);
    }

    @Override
    public void setMenu(int res) {
        super.setMenu(res);
    }

    @Override
    public void setFadeDegree(float f) {
        super.setFadeDegree(f);
    }

    @Override
    public void setBehindOffsetRes(int resID) {
        super.setBehindOffsetRes(resID);
    }

    @Override
    public void attachToActivity(Activity activity, int slideStyle) {
        super.attachToActivity(activity, slideStyle);
    }


    @Override
    public void toggle() {
        super.toggle();
    }
}
