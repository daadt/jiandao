package com.example.jdd.login.contract;


import com.example.jdd.base.BaseView;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.net.INetCallBack;

public class AffirmPassWordContract {


    public interface IAffirmPaswView extends BaseView {

        //            逻辑判断在P层判断--为了简单一点，扔道Acitivty
        void registerResult(VerfiedBean bean);
    }
    public interface IAffirmPaswMode{
        <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack);
    }
    public interface IAffirmPaswPresenter{
        void forgetPasw(String mobile, String sms_code, String password);

    }
}
