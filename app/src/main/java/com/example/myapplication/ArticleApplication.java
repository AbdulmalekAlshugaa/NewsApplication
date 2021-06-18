package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;


public class ArticleApplication extends Application {
    private static ArticleApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        if(instance == null){
            instance = this;
        }
    }

    public static ArticleApplication getInstance(){

        return instance;
    }



}

