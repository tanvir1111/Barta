package com.qubitech.barta.API;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.qubitech.barta.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;
import com.qubitech.barta.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    /**
     * @param headlinesData inserts a news{@link HeadlinesDataModel} to database
     */
    @Insert(onConflict = REPLACE)
    void insert(HeadlinesDataModel headlinesData);


    /**
     * @param headlinesData Deletes a news{@link HeadlinesDataModel}
     */
    @Delete
    void delete(HeadlinesDataModel headlinesData);


    /**
     * returns a specific news
     *
     * @param newsUrl
     * @return {@link HeadlinesDataModel}
     */
    @Query("SELECT * FROM collections where newsUrl = :newsUrl")
    HeadlinesDataModel getNews(String newsUrl);

    /**
     * returns users all saved news
     *
     * @return {@link LiveData<List<HeadlinesDataModel>> }
     */
    @Query("SELECT * FROM collections")
    LiveData<List<HeadlinesDataModel>> getAllLiveData();

    /**
     * inserts a news to room
     *
     * @param newsPaperListDataModel
     */
    @Insert(onConflict = REPLACE)
    void insert(NewsPaperListDataModel newsPaperListDataModel);

    /**
     * returns users favorite newspapers
     *
     * @param newspaperType
     * @return {@link LiveData<List<NewsPaperListDataModel>>}
     */
    @Query("SELECT * FROM favorites where newspaperType=:newspaperType")
    LiveData<List<NewsPaperListDataModel>> getFavorites(int newspaperType);

    /**
     * deletes a specific news
     *
     * @param newspaper
     */
    @Delete
    void delete(NewsPaperListDataModel newspaper);

    /**
     * returns a specific newspaper
     *
     * @param newspaper
     * @return {@link NewsPaperListDataModel}
     */
    @Query("SELECT * FROM favorites where nameID=:newspaper")
    NewsPaperListDataModel getNewspaper(int newspaper);
}
