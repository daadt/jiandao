package com.example.jdd.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.jdd.home.view.fragment.NewsFragment;

import java.util.List;

public class NewsFragmentAdapter extends FragmentPagerAdapter {
    List<NewsFragment> fragments;

    public NewsFragmentAdapter(@NonNull FragmentManager fm, List<NewsFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
