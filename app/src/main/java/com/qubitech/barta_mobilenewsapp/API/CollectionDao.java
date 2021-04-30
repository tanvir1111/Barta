package com.qubitech.barta_mobilenewsapp.API;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CollectionDao {
    @Insert(onConflict = REPLACE)
    void insert(HeadlinesDataModel headlinesData);

    @Delete
    void delete(HeadlinesDataModel headlinesData);

    @Query("SELECT * FROM collections")
    List<HeadlinesDataModel> getAll();
    @Query("SELECT * FROM collections where headline = :headline")
    HeadlinesDataModel getNews(String headline);
    @Query("SELECT * FROM collections")
    LiveData<List<HeadlinesDataModel>> getAllLiveData();
}