package com.sqw.fnsy.fengniao.fragment.zixun;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.squareup.picasso.Picasso;
import com.sqw.fnsy.fengniao.R;
import com.sqw.fnsy.fengniao.adapter.MyListViewAdapter;
import com.sqw.fnsy.fengniao.adapter.MyViewPagerAdapter;
import com.sqw.fnsy.fengniao.bean.Choiceness;
import com.sqw.fnsy.fengniao.bean.ZiXunBean;
import com.sqw.fnsy.fengniao.bean.ZxHeaderBean;
import com.sqw.fnsy.fengniao.config.PathAPI;
import com.sqw.fnsy.fengniao.listener.MyPageChangeListener;
import com.sqw.fnsy.fengniao.utils.AddDotsUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZxChildrenFragment extends Fragment implements Handler.Callback {

    private String url = PathAPI.getChoiceness();
    private String urlHeader = PathAPI.getChoicenessHeader();

    private RelativeLayout relativeLayout = null;
    private ListView listView = null;
    private List<ZiXunBean> totalList = null;
    private MyListViewAdapter myListViewAdapter = null;

    private ViewPager vpHeader = null;
    private LinearLayout linearLayout = null;
    private List<ZxHeaderBean> headerList = null;
    private List<String> picUrls = null;
    private List<ImageView> imgHeaderList = null;
    private MyViewPagerAdapter myViewPagerAdapter = null;

    private Handler myHandler = null;
    private int pageNoHeader = 0;

    public ZxChildrenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int index = getArguments().getInt("index");
        View view = inflater.inflate(R.layout.fragment_zxchildren, container, false);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.data_empty);
        listView = (ListView) view.findViewById(R.id.listview_fragmentzxchildren);
        totalList = new ArrayList<ZiXunBean>();
        headerList = new ArrayList<ZxHeaderBean>();
        picUrls = new ArrayList<String>();
        imgHeaderList = new ArrayList<ImageView>();
        myHandler = new Handler(this);
        int type = -1;
        switch (index) {
            case 0:
                urlHeader = PathAPI.getChoicenessHeader();
                url = PathAPI.getChoiceness();
                type = 0;
                break;
            case 1:
                urlHeader = PathAPI.getEquipmentHeader();
                url = PathAPI.getEquipment();
                break;
            case 2:
                urlHeader = PathAPI.getBlipHeader();
                url = PathAPI.getBlip();
                break;
            case 3:
                urlHeader = PathAPI.getCollegeHeader();
                url = PathAPI.getCollege();
                break;
            case 4:
                urlHeader = PathAPI.getTravelHeader();
                url = PathAPI.getTravel();
                break;
            case 5:
                urlHeader = PathAPI.getCarHeader();
                url = PathAPI.getCar();
                break;
            case 6:
                urlHeader = PathAPI.getCellphoneHeader();
                url = PathAPI.getCellphone();
                break;
        }
        if (index == 0) {
            getChoicenessData(1);
        } else {
            getData(1);
        }
        getImageUrls();
        myListViewAdapter = new MyListViewAdapter(getActivity(), totalList, type);
        addFooterView();
        listView.setAdapter(myListViewAdapter);
        listView.setOnScrollListener(new MyOnScrollListener(type));
        return view;
    }

    private final class MyOnScrollListener implements AbsListView.OnScrollListener {

        private boolean isBottom = false;
        private int pageNo = 1;
        private int type;

        public MyOnScrollListener(int type) {
            this.type = type;
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == SCROLL_STATE_IDLE) {
                if (isBottom) {
                    pageNo++;
                    if (type == 0) {
                        getChoicenessData(pageNo);
                    } else {
                        getData(pageNo);
                    }
                }
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            isBottom = (firstVisibleItem + visibleItemCount == totalItemCount);
        }
    }

    private void addFooterView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.footer_loadmore, null);
        listView.addFooterView(view);
    }

    private void addHeaderView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.header_viewpager_zx, null);
        vpHeader = (ViewPager) view.findViewById(R.id.header_listview_zx);
        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout_header_zx);
        for (int i = 0; i < headerList.size(); i++) {
            String pic_src = headerList.get(i).getPic_src();
            picUrls.add(pic_src);
        }
        for (int i = 0; i < picUrls.size() * 2; i++) {
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(headerList.get(i % headerList.size()).getPic_src())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgHeaderList.add(imageView);
        }
        AddDotsUtil.addDot(getActivity(), linearLayout, picUrls.size());
        myViewPagerAdapter = new MyViewPagerAdapter(imgHeaderList);
        vpHeader.setAdapter(myViewPagerAdapter);
        vpHeader.setCurrentItem(0);
        vpHeader.setOnPageChangeListener(new MyPageChangeListener(linearLayout, linearLayout.getChildCount()));
        listView.addHeaderView(view);
        autoScroll();
    }

    private void autoScroll() {
        myHandler.sendEmptyMessageDelayed(0, 3000);
    }

    private void getImageUrls() {
        OkHttpUtils.get().url(urlHeader).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                if (!TextUtils.isEmpty(response)) {
                    JSONArray jsonArray = JSON.parseArray(response);
                    List<ZxHeaderBean> zxHeaderBeanList = JSON.parseArray(jsonArray.toJSONString(), ZxHeaderBean.class);
                    headerList.addAll(zxHeaderBeanList);
                    addHeaderView();
                    myViewPagerAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getChoicenessData(int page) {
        OkHttpUtils.get().url(url + page).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                relativeLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response) {
                if (!TextUtils.isEmpty(response)) {
                    relativeLayout.setVisibility(View.GONE);
                    JSONObject jsonObject = JSON.parseObject(response);
                    JSONArray list1 = jsonObject.getJSONArray("160120");
                    List<Choiceness> choicenesses = JSON.parseArray(list1.toJSONString(), Choiceness.class);
                    totalList.addAll(choicenesses);
                    JSONArray list2 = jsonObject.getJSONArray("280280");
                    choicenesses = JSON.parseArray(list2.toJSONString(), Choiceness.class);
                    JSONObject obj = jsonObject.getJSONObject("580280");
                    Choiceness choiceness = JSON.parseObject(obj.toJSONString(), Choiceness.class);
                    choicenesses.add(choiceness);
                    totalList.addAll(choicenesses);
                    myListViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getData(int page) {
        OkHttpUtils.get().url(url + page).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                if (!TextUtils.isEmpty(response)) {
                    JSONObject jsonObject = JSON.parseObject(response);
                    JSONArray list = jsonObject.getJSONArray("list");
                    List<ZiXunBean> ziXunBeanList = JSON.parseArray(list.toJSONString(), ZiXunBean.class);
                    totalList.addAll(ziXunBeanList);
                    myListViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public boolean handleMessage(Message msg) {
        vpHeader.setCurrentItem(pageNoHeader++);
        myHandler.sendEmptyMessageDelayed(0, 3000);
        return false;
    }
}
