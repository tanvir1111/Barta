package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "favorites")
public class NewsPaperListDataModel {

    @ColumnInfo
    @PrimaryKey
    private int nameID;
    @ColumnInfo
    private int imageID;


    @ColumnInfo
    private int newspaperType;

    /**
     * @param nameID        String Resource id
     * @param imageID       Drawable Resource id
     * @param newspaperType bengali/english/online
     */
    public NewsPaperListDataModel(int nameID, int imageID, int newspaperType) {
        this.nameID = nameID;
        this.imageID = imageID;
        this.newspaperType = newspaperType;
    }

    public int getNameID() {
        return nameID;
    }

    public int getNewspaperType() {
        return newspaperType;
    }

//    public NewsPaperListDataModel( int nameID, int imageID) {
//        this.nameID = nameID;
//        this.imageID = imageID;
//    }

    public int getImageID() {
        return imageID;
    }
}
