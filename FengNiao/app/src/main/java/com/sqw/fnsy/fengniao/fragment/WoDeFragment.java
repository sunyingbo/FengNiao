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
public class WoDeFragment extends Fragment {

    public static final String TAG = WoDeFragment.class.getName();

    public WoDeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wo_de, container, false);
    }

}
