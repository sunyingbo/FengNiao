package com.sqw.fnsy.fengniao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sqw.fnsy.fengniao.fragment.LunTanFragment;
import com.sqw.fnsy.fengniao.fragment.TuShangFragment;
import com.sqw.fnsy.fengniao.fragment.WoDeFragment;
import com.sqw.fnsy.fengniao.fragment.ZiXunFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;

    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private Fragment showFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_mainactivity);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        showFragment = new Fragment();
        RadioButton rbZiXun = (RadioButton) findViewById(R.id.rb_mainactivity_zixun);
        rbZiXun.setChecked(true);
        showCurrentFragment(ZiXunFragment.TAG, ZiXunFragment.class);
    }

    private void showCurrentFragment(String tag, Class<? extends Fragment> className) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(showFragment);
        showFragment = fragmentManager.findFragmentByTag(tag);
        if (showFragment != null) {
            fragmentTransaction.show(showFragment);
        } else {
            try {
                showFragment = className.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            fragmentTransaction.add(R.id.frame_mainactivity, showFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_mainactivity_zixun:
                showCurrentFragment(ZiXunFragment.TAG, ZiXunFragment.class);
                break;
            case R.id.rb_mainactivity_tushang:
                showCurrentFragment(TuShangFragment.TAG, TuShangFragment.class);
                break;
            case R.id.rb_mainactivity_luntan:
                showCurrentFragment(LunTanFragment.TAG, LunTanFragment.class);
                break;
            case R.id.rb_mainactivity_wode:
                showCurrentFragment(WoDeFragment.TAG, WoDeFragment.class);
                break;
        }
    }
}
