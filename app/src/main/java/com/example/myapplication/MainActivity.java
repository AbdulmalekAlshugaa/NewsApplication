package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myapplication.view.fragments.PopularFragment;
import com.example.myapplication.view.MainFragment;
import com.example.myapplication.view.fragments.SearchArticle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    final Fragment mainFragment = new MainFragment();
    final Fragment searchFragment = new SearchArticle();
    final Fragment loadFragment = new PopularFragment();
    final FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        redirectAmongFragment();

    }

    void redirectAmongFragment(){
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity,mainFragment , "mainFragment").commit();
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity, searchFragment, "searchFragment").hide(searchFragment).addToBackStack("search").commit();
        fm.beginTransaction().add(R.id.main_FrameLayout_Activity, loadFragment, "loadFragment").hide(loadFragment).addToBackStack("load").commit();
    }


}