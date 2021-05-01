package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler;

public class NewsPaperListDataModel {
    int nameID;
    int imageId;

    public int getNewspaperNameID() {
        return nameID;
    }

    public int getImageId() {
        return imageId;
    }

    public NewsPaperListDataModel(int nameID, int imageId) {
        this.nameID = nameID;
        this.imageId = imageId;
    }
}
