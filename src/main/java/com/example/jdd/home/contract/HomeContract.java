package com.example.jdd.home.contract;


import com.example.jdd.base.BaseView;
import com.example.jdd.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class HomeContract {

        public interface IHomeView extends BaseView {
            void  setBannView(String string);

        }
        public interface IHomeMode{
           <T> void getHomeBannview(INetCallBack<T> iNetCallBack);

        }
        public interface IHomePresenter{
            void callHomeBannview(String string);
            void getBannerView();
        }
}
