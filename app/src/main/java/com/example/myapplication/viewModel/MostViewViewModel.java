package com.example.myapplication.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.article.articles.Articles;
import com.example.myapplication.model.article.mostView.MostView;
import com.example.myapplication.repository.AppRepository;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;


public class MostViewViewModel extends ViewModel {
    private AppRepository appRepository;
    private static final String TAG = "most view";

    public MostViewViewModel() {
        this.appRepository = new AppRepository();
    }

    public LiveData<MostView> getAllMostViewArticles(CompositeDisposable disposable, Integer period){
      return appRepository.getTheMostViews(disposable, period);

    }

}
