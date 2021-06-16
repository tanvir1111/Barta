package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.qubitech.barta_mobilenewsapp.Repository.UserRepository;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;

import java.util.List;

public class NewspaperViewModel extends AndroidViewModel {

    private LiveData<List<NewsPaperListDataModel>> favorites;
    private UserRepository userRepository;


    public NewspaperViewModel(@NonNull Application application) {
        super(application);
        favorites = new MutableLiveData<>();
        userRepository = new UserRepository(application);
    }

    /**
     * inserts to favorite newspaper in room through {@link UserRepository}
     *
     * @param favorites
     */
    public void insert(NewsPaperListDataModel favorites) {
        userRepository.insert(favorites);
    }

    /**
     * deletes from favorite newspaper in room through {@link UserRepository}
     *
     * @param favorites
     */
    public void delete(NewsPaperListDataModel favorites) {
        userRepository.delete(favorites);
    }


    /**
     * gets a specific newspaper based on ID from {@link UserRepository}
     *
     * @param newsId
     * @return
     */
    public NewsPaperListDataModel getNewspaper(int newsId) {
        return userRepository.getNewspaper(newsId);
    }

    /**
     * gets all newspaper  based on type from {@link UserRepository}
     *
     * @param newspaperType
     * @return
     */
    public LiveData<List<NewsPaperListDataModel>> getFavorites(int newspaperType) {

        favorites = userRepository.getFavorites(newspaperType);
        return favorites;
    }


}