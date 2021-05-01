package com.qubitech.barta_mobilenewsapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.qubitech.barta_mobilenewsapp.API.CollectionDao;
import com.qubitech.barta_mobilenewsapp.API.RoomDB;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

public class CollectionRepository {

    private CollectionDao collectionDao;
    private LiveData<List<HeadlinesDataModel>> headlines;

    public CollectionRepository(Application application) {
         RoomDB database = RoomDB.getInstance(application);
         collectionDao = database.collectionDao();
         headlines= collectionDao.getAllLiveData();
    }

    public  void insert(HeadlinesDataModel headlinesData){
        collectionDao.insert(headlinesData);

    }
    public  void delete(HeadlinesDataModel headlinesData){
        collectionDao.delete(headlinesData);

    }

    public  HeadlinesDataModel getNews(String newsUrl){
        return collectionDao.getNews(newsUrl);

    }

    public LiveData<List<HeadlinesDataModel>> getAllNews(){

        return headlines;
    }
}
