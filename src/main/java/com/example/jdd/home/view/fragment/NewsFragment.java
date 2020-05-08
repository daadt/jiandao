package com.example.jdd.home.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jdd.R;
import com.example.jdd.base.BaseFragment;
import com.example.jdd.home.adapter.NewsBannerAdapter;
import com.example.jdd.home.bean.NewsBean;
import com.example.jdd.home.contract.NewsFragmentContract;
import com.example.jdd.home.presenter.NewsPresenter;
import com.example.jdd.home.view.Banner_Indicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsFragmentContract.INewsView {

    private  String tabID;
    private ViewPager banner_viewPager;
    private List<View> banner_views = new ArrayList<>();
    private Banner_Indicator banner_indicator;

    private int viewpage_Current_Pos = 0;



    public NewsFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected void initLinstener() {

    }

    @Override
    protected void initData() {

        mPresenter.getRecommendList(tabID);

    }

    @Override
    protected void initView(View view) {
        banner_viewPager = view.findViewById(R.id.banner_viewpage);
        banner_indicator =view.findViewById(R.id.banner_indicator);

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {

        initBanner(newsBean);
    }
    int current_banner_item;
    private void initBanner(final NewsBean newsBean){

        for (int i = 0; i <newsBean.getData().getBanner_list().size(); i++) {
            current_banner_item = i;
            View ban_view = LayoutInflater.from(getContext()).inflate(R.layout.news_banner_item,null,false);
            TextView bannerContent = ban_view.findViewById(R.id.banner_content);
            ImageView bannerImage =  ban_view.findViewById(R.id.benner_image);
            bannerContent.setText(newsBean.getData().getBanner_list().get(i).getDescription());
            Glide.with(getContext()).load(newsBean.getData().getBanner_list().get(i).getImage_url()).into(bannerImage);
            banner_views.add(ban_view);
            ban_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        };

        NewsBannerAdapter bannerAdapter = new NewsBannerAdapter(banner_views);
        banner_viewPager.setAdapter(bannerAdapter);


        banner_indicator.setBannerImageSize(newsBean.getData().getBanner_list().size());
        banner_indicator.setCurrentBannerItem(0);
        banner_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                current_banner_item = position;
                banner_indicator.setCurrentBannerItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        倒计时
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewpage_Current_Pos+=1;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        banner_viewPager.setCurrentItem(viewpage_Current_Pos%(newsBean.getData().getBanner_list().size()));
                    }
                });
            }
        };
        timer.schedule(timerTask,2000,2000);
    }
}
