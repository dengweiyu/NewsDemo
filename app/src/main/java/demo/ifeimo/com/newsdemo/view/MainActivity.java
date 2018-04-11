package demo.ifeimo.com.newsdemo.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.List;


import demo.ifeimo.com.newsdemo.Model.TypeUrl;
import demo.ifeimo.com.newsdemo.R;
import demo.ifeimo.com.newsdemo.data.adapter.NewsItem;
import demo.ifeimo.com.newsdemo.data.adapter.NewsItemAdapter;

public class MainActivity extends AppCompatActivity {
    private List<String> title;
    private SlidingMenuView mSlidingMenuView;
    private MagicIndicator mMagicIndicator;
    private CommonNavigator commonNavigator;
    private ViewPager mViewPager;
    private List<NewsColumnFragment> mFragments;
    private NewsColumnFragmentAdapter mNewsColumnFragmentApadter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        initView();
        if (title == null) {
            title = new ArrayList<>();
        }
        setMagicIncator();
    }

    private void setMagicIncator() {
        commonNavigator = new CommonNavigator(getApplicationContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return TypeUrl.getCount().size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                commonPagerTitleView.setContentView(R.layout.pager_title_layout);

                final ImageView iv = commonPagerTitleView.findViewById(R.id.title_tab_background);
                final TextView tv = commonPagerTitleView.findViewById(R.id.title_tab_text);
                tv.setText(setTitleText(index));

                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index, int totalCount) {
                        tv.setTextColor(Color.WHITE);
                        iv.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        tv.setTextColor(Color.BLACK);
                        iv.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {

                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {

                    }
                });
                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mViewPager.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator, mViewPager);
    }

    private String setTitleText(int index) {

        switch (TypeUrl.getCount().get(index)) {
            case "social":
                return "社会新闻";

            case "guonei":
                return "国内新闻";

            case "world":
                return "国际新闻";

            case "huabian":
                return "娱乐新闻";

            case "tiyu":
                return "体育新闻";

            case "keji":
                return "科技新闻";

            case "health":
                return "健康知识";

            case "military":
                return "军事新闻";

            case "meinv":
                return "美女图片";

            default:
                return null;

        }


    }

    private void initView() {
        //SlidingMenuSetting
        mSlidingMenuView = new SlidingMenuView(this);
        mSlidingMenuView.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        mSlidingMenuView.setMenu(R.layout.slidingmenu_main);
        mSlidingMenuView.setFadeDegree(0.35f);
        mSlidingMenuView.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        mSlidingMenuView.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        mSlidingMenuView.setMode(SlidingMenu.LEFT);

        mMagicIndicator = (MagicIndicator) findViewById(R.id.main_MagicIndicator);
        mViewPager = (ViewPager) findViewById(R.id.main_ViewPager);
        initFragment();
        initViewPager();
    }

    private void initViewPager() {
        mNewsColumnFragmentApadter = new NewsColumnFragmentAdapter(getSupportFragmentManager(), mFragments, new String[]{});
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mNewsColumnFragmentApadter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initFragment() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        } else {
            mFragments.clear();
        }
        if (TypeUrl.getCount() != null) {
            for (int i = 0; i < TypeUrl.getCount().size(); i++) {
                mFragments.add(NewsColumnFragment.newInstance(TypeUrl.getCount().get(i)));
                Log.d("i", TypeUrl.getCount().get(i));
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
