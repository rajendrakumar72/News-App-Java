package com.example.newsappjava.network;

import com.example.newsappjava.model.MainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //GET https://newsapi.org/v2/top-headlines?country=us&apiKey=7874b2dc11f645df953fea9690a3dd1c
    String BASE_URL="https://newsapi.org/v2/";
    String API_KEY="7874b2dc11f645df953fea9690a3dd1c";
    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("country")String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<MainNews> getCategory(
            @Query("country") String country,
            @Query("category")String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );


}
