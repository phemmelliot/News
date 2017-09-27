package com.example.phemmelliot.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.phemmelliot.news.Model.News;
import com.example.phemmelliot.news.Model.NewsResponse;
import com.example.phemmelliot.news.rest.ApiInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String apiKey = "62cd412f94cb41be804345d9ae0e1a86";
    private String BASE_URL = "https://newsapi.org/v1/";
    private String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] newsSources = {"the-next-web", "abc-news-au", "techcrunch", "bbc-news"};
        // Create your recyclerview here
        Map<String, String> data = new HashMap<>();
        data.put("sortBy", "latest");
        data.put("apiKey", apiKey);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiService = retrofit.create(ApiInterface.class);
        final List<List<News>> news = null;
        //create an adapter class that takes in the List of List of news
        final String todayNews = null;

        for(String source : newsSources)
        {
            data.put("source", source);
            Call<NewsResponse> call = apiService.getLatestNews(data);
            call.enqueue(new Callback<NewsResponse>() {
                @Override
                public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                    List<News> news1 = response.body().getArticles();
                    news.add(news1);
                }

                @Override
                public void onFailure(Call<NewsResponse> call, Throwable t) {
                    Log.v(TAG, "There was an error loading it from the internet");
                }
            });

        }

        //set the adapter for the recyclerview to the adapter we created and search for Using retrofit with recyclerview on google, click on the one by androidhive, go through the tutorials to understand what other things you should do



    }
}
