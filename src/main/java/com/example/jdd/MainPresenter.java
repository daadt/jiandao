package com.example.jdd;

import android.util.Log;

import com.example.jdd.base.BasePresenter;
import com.example.jdd.net.INetCallBack;


public class MainPresenter  extends BasePresenter<MainActivity> implements MainContract.IMainPresenter {

    private MainContract.IMainMode iMainMode;

    public MainPresenter() {
        iMainMode = new MainModel();
    }


    @Override
    public void getRecommendList() {

        iMainMode.getRecommendList(new INetCallBack<RemBean>() {
            @Override
            public void onSuccess(RemBean remBean) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
