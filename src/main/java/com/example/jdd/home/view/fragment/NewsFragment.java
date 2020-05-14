package com.example.jdd.home.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdd.R;
import com.example.jdd.base.BaseFragment;
import com.example.jdd.home.adapter.NewsAdapter;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.home.contract.NewsFragmentContract;
import com.example.jdd.home.presenter.NewsPresenter;


import cn.jzvd.Jzvd;

/**
 *新闻列表页面
 * 多布局得页面
 * 4种布局
 */
public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsFragmentContract.INewsView {

    private  String tabID;

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;

    public NewsFragment(String tabID) {
        this.tabID = tabID;
    }
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }
    @Override
    protected void initLinstener() {
    }
    @Override
    protected void initData() {
        mPresenter.getRecommendList(tabID);
    }
    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.news_recycleview);
    }
    @Override
    public int getLayoutID() {
        return R.layout.fragment_news;
    }

    public void isCurrentVisibleToUser(boolean isVisible) {
        if(newsAdapter !=null) newsAdapter.isCurrentVisibleToUser(isVisible);
    }
    @Override
    public void setRecommendList(NewsBean newsBean) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(getActivity(),newsBean);
        recyclerView.setAdapter(newsAdapter);
    }
    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

}
