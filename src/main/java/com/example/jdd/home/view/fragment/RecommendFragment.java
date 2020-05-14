package com.example.jdd.home.view.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jdd.R;
import com.example.jdd.base.BaseFragment;
import com.example.jdd.home.adapter.NewsFragmentAdapter;
import com.example.jdd.home.adapter.Rec_vpAdapter;
import com.example.jdd.home.bean.ColunmBean;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.home.contract.RecommendContract;
import com.example.jdd.home.presenter.RecommendPresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * 推荐Fragment
 *
 */
public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.IRecommendView {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<NewsFragment> fragments = new ArrayList<>();

    private NewsFragmentAdapter newsFragmentAdapter;
    private List<ColunmBean.DataBean.ListBean> list;

    @Override
    protected RecommendPresenter initPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void initLinstener() {

    }

    @Override
    protected void initData() {

        mPresenter.getColumList();
    }
    @Override
    protected void initView(View view) {

        tabLayout = view.findViewById(R.id.mytablayout);

        viewPager = view.findViewById(R.id.myviewpage);
    }

   private void initTab(final ColunmBean columList){
       newsFragmentAdapter = new NewsFragmentAdapter(getChildFragmentManager(),fragments);
       viewPager.setAdapter(newsFragmentAdapter);
       tabLayout.setupWithViewPager(viewPager);

       viewPager.setOffscreenPageLimit(columList.getData().getList().size());

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
              for (int i = 0; i < columList.getData().getList().size(); i++) {
                   TextView tabAt = (TextView) tabLayout.getTabAt(i).getCustomView();
                   tabAt.setBackgroundResource(R.color.color_WHITE);
               }
               GradientDrawable drawable = new GradientDrawable();
               drawable.setCornerRadius(50);

               TextView customView = (TextView) tab.getCustomView();
               drawable.setStroke(1, Color.parseColor("#ff00ff"));
               drawable.setColor(Color.parseColor("#"+columList.getData().getList().get(tab.getPosition()).getBack_color()));
               customView.setBackground(drawable);
           }
           @Override
           public void onTabUnselected(TabLayout.Tab tab) {
           }
           @Override
           public void onTabReselected(TabLayout.Tab tab) {
           }
       });
    }
    @Override
    public int getLayoutID() {
        return R.layout.recommend_fragment;
    }
    @Override
    public void setRecommendList(NewsBean newsBean) {
    }
    @Override
    public void setColumList(ColunmBean columList) {

        if(columList.getCode() ==1){
            for (int i = 0; i < columList.getData().getList().size(); i++) {
                NewsFragment  newsFragment = new NewsFragment(columList.getData().getList().get(i).getId());
                fragments.add(newsFragment);
            }
            initTab(columList);

       /*     Rec_vpAdapter rec_vpAdapter = new Rec_vpAdapter(getActivity().getSupportFragmentManager(),fragments);
            viewPager.setAdapter(rec_vpAdapter);
            tabLayout.setupWithViewPager(viewPager);*/

            for (int i = 0; i < columList.getData().getList().size(); i++) {
                TextView textView =(TextView) LayoutInflater.from(getContext()).inflate(R.layout.recommend_tab_item,null);
                textView.setGravity(Gravity.CENTER);

               textView.setText(columList.getData().getList().get(i).getName());
               // tabLayout.addTab(tabLayout.newTab().setCustomView(textView),i);
                tabLayout.getTabAt(i).setCustomView(textView);
            }
           /* list = columList.getData().getList();
            for (int i = 0; i <list.size(); i++) {
                //NewsFragment newsFra = new NewsFragment(columList.getData().getList().get(i).getId());
                NewsFragment newsFragment = new NewsFragment(list.get(i).getId());
                fragments.add(newsFragment);
            }
            Rec_vpAdapter rec_vpAdapter = new Rec_vpAdapter(getActivity().getSupportFragmentManager(),fragments);
            viewPager.setAdapter(rec_vpAdapter);
            tabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < list.size(); i++) {
                TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.recommend_tab_item, null);
                textView.setGravity(Gravity.CENTER);
                textView.setText(list.get(i).getName());
                tabLayout.addTab(tabLayout.newTab().setCustomView(textView),i);
            }*/
        }
    }
}

