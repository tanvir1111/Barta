package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HeadlinesDataModel implements Serializable {
    @SerializedName("imageUrl")
    @Expose
    private String url;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("newspaperName")
    @Expose
    private String newspaperName;
    @SerializedName("newsCategory")
    @Expose
    private String newsCategory;



    @SerializedName("date_time")
    @Expose
    private String date_time;
    @SerializedName("description")
    @Expose
    private String description;


    public String getUrl() {
        return url;
    }

    public String getHeadline() {
        return headline;
    }
    public String getNewspaperName() {
        return newspaperName;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public String getDate_time() {
        return date_time;
    }



    public String getDescription() {
        return description;
    }
//    public HeadlinesDataModel(String url, String headline) {
//        this.url = url;
//        this.headline = headline;
//    }
    public HeadlinesDataModel(String newspaperName,String newsCategory){
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
    }
    public HeadlinesDataModel(String url, String headline, String newspaperName, String newsCategory, String date_time, String description) {
        this.url = url;
        this.headline = headline;
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
        this.date_time = date_time;
        this.description = description;
    }
}
