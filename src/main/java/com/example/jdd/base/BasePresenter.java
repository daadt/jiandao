package com.example.jdd.base;

public class BasePresenter<T extends BaseView> {
    protected T mview;

    public void AttachView(T baseView){
        mview = baseView;
    }
    public void disAttachView(){
        mview = null;
    }
}
