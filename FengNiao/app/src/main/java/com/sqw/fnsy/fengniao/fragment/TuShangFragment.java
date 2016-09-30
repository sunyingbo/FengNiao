package com.sqw.fnsy.fengniao.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sqw.fnsy.fengniao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuShangFragment extends Fragment {

    public static final String TAG = TuShangFragment.class.getName();


    public TuShangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tu_shang, container, false);
    }

}
