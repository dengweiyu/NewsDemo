package demo.ifeimo.com.newsdemo.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import demo.ifeimo.com.newsdemo.Model.Person;
import demo.ifeimo.com.newsdemo.R;
import demo.ifeimo.com.newsdemo.data.adapter.database.OrderDao;
import demo.ifeimo.com.newsdemo.preference.PreferenceHelper;

/**
 * Created by Wing on 2018/4/13.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_member, et_password;
    private LinearLayout login, register;
    private TextListener textLisetener = new TextListener();
    private OrderDao orderDao;
    private List<Person> person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.avtivity_login);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.CENTER);
        orderDao = new OrderDao(this);
        init();
        initView();
    }

    private void initView() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        et_password.addTextChangedListener(textLisetener);
        et_member.addTextChangedListener(textLisetener);
    }

    private void init() {
        et_member = (EditText) findViewById(R.id.member_id);
        et_password = (EditText) findViewById(R.id.password);
        login = (LinearLayout) findViewById(R.id.tologin);
        register = (LinearLayout) findViewById(R.id.register);
        if (PreferenceHelper.getInstance().getLoginMember(this) != null && PreferenceHelper.getInstance().getLoginPassword(this) != null) {
            et_member.setText(PreferenceHelper.getInstance().getLoginMember(this));
            et_password.setText(PreferenceHelper.getInstance().getLoginPassword(this));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                if (et_member.getText().toString().length() < 10 && et_password.getText().toString().length() < 6) {
                    return;
                }
                String sign1 = orderDao.getMember_id(et_member.getText().toString(), et_password.getText().toString());

                if (null != sign1 && sign1.equals(et_member.getText().toString())) {
                    Toast.makeText(this, "该帐号已注册", Toast.LENGTH_SHORT).show();
                    Log.e("", "" + et_member.getText().toString());
                } else {
                    orderDao.addDatas(et_member.getText().toString(), et_password.getText().toString(), "", "", "萌蠢的新人", "");
                    Toast.makeText(this, "帐号注册成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tologin:
                Log.d("click:", "login");
                orderDao.getDatas(et_member.getText().toString(), et_password.getText().toString());
                String member_ = PreferenceHelper.getInstance().getMember(this);
                String word = PreferenceHelper.getInstance().getPassword(this);
                Log.d("", "memberId = " + member_ + "  " + "password = " + word);
                if (member_.equals(et_member.getText().toString()) && word.equals(et_password.getText().toString())) {
                    PreferenceHelper.getInstance().saveIfLogined("true", this);
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                    PreferenceHelper.getInstance().saveLoginMember(et_member.getText().toString(), this);
                    PreferenceHelper.getInstance().saveLoginPassword(et_password.getText().toString(), this);
                    finish();
                } else {
                    Toast.makeText(this, "登陆失败，请检查帐号密码是否正确", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    class TextListener implements TextWatcher {
        private CharSequence temp;
        private int editStart;
        private int editEnd;

        private void change() {
            boolean sign1 = et_member.getText().toString().length() >= 10;
            boolean sign2 = et_password.getText().toString().length() >= 6;
            if (sign1 && sign2) {
                login.setBackground(getResources().getDrawable(R.drawable.clickable));
                login.setClickable(true);
            } else {
                login.setBackground(getResources().getDrawable(R.drawable.unclickable));
                login.setClickable(false);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            temp = s;
            change();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            change();
        }

        @Override
        public void afterTextChanged(Editable s) {
            change();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

