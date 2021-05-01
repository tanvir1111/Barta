package com.qubitech.barta_mobilenewsapp.ui.Collection;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.qubitech.barta_mobilenewsapp.Repository.CollectionRepository;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

public class CollectionViewModel extends AndroidViewModel {

    private LiveData<List<HeadlinesDataModel>> headlinesLiveData;
    private CollectionRepository collectionRepository;


    public CollectionViewModel(@NonNull Application application) {
        super(application);
        headlinesLiveData = new MutableLiveData<>();
        collectionRepository=new CollectionRepository(application);
        headlinesLiveData = collectionRepository.getAllNews();

    }

    public void insert(HeadlinesDataModel headlinesData){
        collectionRepository.insert(headlinesData);
    }
    public void delete(HeadlinesDataModel headlinesData)
    {
        collectionRepository.delete(headlinesData);
    }

    public LiveData<List<HeadlinesDataModel>> getHeadlines(){
        return headlinesLiveData;
    }


    public HeadlinesDataModel getNews(String newsUrl) {
        return collectionRepository.getNews(newsUrl);

    }
}