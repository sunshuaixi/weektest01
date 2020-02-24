package com.bawei.sunshuaixi20200224.model;

import com.bawei.sunshuaixi20200224.centeron.IHomeCenteron;
import com.bawei.sunshuaixi20200224.utils.Myutils;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public class HomeModel implements IHomeCenteron.IModel {
    //实现接口中的方法
    @Override
    public void onXbanner(String path, final MyCallack myCallack) {
        //调用工具类
        Myutils.getInstance().getJson(path, new Myutils.Ijk() {
            @Override
            public void Suassecc(String json) {
                myCallack.onXbannerSuessacc(json);
            }

            @Override
            public void Failure(String str) {
                myCallack.onXbannerFailure(str);
            }
        });
    }

    @Override
    public void onlist(String path, final Callack Callack) {
        //调用工具类
        Myutils.getInstance().getJson(path, new Myutils.Ijk() {
            @Override
            public void Suassecc(String json) {
                Callack.onListSuessacc(json);
            }

            @Override
            public void Failure(String str) {
                Callack.onListFailure(str);
            }
        });
    }
}
