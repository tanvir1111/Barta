package com.qubitech.barta_mobilenewsapp.ui.News;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.ViewModel;

import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<HeadlinesDataModel>> headlinesLiveData = new MutableLiveData<>();

    public void setHeadlinesLiveData(ArrayList<HeadlinesDataModel> headlinesData) {
        headlinesLiveData.setValue(headlinesData);
    }

    public LiveData<ArrayList<HeadlinesDataModel>> getHeadlinesLiveData() {
        return headlinesLiveData;
    }

    public NewsViewModel() {
        headlinesLiveData = new MutableLiveData<>();
    }
}