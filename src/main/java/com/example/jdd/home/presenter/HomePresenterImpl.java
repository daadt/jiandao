package com.example.jdd.home.presenter;


import com.example.jdd.base.BasePresenter;
import com.example.jdd.home.bean.User;
import com.example.jdd.home.contract.HomeContract;
import com.example.jdd.home.model.HomeModelImpl;
import com.example.jdd.home.view.HomeActivity;
import com.example.jdd.net.INetCallBack;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeMode  iHomeMode;


    public HomePresenterImpl() {
        iHomeMode = new HomeModelImpl(this);
    }
    @Override
    public void callHomeBannview(String string) {

        mview.setBannView(string);
    }
    @Override
    public void getBannerView() {
        iHomeMode.getHomeBannview(new INetCallBack<User>() {
            @Override
            public void onSuccess(User user) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
