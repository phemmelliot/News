package com.example.phemmelliot.news.rest;

import com.example.phemmelliot.news.Model.NewsResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by phemmelliot on 9/27/17.
 */

public interface ApiInterface {

    @GET("articles")
    Call<NewsResponse> getLatestNews(@QueryMap Map<String, String> options);
}
