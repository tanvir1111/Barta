package com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


/**
 * A dataModel for a news
 * fields included for room database
 * made serializable to pass through intent
 *
 */
@Entity(tableName = "collections")
public class HeadlinesDataModel implements Serializable {
    @SerializedName("imageUrl")
    @Expose
    @ColumnInfo(name = "imageUri")
    private String imageUrl;
    @SerializedName("headline")
    @Expose
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



    @SerializedName("newsUrl")
    @Expose
    @ColumnInfo(name = "newsUrl")
    @PrimaryKey
    @NotNull
    private String newsUrl;


    public String getImageUrl() {
        return imageUrl;
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

    public String getNewsUrl() {
        return newsUrl;
    }

    public String getDescription() {
        return description;
    }

    /**
     * used to search for news in database based on newspaperName and newsCategory
     * @param newspaperName
     * @param newsCategory
     * ignored by roomDatabase
     */
    public @Ignore HeadlinesDataModel(String newspaperName, String newsCategory){
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
    }


    /**
     * mandatory empty constructor
     */
    public @Ignore HeadlinesDataModel(){

    }

    public HeadlinesDataModel(String imageUrl, @NotNull String newsUrl,String headline, String newspaperName, String newsCategory, String date_time, String description) {
        this.imageUrl = imageUrl;
        this.headline = headline;
        this.newsUrl = newsUrl;
        this.newspaperName = newspaperName;
        this.newsCategory = newsCategory;
        this.date_time = date_time;
        this.description = description;
    }
}
