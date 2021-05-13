package com.qubitech.barta_mobilenewsapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static Retrofit retrofit = null;

    private static String baseUrl="http://192.168.0.6:3000";


    /**
        *singleTon pattern for {@link RetroInterface}
     */
    public static RetroInterface getRestClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(RetroInterface.class);

    }
}