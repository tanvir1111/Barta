package com.qubitech.barta_mobilenewsapp.Repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.qubitech.barta_mobilenewsapp.API.RestClient;
import com.qubitech.barta_mobilenewsapp.API.RetroInterface;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private MutableLiveData<List<HeadlinesDataModel>> headlines;
    private final Application application;

    public NewsRepository(Application application) {
       this.application = application;
       headlines=new MutableLiveData<>();

    }


    public LiveData<List<HeadlinesDataModel>> getAllNews(String newspaperName,String newsCategory){
        fetchNews(newspaperName,newsCategory);
        return headlines;
    }



    private void fetchNews(String newspaperName,String newsCategory) {
        RetroInterface retroInterface = RestClient.getRestClient();
        Call<ArrayList<HeadlinesDataModel>> call = retroInterface.getNews(new HeadlinesDataModel(newspaperName,newsCategory));
        call.enqueue(new Callback<ArrayList<HeadlinesDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<HeadlinesDataModel>> call, Response<ArrayList<HeadlinesDataModel>> response) {
                if (response.isSuccessful()) {
                    headlines.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HeadlinesDataModel>> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
