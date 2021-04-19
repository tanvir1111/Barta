package com.qubitech.barta_mobilenewsapp.API;

import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroInterface {
    @POST("/news")
    Call<ArrayList<HeadlinesDataModel>> getNews(@Body HeadlinesDataModel headlinesDataModel);
}
