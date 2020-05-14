package com.example.jdd.login.presenter;


import com.example.jdd.base.BasePresenter;
import com.example.jdd.login.bean.AffirmRegisterBean;
import com.example.jdd.login.contract.AffirmContract;
import com.example.jdd.login.model.AffirmRegisterModel;
import com.example.jdd.net.INetCallBack;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContract.IAffirmView> implements AffirmContract.IAffirmPresenter {


    private final AffirmRegisterModel iAffirmMode;

    public AffirmRegisterPresenter() {

        iAffirmMode = new AffirmRegisterModel();
    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {
        iAffirmMode.register(phoneNum, password, affirm_password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean registerBean) {
                mview.registerResult(registerBean);
            }
            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
