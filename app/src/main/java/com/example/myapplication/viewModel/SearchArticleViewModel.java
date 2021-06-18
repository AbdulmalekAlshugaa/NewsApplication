package com.example.myapplication.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.repository.AppRepository;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;


public class SearchArticleViewModel extends ViewModel {
    private AppRepository appRepository;
    private static final String TAG = "MovieByIdViewModel";


    public SearchArticleViewModel() {
        this.appRepository = new AppRepository();
    }

    public LiveData<Articles> getAllTheArticles(CompositeDisposable disposable, Integer pageNumber, HashMap<String, Object> filteringParams){
      return appRepository.getArticles(disposable, pageNumber,filteringParams);

    }

}
