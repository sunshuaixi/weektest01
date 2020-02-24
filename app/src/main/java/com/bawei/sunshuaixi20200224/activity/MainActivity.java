package com.bawei.sunshuaixi20200224.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.sunshuaixi20200224.R;
import com.bawei.sunshuaixi20200224.adapter.ListAdapter;
import com.bawei.sunshuaixi20200224.base.BaseActivity;
import com.bawei.sunshuaixi20200224.bean.Bean;
import com.bawei.sunshuaixi20200224.bean.Xbanner;
import com.bawei.sunshuaixi20200224.centeron.IHomeCenteron;
import com.bawei.sunshuaixi20200224.percenter.HomePercenter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IHomeCenteron.IView {

    private ListView lv;
    private XBanner xb;
    String path="http://blog.zhaoliang5156.cn/api/news/news_data.json";
    private HomePercenter homePercenter;
    List<Xbanner> list=new ArrayList<>();
    //加载布局
    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }
    //找控件
    @Override
    protected void initView() {
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
    }
    //获取数据
    @Override
    protected void getData() {
        //实例化对象
        homePercenter = new HomePercenter(MainActivity.this);
        //调用方法
        homePercenter.onXbanner(path);

        homePercenter.onList(path);

    }

    //实现接口中的方法
    //成功
    @Override
    public void onXbannerSuessacc(String str) {
        Log.i("xxx",str);
        //创建gson解析
        Gson gson = new Gson();
        Bean bean = gson.fromJson(str, Bean.class);
        List<Bean.ResultsBean> results = bean.getResults();
        Bean.ResultsBean resultsBean = results.get(0);
        List<Bean.ResultsBean.BannerBean> banner = resultsBean.getBanner();
        Bean.ResultsBean.BannerBean bannerBean1 = banner.get(0);
        Bean.ResultsBean.BannerBean bannerBean2 = banner.get(1);
        Bean.ResultsBean.BannerBean bannerBean3 = banner.get(2);
        String imageurl = bannerBean1.getImageurl();
        String imageur2 = bannerBean2.getImageurl();
        String imageur3 = bannerBean3.getImageurl();
        Xbanner xbanner1 = new Xbanner(imageurl);
        Xbanner xbanner2 = new Xbanner(imageur2);
        Xbanner xbanner3 = new Xbanner(imageur3);
        list.add(xbanner1);
        list.add(xbanner2);
        list.add(xbanner3);
        //设置数据
       xb.setBannerData(list);
       //加载
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Xbanner xbannerr = list.get(position);
                String url = xbannerr.getUrl();
                Glide.with(MainActivity.this).load(url).into((ImageView) view);
            }
        });

    }
    //失败
    @Override
    public void onXbannerFailure(String str) {
        Log.i("xxx",str);
    }
    //成功
    @Override
    public void onListSuessacc(String str) {
        Log.i("xxx",str);
        //创建gson解析
        Gson gson = new Gson();
        Bean bean = gson.fromJson(str, Bean.class);
        List<Bean.ResultsBean> results = bean.getResults();
        Bean.ResultsBean resultsBean = results.get(0);
        List<Bean.ResultsBean.NewsistBean> newsist = resultsBean.getNewsist();
        //创建适配器
        ListAdapter listAdapter = new ListAdapter(MainActivity.this, newsist);
        //设置适配器
        lv.setAdapter(listAdapter);
    }

    @Override
    public void onListFailure(String str) {
        Log.i("xxx",str);
    }
}
