package com.example.jdd.login.presenter;

import android.util.Log;

import com.example.jdd.base.BasePresenter;
import com.example.jdd.login.bean.AffirmRegisterBean;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.login.contract.LoginContract;
import com.example.jdd.login.model.LoginModel;
import com.example.jdd.net.INetCallBack;



public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter {
    LoginContract.ILoginMode iLoginMode;
    public LoginPresenter() {
        iLoginMode = new LoginModel();
    }

    @Override
    public void getVerified(String phoneNum,String type) {

        iLoginMode.getVerified(phoneNum, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean s) {

                mview.getVerified(s);
            }
            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void login(String mobile, String smsCode) {
        iLoginMode.login(mobile, smsCode, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean responseBody) {

                mview.getLoginResult(responseBody);
                Log.e("TAG","登录成功返回值："+responseBody.toString());

            }

            @Override
            public void onError(Throwable throwable) {
            }
        });
    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

        Log.e("TAG",phoneNum+"验证p层码值："+smsCode);

        iLoginMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {

                mview.checkSmsCodeResult(verfiedBean);
            }
            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
