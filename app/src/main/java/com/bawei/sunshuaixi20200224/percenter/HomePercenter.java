package com.bawei.sunshuaixi20200224.percenter;

import com.bawei.sunshuaixi20200224.centeron.IHomeCenteron;
import com.bawei.sunshuaixi20200224.model.HomeModel;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public class HomePercenter implements IHomeCenteron.IPercneter {
    //创建构造方法
    IHomeCenteron.IView mView;
    private final HomeModel homeModel;

    public HomePercenter(IHomeCenteron.IView view) {
        mView=view;
        homeModel = new HomeModel();
    }

    //实现接口中的方法
    @Override
    public void onXbanner(String path) {
        homeModel.onXbanner(path, new IHomeCenteron.IModel.MyCallack() {
            @Override
            public void onXbannerSuessacc(String str) {
                mView.onXbannerSuessacc(str);
            }

            @Override
            public void onXbannerFailure(String str) {
                mView.onXbannerFailure(str);
            }
        });
    }

    @Override
    public void onList(String path) {
        homeModel.onlist(path, new IHomeCenteron.IModel.Callack() {
            @Override
            public void onListSuessacc(String str) {
                mView.onListSuessacc(str);
            }

            @Override
            public void onListFailure(String str) {
                mView.onListFailure(str);
            }
        });
    }
}
