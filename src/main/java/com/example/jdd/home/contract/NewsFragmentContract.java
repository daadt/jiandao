package com.example.jdd.home.contract;


import com.example.jdd.base.BaseView;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.net.INetCallBack;

public class NewsFragmentContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
