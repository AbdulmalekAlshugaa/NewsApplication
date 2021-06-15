package com.example.myapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.myapplication.di.NetworkModuleService;
import com.example.myapplication.model.article.articles.Articles;

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

    public LiveData<Articles> getArticles(CompositeDisposable disposable, Integer pageNumber, HashMap<String, Object> filteringParams) {

        MutableLiveData<Articles> data = new MutableLiveData<>();
        disposable.add(
                networkModuleService.movieApiRepositoryService().getAllArticles(pageNumber, filteringParams)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(articlesResults -> {
                                    Log.d(TAG, "accept: I am here "+articlesResults.getCopyright());
                                    data.postValue(articlesResults);
                                },
                                throwable -> {

                                }));
        return data;
    }

}