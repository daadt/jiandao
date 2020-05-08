package com.example.jdd.home.view.fragment;


import android.view.View;

import com.example.jdd.R;
import com.example.jdd.base.BaseFragment;
import com.example.jdd.base.BasePresenter;
import com.example.jdd.home.presenter.HomePresenterImpl;


public class TopicFragment extends BaseFragment {
    @Override
    protected BasePresenter initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    protected void initLinstener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.topic_fragment;
    }
}
