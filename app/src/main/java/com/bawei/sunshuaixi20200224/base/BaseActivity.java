package com.bawei.sunshuaixi20200224.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.sunshuaixi20200224.R;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(getlayoutID());
        //找控件
        initView();
        //获取数据
        getData();
    }
    //加载布局
    protected abstract int getlayoutID();
    //找控件
    protected abstract void initView();
    //获取数据
    protected abstract void getData();
}
