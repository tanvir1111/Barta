package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListDataModel;

import java.util.ArrayList;

public class NewsPaperListViewModel extends ViewModel {


    private MutableLiveData<ArrayList<NewsPaperListDataModel>> newspapers = new MutableLiveData<>();


    public void setData(ArrayList<NewsPaperListDataModel> newsPaperListDataModels) {
        newspapers.setValue(newsPaperListDataModels);
    }

    public LiveData<ArrayList<NewsPaperListDataModel>> getNewsPapers() {
        return newspapers;
    }
}
