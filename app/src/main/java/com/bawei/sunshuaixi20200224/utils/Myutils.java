package com.bawei.sunshuaixi20200224.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public class Myutils {
    //单例模式
    //创建静态的私有的变量
    private static Myutils myutils=new Myutils();
    //创建无参的构造方法
    private Myutils(){

    }
    //创建静态的 返回实例的方法
    public static Myutils getInstance(){
        return myutils;
    }

    //判断网络
    public boolean isWock(Context context){
      ConnectivityManager co= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = co.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
            return true;
        }
        return false;

    }

    //创建handler
    Handler handler=new Handler();

    //获取网络json文件
    public void getJson(final String path, final Ijk ijk){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建url
                    URL url = new URL(path);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    //设置读取时间
                    conn.setReadTimeout(5000);
                    //设置连接时长
                    conn.setConnectTimeout(5000);
                    //获取结果码
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        //获取流
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] by=new byte[1024];
                        StringBuilder builder = new StringBuilder();
                        while((len=inputStream.read(by))!=-1){
                            builder.append(new String(by,0,len));
                        }
                        //关闭流
                        inputStream.close();
                        final String s = builder.toString();

                        //切换线程
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(ijk!=null){
                                    ijk.Suassecc(s);
                                }
                            }
                        });
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("xxx",e.toString());
                        }
                    });
                }
            }
        }).start();
    }

    //创建接口
    public interface Ijk{
        void Suassecc(String json);
        void Failure(String str);
    }

}
