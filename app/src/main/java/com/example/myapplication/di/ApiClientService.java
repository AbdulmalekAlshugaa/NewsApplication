package com.example.myapplication.di;


;

import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.mostView.MostView;
import com.example.myapplication.utilities.ApiConstants;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiClientService {
    // get the user personal
    @GET(ApiConstants.DISCOVER_ARTICLES)
    Flowable<Articles> getAllArticles(@Query("page") Integer pageNumber, @QueryMap Map<String, Object> params);

    // get most view
    @GET(ApiConstants.MOST_VIEWED)
    Flowable<MostView> getMostViewed(@Path("whichApi") String whichApi,  @Path("period") Integer period);

//    // get shared view
    @GET(ApiConstants.MOST_SHARED)
    Flowable<MostView> getMostShared(@Path("period") Integer pageNumber);

    // get shared view
    @GET(ApiConstants.MOST_EMAILED)
    Flowable<MostView> getEmailedView(@Path("period") Integer pageNumber);


}
