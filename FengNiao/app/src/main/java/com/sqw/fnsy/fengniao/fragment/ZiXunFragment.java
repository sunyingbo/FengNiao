package com.sqw.fnsy.fengniao.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sqw.fnsy.fengniao.R;
import com.sqw.fnsy.fengniao.adapter.MyFragmentPagerAdapter;
import com.sqw.fnsy.fengniao.fragment.zixun.ZxChildrenFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiXunFragment extends Fragment {

    public static final String TAG = ZiXunFragment.class.getName();

    private TabLayout tabLayout = null;
    private List<String> tabs = null;

    private ViewPager viewPager = null;
    private List<Fragment> fragments = null;
    private MyFragmentPagerAdapter myFragmentPagerAdapter = null;

    public ZiXunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zi_xun, container, false);
        initTab(view);
        return view;
    }

    private void initTab(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_fragment_zixun);
        tabs = new ArrayList<String>();
        tabs.add("精选");
        tabs.add("器材");
        tabs.add("影像");
        tabs.add("学院");
        tabs.add("课堂");
        tabs.add("旅游");
        tabs.add("汽车");
        tabs.add("手机");
        for (int i = 0; i < tabs.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
        }
        initView(view);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_fragment_zixun);
        fragments = new ArrayList<Fragment>();
        for (int i = 0; i < tabs.size(); i++) {
            ZxChildrenFragment fragment = new ZxChildrenFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments, tabs);
        viewPager.setAdapter(myFragmentPagerAdapter);
    }

}
