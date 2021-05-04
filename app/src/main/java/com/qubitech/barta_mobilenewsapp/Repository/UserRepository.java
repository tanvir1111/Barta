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

    public UserRepository(Application application) {
         RoomDB database = RoomDB.getInstance(application);
         userDao = database.userDao();
         headlines= userDao.getAllLiveData();

    }

    public  void insert(HeadlinesDataModel headlinesData){
        userDao.insert(headlinesData);

    }
    public  void delete(HeadlinesDataModel headlinesData){
        userDao.delete(headlinesData);

    }

    public  HeadlinesDataModel getNews(String newsUrl){
        return userDao.getNews(newsUrl);

    }

    public LiveData<List<HeadlinesDataModel>> getAllNews(){

        return headlines;
    }
    public  void insert(NewsPaperListDataModel favoriteNewspaper){
        userDao.insert(favoriteNewspaper);

    }

    public LiveData<List<NewsPaperListDataModel>> getFavorites(int newspaperType){
        favorites= userDao.getFavorites(newspaperType);
        return favorites;
    }
    public NewsPaperListDataModel getNewspaper(int newspaperID){
        return userDao.getNewspaper(newspaperID);
    }
    public  void delete(NewsPaperListDataModel favorite){
        userDao.delete(favorite);

    }
}
