package com.example.jdd.login.contract;


import com.example.jdd.base.BaseView;
import com.example.jdd.login.bean.AffirmRegisterBean;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class LoginContract {

        public interface ILoginView extends BaseView {
            void getVerified(VerfiedBean s);

            void  getLoginResult(AffirmRegisterBean string);

            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface ILoginMode{
           <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

            <T> void login(String mobile, String smsCode, INetCallBack<T> iNetCallBack);
            <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
        }
        public interface ILoginPresenter{
            void getVerified(String string, String type);
            void login(String mobile, String smsCode);
            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
