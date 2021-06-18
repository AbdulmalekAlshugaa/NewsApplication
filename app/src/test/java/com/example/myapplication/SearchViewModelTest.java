package com.example.myapplication;

import com.example.myapplication.viewModel.PopularViewModel;
import com.example.myapplication.viewModel.SearchArticleViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;

public class SearchViewModelTest {
    private SearchArticleViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new SearchArticleViewModel();
    }
    @Test
    public void testPopularViewModelTest() throws Exception {
        try {
            RxAndroidPlugins.initMainThreadScheduler(null);
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("q","News");
            viewModel.getAllTheArticles(compositeDisposable,1,hashMap);

        }catch (NullPointerException e){

        }

    }




}
