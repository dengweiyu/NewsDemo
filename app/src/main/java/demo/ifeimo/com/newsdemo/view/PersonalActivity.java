package demo.ifeimo.com.newsdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.ifeimo.com.newsdemo.R;
import demo.ifeimo.com.newsdemo.preference.PreferenceHelper;

/**
 * Created by Wing on 2018/4/14.
 */

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nick, name, sex;

    private LinearLayout zhuxiao;
    private RelativeLayout rl_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.person_activity);
        init();
        initView();
    }

    private void initView() {
        nick.setText(PreferenceHelper.getInstance().getNick(this));
        name.setText(PreferenceHelper.getInstance().getName(this));
        sex.setText(PreferenceHelper.getInstance().getSex(this));
        zhuxiao.setOnClickListener(this);
        rl_back.setOnClickListener(this);
    }

    private void init() {
        nick = (TextView) findViewById(R.id.nick);
        name = (TextView) findViewById(R.id.name);
        sex = (TextView) findViewById(R.id.sex);
        zhuxiao = (LinearLayout) findViewById(R.id.zhuxiao);
        rl_back = (RelativeLayout) findViewById(R.id.rl_personal_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuxiao:
                PreferenceHelper.getInstance().clear(this);
                finish();
                break;
            case R.id.rl_personal_back:
                finish();
                break;
        }

    }
}
