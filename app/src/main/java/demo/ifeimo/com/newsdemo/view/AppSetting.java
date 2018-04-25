package demo.ifeimo.com.newsdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.ifeimo.com.newsdemo.R;

/**
 * Created by Wing on 2018/4/13.
 */

public class AppSetting extends AppCompatActivity {
    @BindView(R.id.setting_back)
    RelativeLayout relativeLayout;
    @BindView(R.id.about)
    LinearLayout linearLayoutl;

    Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        unbinder = ButterKnife.bind(this);

    }

    @OnClick(R.id.about)
    public void onAbout() {
        startActivity(new Intent(AppSetting.this, AppAboutActivity.class));
    }

    @OnClick(R.id.setting_back)
    public void onBackClick() {
        finish();
        ;
    }


}
