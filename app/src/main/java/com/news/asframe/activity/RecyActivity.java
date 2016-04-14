package com.news.asframe.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.news.asframe.R;
import com.news.asframe.adapter.RecyclerViewAdapter;
import com.news.asframe.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class RecyActivity extends BaseActivity {
    boolean isLoading;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.SwipeRefreshLayout)
    android.support.v4.widget.SwipeRefreshLayout SwipeRefreshLayout;
    @InjectView(R.id.add)
    TextView add;
    @InjectView(R.id.div)
    TextView div;

    private RecyclerViewAdapter adapter;
    private List<String> mDatas;

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);

        }


    }

    @Override
    public void initListener() {
        adapter = new RecyclerViewAdapter(this, mDatas);
        recyclerView.setAdapter(adapter);
        //listview
        //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //  recyclerView.setLayoutManager(linearLayoutManager);
        //3列的gridview-->竖直
        //  recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //5行的gridview
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
//瀑布流
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickLitener(new RecyclerViewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.show(RecyActivity.this, "click:" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                ToastUtils.show(RecyActivity.this, "Longclick:" + position);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_notice;
    }


    @OnClick({R.id.add, R.id.div})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                adapter.addData(1);
                break;
            case R.id.div:
                adapter.removeData(1);
                break;
        }
    }
}
