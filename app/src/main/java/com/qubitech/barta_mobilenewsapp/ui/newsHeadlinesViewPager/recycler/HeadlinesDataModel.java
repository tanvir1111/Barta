package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler;

import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
@Entity(tableName = "collections")
public class HeadlinesDataModel implements Serializable {
    @SerializedName("imageUrl")
    @Expose
    @ColumnInfo(name = "imageUri")
    private String url;
    @SerializedName("headline")
    @Expose
    @PrimaryKey
    @NotNull
    private String  headline;
    @SerializedName("newspaperName")
    @Expose
    @ColumnInfo(name = "newspaperName")
    private String newspaperName;
    @SerializedName("newsCategory")
    @Expose
    @ColumnInfo(name = "newsCategory")
    private String newsCategory;

    @SerializedName("date_time")
    @Expose
    @ColumnInfo(name = "date_time")
    private String date_time;
    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
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
    public @Ignore HeadlinesDataModel(String newspaperName, String newsCategory){
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
    }
    public HeadlinesDataModel(String url, @NotNull String headline, String newspaperName, String newsCategory, String date_time, String description) {
        this.url = url;
        this.headline = headline;
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
        this.date_time = date_time;
        this.description = description;
    }
}
