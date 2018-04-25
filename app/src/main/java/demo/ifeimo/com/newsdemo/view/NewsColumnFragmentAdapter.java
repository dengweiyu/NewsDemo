package demo.ifeimo.com.newsdemo.view;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Wing on 2018/4/9.
 */

public class NewsColumnFragmentAdapter extends FragmentStatePagerAdapter {
    private List<NewsColumnFragment> fragments;
    private String[] tabTitle;
    private FragmentManager fm;

    public NewsColumnFragmentAdapter(FragmentManager fm, List<NewsColumnFragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
        this.fm = fm;

    }


    @Override
    public NewsColumnFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
