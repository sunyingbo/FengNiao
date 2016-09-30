package com.sqw.fnsy.fengniao.fragment.zixun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sqw.fnsy.fengniao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZXChildrenFragment extends Fragment {


    public ZXChildrenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int index = getArguments().getInt("index");
        View view = inflater.inflate(R.layout.fragment_zxchildren, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        switch (index) {
            case 0:
                textView.setText("头条");
                break;
            case 1:
                textView.setText("器材");
                break;
            case 2:
                textView.setText("影像");
                break;
            case 3:
                textView.setText("学院");
                break;
            case 4:
                textView.setText("课堂");
                break;
            case 5:
                textView.setText("旅游");
                break;
            case 6:
                textView.setText("汽车");
                break;
            case 7:
                textView.setText("手机");
                break;
        }
        return view;
    }

}
