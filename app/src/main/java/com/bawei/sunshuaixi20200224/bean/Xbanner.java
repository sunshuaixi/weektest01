package com.bawei.sunshuaixi20200224.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * TIme:2020/2/24
 * Author:孙帅喜
 * Descriotion:
 */
public class Xbanner extends SimpleBannerInfo {
    private String url;

    public Xbanner(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
