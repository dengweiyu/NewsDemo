package demo.ifeimo.com.newsdemo.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.ifeimo.com.newsdemo.R;

/**
 * Created by Wing on 2018/4/12.
 */

public class AppAboutActivity extends AppCompatActivity {

    @BindView(R.id.about_back)
    RelativeLayout relativeLayout;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.about_back)
    public void onBack() {
        finish();
    }

}
