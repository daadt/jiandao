package com.example.jdd.home.contract;


import com.example.jdd.base.BaseView;
import com.example.jdd.home.bean.ColunmBean;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.net.INetCallBack;

public class RecommendContract {

    public interface IRecommendView extends BaseView {
        void  setRecommendList(NewsBean string);
        void setColumList(ColunmBean columList);
    }
    public interface IRecommendMode{
        <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack);
        <T> void getColumList(INetCallBack<T> iNetCallBack);
    }


    public interface IRecommendPresenter {

        void getColumList();
        void getRecommendList(String id);

    }


}
