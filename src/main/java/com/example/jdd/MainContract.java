package com.example.jdd;


import com.example.jdd.base.BaseView;
import com.example.jdd.net.INetCallBack;



public class MainContract {

        public interface IMainView extends BaseView {

        }

        public interface IMainMode{
          <T>  void getRecommendList(INetCallBack<RemBean> netCallBack);
        }

        public interface IMainPresenter{

            void getRecommendList();


        }
}
