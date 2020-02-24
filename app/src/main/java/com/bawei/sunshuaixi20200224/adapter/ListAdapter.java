package com.bawei.sunshuaixi20200224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.sunshuaixi20200224.R;
import com.bawei.sunshuaixi20200224.activity.MainActivity;
import com.bawei.sunshuaixi20200224.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public class ListAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultsBean.NewsistBean> newsist;

    public ListAdapter(Context context, List<Bean.ResultsBean.NewsistBean> newsist) {
        this.context = context;
        this.newsist = newsist;
    }

    @Override
    public int getCount() {
        return newsist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView==null){
          convertView=  View.inflate(context, R.layout.item,null);
          holder.iv=convertView.findViewById(R.id.iv);
          holder.tv1=convertView.findViewById(R.id.tv1);
          holder.tv2=convertView.findViewById(R.id.tv2);
          convertView.setTag(holder);
        }else{
           holder=(ViewHolder) convertView.getTag();
        }
        Bean.ResultsBean.NewsistBean newsistBean = newsist.get(position);
        String title = newsistBean.getTitle();
        String content = newsistBean.getContent();
        String image = newsistBean.getImage();

        holder.tv1.setText(title);
        holder.tv2.setText(content);
        Glide.with(context).load(image).into(holder.iv);
        return convertView;
    }

    private class ViewHolder{
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
    }
}
