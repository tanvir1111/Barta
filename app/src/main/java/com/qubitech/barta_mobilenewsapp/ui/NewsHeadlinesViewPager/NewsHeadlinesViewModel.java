package com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.qubitech.barta_mobilenewsapp.Repository.NewsRepository;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

public class NewsHeadlinesViewModel extends AndroidViewModel {

    private LiveData<List<HeadlinesDataModel>> headlinesLiveData ;
    private NewsRepository newsRepository;


    public NewsHeadlinesViewModel(@NonNull Application application) {
        super(application);
        headlinesLiveData = new MutableLiveData<>();
        newsRepository=new NewsRepository(application);


    }
    public LiveData<List<HeadlinesDataModel>> getNews(String newspaperName,String newsCategory){
            headlinesLiveData=newsRepository.getAllNews(newspaperName,newsCategory);
            return headlinesLiveData;
    }




}