package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.myapplication.di.NetworkModuleService;
import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.mostView.MostView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AppRepository {


    private NetworkModuleService networkModuleService;
    private static final String TAG = "AppRepository";


    public AppRepository() {
        networkModuleService = new NetworkModuleService();
    }
    // get a list of movies
    public LiveData<Articles> getArticles(CompositeDisposable disposable, Integer pageNumber, HashMap<String, Object> searchParams) {
        MutableLiveData<Articles> data = new MutableLiveData<>();
        disposable.add(
                networkModuleService.movieApiRepositoryService().getAllArticles(pageNumber, searchParams)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(articlesResults -> {
                                    data.postValue(articlesResults);
                                },
                                throwable -> {
                                    Log.d(TAG, "error: "+throwable.getMessage().toString());


                                }));
        return data;
    }
    // get the most views movie
    public LiveData<MostView> getTheMostViews(CompositeDisposable disposable, Integer period) {
        MutableLiveData<MostView> data = new MutableLiveData<>();
        disposable.add(
                networkModuleService.movieApiRepositoryService().getMostViewed(period)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(data::postValue,
                                throwable -> {
                                    Log.d(TAG, "error: "+throwable.getMessage().toString());
                                }));
        return data;
    }

}