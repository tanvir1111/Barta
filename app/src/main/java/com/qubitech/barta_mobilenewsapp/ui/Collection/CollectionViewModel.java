package com.qubitech.barta_mobilenewsapp.ui.Collection;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.qubitech.barta_mobilenewsapp.API.RoomDB;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;
import java.util.List;

public class CollectionViewModel extends ViewModel {

    private MutableLiveData<ArrayList<HeadlinesDataModel>> collectionsLiveData = new MutableLiveData<>();
    private RoomDB db;
    public static CollectionViewModel collectionViewModel;

    public void setCollectionsLiveData(ArrayList<HeadlinesDataModel> headlinesData) {
        collectionsLiveData.setValue(headlinesData);
    }

    public LiveData<ArrayList<HeadlinesDataModel>> getCollectionsLiveData() {
        return collectionsLiveData;
    }

    public CollectionViewModel() {
        collectionsLiveData = new MutableLiveData<>();
    }
    public LiveData<List<HeadlinesDataModel>> getAllCollectionLiveData(){
        return db.collectionDao().getAllLiveData();
    }
    public static CollectionViewModel getInstance(ViewModelStoreOwner owner){
        if(collectionViewModel==null){
            collectionViewModel= new ViewModelProvider(owner).get(CollectionViewModel.class);
        }
        return collectionViewModel;
    }
}