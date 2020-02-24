package com.bawei.sunshuaixi20200224.centeron;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public interface IHomeCenteron {
    //创建V层需要实现的接口
    interface IView{
        void onXbannerSuessacc(String str);
        void onXbannerFailure(String str);

        void onListSuessacc(String str);
        void onListFailure(String str);
    }

    //创建M层需要实现的接口
    interface IModel{
        void onXbanner(String path,MyCallack myCallack);
        interface MyCallack{
            void onXbannerSuessacc(String str);
            void onXbannerFailure(String str);
        }

        void onlist(String path, Callack Callack);
        interface Callack{
            void onListSuessacc(String str);
            void onListFailure(String str);
        }
    }

    //创建P层需要实现的接口
    interface IPercneter{
        void onXbanner(String path);
        void onList(String path);
    }
}
