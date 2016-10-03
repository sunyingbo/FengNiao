package com.sqw.fnsy.fengniao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sqw.fnsy.fengniao.activity.ZxChildrenActivity;
import com.sqw.fnsy.fengniao.bean.ZxHeaderBean;
import com.sqw.fnsy.fengniao.inter.MyOnClick;

import java.util.List;

/**
 * Created by SUN on 2016/10/1.
 */

public class MyViewPagerAdapter extends PagerAdapter {

    private List<ImageView> listImages = null;

    public MyViewPagerAdapter(List<ImageView> listImages) {
        this.listImages = listImages;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private MyOnClick myOnClick = null;

    public void setOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ViewGroup parent = (ViewGroup) listImages.get(position % listImages.size()).getParent();
        if (parent != null) {
            parent.removeAllViewsInLayout();
        }
        View view = listImages.get(position % listImages.size());
        view.setOnClickListener(new View.OnClickListener() {

            int pos = position;

            @Override
            public void onClick(View v) {
                myOnClick.onClick(pos);
            }
        });
        container.addView(listImages.get(position % listImages.size()));
        return listImages.get(position % listImages.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(listImages.get(position % listImages.size()));
    }
}
