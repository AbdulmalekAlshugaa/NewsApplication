package com.example.myapplication.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.model.article.ArticleResponse;
import com.example.myapplication.repository.AppRepository;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;


public class ArticleListViewModel extends ViewModel {
    private AppRepository appRepository;
    private static final String TAG = "MovieByIdViewModel";


    public ArticleListViewModel() {
        this.appRepository = new AppRepository();
    }

    public LiveData<ArticleResponse> getAllTheArticles(CompositeDisposable disposable, Integer pageNumber, HashMap<String, Object> filteringParams){
      return appRepository.getArticles(disposable, pageNumber,filteringParams);

    }

}
