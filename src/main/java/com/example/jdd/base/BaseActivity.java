package com.example.jdd.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public abstract class BaseActivity <P extends BasePresenter>extends AppCompatActivity implements BaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        mPresenter =  initPresenter();
        if(mPresenter!=null){
            mPresenter.AttachView(this);
        }
        initData();
        initLinstener();


    }

    protected abstract P initPresenter();

    public abstract void initView();

    public abstract void initData();

    public abstract void initLinstener();

    public abstract  int getLayoutID();

//    模板模式   规定子类需要干什么   Fragment   attachview


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }
}
