package com.qubitech.barta.API;

import com.qubitech.barta.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroInterface {
    /**
     * @param headlinesDataModel
     * @return {@link HeadlinesDataModel}
     */
    @POST("/news")
    Call<ArrayList<HeadlinesDataModel>> getNews(@Body HeadlinesDataModel headlinesDataModel);
}
