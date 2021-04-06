package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler;

public class NewsPaperListDataModel {
    String name;
    int imageId;

    public String getNewspaperName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public NewsPaperListDataModel(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
}
