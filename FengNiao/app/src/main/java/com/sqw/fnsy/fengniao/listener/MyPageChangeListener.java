package com.sqw.fnsy.fengniao.listener;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sqw.fnsy.fengniao.R;

/**
 * Created by SUN on 2016/9/23.
 */
public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
    private LinearLayout linearLayout;
    private int size;

    public MyPageChangeListener(LinearLayout linearLayout, int size) {
        this.linearLayout = linearLayout;
        this.size = size;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < size; i++) {
            linearLayout.getChildAt(i).setSelected(false);
            ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.mipmap.point_default);
        }
        linearLayout.getChildAt(position % size).setSelected(true);
        ((ImageView)linearLayout.getChildAt(position % size)).setImageResource(R.mipmap.point_focus);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
