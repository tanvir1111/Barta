package com.qubitech.barta_mobilenewsapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.qubitech.barta_mobilenewsapp.API.UserDao;
import com.qubitech.barta_mobilenewsapp.API.RoomDB;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<HeadlinesDataModel>> headlines;
    private LiveData<List<NewsPaperListDataModel>> favorites;

    /**
     * initializes {@link RoomDB } and {@link LiveData<List<HeadlinesDataModel>>}
     * @param application
     *
     */
    public UserRepository(Application application) {
         RoomDB database = RoomDB.getInstance(application);
         userDao = database.userDao();
         headlines= userDao.getAllLiveData();

    }

    /**
     * sends to dao to insert a news
     * @param headlinesData
     */
    public  void insert(HeadlinesDataModel headlinesData){
        userDao.insert(headlinesData);

    }

    /**
     * sends to dao to delete a news
     * @param headlinesData
     */
    public  void delete(HeadlinesDataModel headlinesData){
        userDao.delete(headlinesData);

    }

    /**
     * gets a specific news from room
     * @param newsUrl
     * @return {@link HeadlinesDataModel}
     */
    public  HeadlinesDataModel getNews(String newsUrl){
        return userDao.getNews(newsUrl);

    }

    /**
     * returns allNewsLiveData
     * @return {@link LiveData<List<HeadlinesDataModel>>}
     */
    public LiveData<List<HeadlinesDataModel>> getAllNews(){

        return headlines;
    }


    /**
     * @param favoriteNewspaper
     * sends a {@link NewsPaperListDataModel} to {@link UserDao} which inserts a news into room
     */
    public  void insert(NewsPaperListDataModel favoriteNewspaper){
        userDao.insert(favoriteNewspaper);

    }


    /**
     * gets favorite newspapers from {@link UserDao}
     * returns all favorite newspapers{@link LiveData<List<NewsPaperListDataModel>>}
     * @param newspaperType
     */
    public LiveData<List<NewsPaperListDataModel>> getFavorites(int newspaperType){
        favorites= userDao.getFavorites(newspaperType);
        return favorites;
    }

    /**
     * gets a specific newspaper from room
     * returns a newspaper {@link NewsPaperListDataModel}
     * @param newspaperID
     */
    public NewsPaperListDataModel getNewspaper(int newspaperID){
        return userDao.getNewspaper(newspaperID);
    }

    /**
     * deletes a specific favorite newspaper
     * @param favorite {@link NewsPaperListDataModel}
     */
    public  void delete(NewsPaperListDataModel favorite){
        userDao.delete(favorite);

    }
}
