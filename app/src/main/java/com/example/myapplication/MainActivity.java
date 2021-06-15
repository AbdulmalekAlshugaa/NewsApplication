package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.model.article.ArticleResponse;
import com.example.myapplication.view.LoadDataFragment;
import com.example.myapplication.view.MainFragment;
import com.example.myapplication.view.SearchArticle;
import com.example.myapplication.viewModel.ArticleListViewModel;

import java.util.HashMap;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private ArticleListViewModel articleListViewModel;
    private CompositeDisposable mCompositeDisposable;
    private static final String TAG = "MainActivity";

    final Fragment mainFragment = new MainFragment();
    final Fragment searchFragment = new SearchArticle();
    final Fragment loadFragment = new LoadDataFragment();
    final FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        redirectAmongFragment();
        articleListViewModel = new ViewModelProvider(this).get(ArticleListViewModel.class);
        mCompositeDisposable = new CompositeDisposable();


    }

    void redirectAmongFragment(){
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity,mainFragment , "mainFragment").commit();
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity, searchFragment, "searchFragment").hide(searchFragment).addToBackStack("search").commit();
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity, loadFragment, "loadFragment").hide(loadFragment).addToBackStack("load").commit();
    }

    private void ObserveMovieData(String filteringType) {

        HashMap<String, Object> searchingParams = new HashMap<>();


        articleListViewModel.getAllTheArticles(mCompositeDisposable,1,searchingParams)
                .observe(this, new Observer<ArticleResponse>() {
                    @Override
                    public void onChanged(ArticleResponse articleResponse) {
                        Log.d(TAG, "copyRight: "+articleResponse);
                    }
                });

    }
}