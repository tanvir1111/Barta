package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler;

public class HeadlinesDataModel {
    String url;
    String shortHeadline;

    public String getUrl() {
        return url;
    }

    public String getShortHeadline() {
        return shortHeadline;
    }

    public HeadlinesDataModel(String url, String shortHeadline) {
        this.url = url;
        this.shortHeadline = shortHeadline;
    }
}
