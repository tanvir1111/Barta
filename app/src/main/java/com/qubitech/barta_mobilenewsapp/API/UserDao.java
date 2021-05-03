package com.qubitech.barta_mobilenewsapp.API;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insert(HeadlinesDataModel headlinesData);

    @Delete
    void delete(HeadlinesDataModel headlinesData);


    @Query("SELECT * FROM collections where newsUrl = :newsUrl")
    HeadlinesDataModel getNews(String newsUrl);
    @Query("SELECT * FROM collections")
    LiveData<List<HeadlinesDataModel>> getAllLiveData();

    @Insert(onConflict = REPLACE)
    void insert(NewsPaperListDataModel newsPaperListDataModel);
    @Query("SELECT * FROM favorites where newspaperType=:newspaperType")
    LiveData<List<NewsPaperListDataModel>> getFavorites(int newspaperType);
    @Delete
    void delete(NewsPaperListDataModel headlinesData);
    @Query("SELECT * FROM favorites where nameID=:newspaper")
    NewsPaperListDataModel getNewspaper(int newspaper);
}
