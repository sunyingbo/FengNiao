package com.sqw.fnsy.fengniao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sqw.fnsy.fengniao.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            this.finish();
        }
    }
}
