package com.example.jdd.home.presenter;


import com.example.jdd.base.BasePresenter;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.home.contract.NewsFragmentContract;
import com.example.jdd.home.contract.RecommendContract;
import com.example.jdd.home.model.NewsModel;
import com.example.jdd.net.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
    private NewsFragmentContract.INewsMode iNewsMode;
    @Override
    public void getColumList() {
    }
    public NewsPresenter() {

        iNewsMode = new NewsModel();
    }
    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mview.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {
            }
        });
    }
}
