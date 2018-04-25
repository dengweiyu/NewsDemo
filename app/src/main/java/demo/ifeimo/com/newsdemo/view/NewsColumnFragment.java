package demo.ifeimo.com.newsdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.ifeimo.com.newsdemo.Model.NewsContract;
import demo.ifeimo.com.newsdemo.Presenter.Presenter;
import demo.ifeimo.com.newsdemo.R;
import demo.ifeimo.com.newsdemo.Model.NewsItem;
import demo.ifeimo.com.newsdemo.data.adapter.NewsItemAdapter;

/**
 * Created by Wing on 2018/4/9.
 */

public class NewsColumnFragment extends Fragment implements NewsContract.View {
    private final String TAG = this.getClass().getSimpleName();
    private MainActivity mActivity;
    private View mView;
    private String columnName;
    private NewsItemAdapter mNewsAdapter;
    private EasyRecyclerView recyclerView;
    private NewsContract.Presenter presenter;
    private int page = 1;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    private CardView cardView;

    public static NewsColumnFragment newInstance(String columnName) {
        final NewsColumnFragment fragment = new NewsColumnFragment();
        Bundle bundle = new Bundle();
        bundle.putString("columnId", columnName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_new, container, false);
        columnName = getArguments().getString("columnId");
        Log.i(TAG, columnName);
        presenter = new Presenter(this, getContext());
        cardView = mView.findViewById(R.id.cardview);
        recyclerView = mView.findViewById(R.id.fragment_new_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNewsAdapter = new NewsItemAdapter(getContext());
        recyclerView.setAdapter(mNewsAdapter);
        load();
        mNewsAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> data = new ArrayList<String>();
                data.add(mNewsAdapter.getAllData().get(position).getPicUrl());
                data.add(mNewsAdapter.getAllData().get(position).getUrl());
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data", data);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        mNewsAdapter.setMore(R.layout.load_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {

                presenter.loadData(toId(columnName), page);
                Log.i("name", "" + toId(columnName));
                page++;
            }


            @Override
            public void onMoreClick() {

            }
        });

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("refresh", "" + toId(columnName));
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mNewsAdapter.clear();
                        page = 0;
                        presenter.loadData(toId(columnName), page);

                    }
                }, 1000);
            }
        });

        return mView;

    }

    private void load() {

        presenter.loadData(toId(columnName), 0);
    }

    private int toId(String columnName) {
        switch (columnName) {
            case "social":
                return 0;
            case "guonei":
                return 1;
            case "world":
                return 2;
            case "huabian":
                return 3;
            case "tiyu":
                return 4;
            case "keji":
                return 5;
            case "health":
                return 6;
            case "military":
                return 7;
            case "meinv":
                return 8;
            default:
                return 0;
        }
    }

    @Override
    public void returnData(List<NewsItem.NewslistBean> datas) {

        mNewsAdapter.addAll(datas);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    private void lazyFetchDataIfPrepared() {

        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    protected void lazyFetchData() {
        presenter.loadData(toId(columnName), page);
        page++;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //视图销毁 数据设置为空
        hasFetchData = false;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
