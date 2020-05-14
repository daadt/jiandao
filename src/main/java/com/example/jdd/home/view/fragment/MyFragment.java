package com.example.jdd.home.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.jdd.R;
import com.example.jdd.base.BaseFragment;
import com.example.jdd.base.BasePresenter;
import com.example.jdd.login.view.LoginActivity;
import com.google.android.material.navigation.NavigationView;


public class MyFragment extends BaseFragment {

    private ImageView header_imgs;
    private RadioButton my_bu;
    private NavigationView mNavi;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initLinstener() {
        View headerView = mNavi.getHeaderView(0);

        header_imgs = headerView.findViewById(R.id.header_img);
        header_imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View view) {

        mNavi = (NavigationView) view.findViewById(R.id.navi);
    }

    @Override
    public int getLayoutID() {
        return R.layout.my_fragment;
    }
}
