package com.qubitech.barta.ui.Collection;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.qubitech.barta.Repository.UserRepository;
import com.qubitech.barta.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.util.List;

public class CollectionViewModel extends AndroidViewModel {

    private LiveData<List<HeadlinesDataModel>> headlinesLiveData;
    private UserRepository userRepository;


    public CollectionViewModel(@NonNull Application application) {
        super(application);
        headlinesLiveData = new MutableLiveData<>();
        userRepository = new UserRepository(application);
        headlinesLiveData = userRepository.getAllNews();

    }

    public void insert(HeadlinesDataModel headlinesData) {
        userRepository.insert(headlinesData);
    }

    public void delete(HeadlinesDataModel headlinesData) {
        userRepository.delete(headlinesData);
    }

    public LiveData<List<HeadlinesDataModel>> getHeadlines() {
        return headlinesLiveData;
    }


    /**
     * @param newsUrl
     */
    public HeadlinesDataModel getNews(String newsUrl) {
        return userRepository.getNews(newsUrl);

    }
}