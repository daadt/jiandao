package com.example.jdd.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.jdd.home.view.fragment.NewsFragment;

import java.util.List;

public class Rec_vpAdapter extends FragmentPagerAdapter {
    List<NewsFragment> fragments;

    public Rec_vpAdapter(@NonNull FragmentManager fm, List<NewsFragment> fragments) {
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
