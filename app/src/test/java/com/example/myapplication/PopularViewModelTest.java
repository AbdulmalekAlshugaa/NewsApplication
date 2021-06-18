package com.example.myapplication;

import com.example.myapplication.viewModel.PopularViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;

import static org.junit.Assert.assertEquals;

public class PopularViewModelTest {
    private PopularViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new PopularViewModel();
    }
    @Test
    public void testPopularViewModelTest() throws Exception {
        try {
            RxAndroidPlugins.initMainThreadScheduler(null);
            CompositeDisposable compositeDisposable = new CompositeDisposable();

            viewModel.getAllPopularArticles(compositeDisposable,1,"viewed");

        }catch (NullPointerException e){

        }

    }




}
