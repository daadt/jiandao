package com.example.jdd.home.model;


import com.example.jdd.base.BaseModel;
import com.example.jdd.home.contract.HomeContract;
import com.example.jdd.net.INetCallBack;
import com.example.jdd.net.NetWorkFactory;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeMode {

    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public <T> void getHomeBannview(INetCallBack<T> netCallBack) {
        iHomePresenter.callHomeBannview("");
        NetWorkFactory.getInstance().getNetWork().get("/app/ssdf",netCallBack);
    }
}
