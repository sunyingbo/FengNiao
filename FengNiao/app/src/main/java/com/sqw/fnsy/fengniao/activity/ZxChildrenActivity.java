package com.sqw.fnsy.fengniao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sqw.fnsy.fengniao.R;
import com.sqw.fnsy.fengniao.bean.ZiXunBean;

public class ZxChildrenActivity extends AppCompatActivity {

    private TextView textView = null;
    private WebView webView = null;

    private String title = null;
    private String webUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zx_children);
        getData();
        initTitlebar();
        initWebView();
    }

    private void initTitlebar() {
        textView = (TextView) findViewById(R.id.tv_titlebar);
        textView.setText(title);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("title");
        ZiXunBean ziXunBean = (ZiXunBean) bundle.getSerializable("key");
        webUrl = ziXunBean.getDoc_url();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.webview_activity_zxchildren);
        webView.setWebViewClient(new WebViewClient());
        webView.setInitialScale(25);
        WebSettings webSettings = webView.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webView.loadUrl(webUrl);
    }

    int times = 0;

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                this.finish();
                break;
            case R.id.rb_favorite:
                times++;
                RadioButton radioButton = (RadioButton) findViewById(R.id.rb_favorite);
                if (times % 2 == 1) {
                    radioButton.setChecked(true);
                    Toast.makeText(this, "收藏成功", Toast.LENGTH_LONG).show();
                } else {
                    radioButton.setChecked(false);
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.img_share:
                Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
