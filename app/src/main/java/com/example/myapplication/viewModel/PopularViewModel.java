package com.example.myapplication.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.mostView.MostView;
import com.example.myapplication.repository.AppRepository;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;


public class PopularViewModel extends ViewModel {
    private AppRepository appRepository;
    private static final String TAG = "most view";

    public PopularViewModel() {
        this.appRepository = new AppRepository();
    }

    public LiveData<MostView> getAllPopularArticles(CompositeDisposable disposable, Integer period, String whichEndPoint){
      return appRepository.getTheMostViews(disposable, period,whichEndPoint);

    }

}
