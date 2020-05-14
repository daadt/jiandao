package com.example.jdd.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 复用得Fragmnet   不需要复用。缓存就可以了
 * 懒加载
 */
public abstract  class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{


    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =  LayoutInflater.from(container.getContext()).inflate(getLayoutID(),container,false);
       //这个布局应该先加载 然后之后再请求数据,设置监听 基类代码顺序有问题现在好了
        initView(view);
        mPresenter =  initPresenter();
        if(null != mPresenter ){
            mPresenter.AttachView(this);
        }

        initData();
        initLinstener();


        return view;
    }

    protected abstract T initPresenter();
    protected abstract void initLinstener();
    protected abstract void initData();
    protected abstract void initView(View view);
    public abstract  int getLayoutID();
}
