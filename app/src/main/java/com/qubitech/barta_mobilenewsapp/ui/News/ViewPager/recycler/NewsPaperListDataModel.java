package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler;

public class NewsPaperListDataModel {
    int name;
    int imageId;

    public int getNewspaperName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public NewsPaperListDataModel(int nameID, int imageId) {
        this.name = nameID;
        this.imageId = imageId;
    }
}
