package com.sqw.fnsy.fengniao.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SUN on 2016/9/30.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = null;
    private List<String> tabs = null;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
