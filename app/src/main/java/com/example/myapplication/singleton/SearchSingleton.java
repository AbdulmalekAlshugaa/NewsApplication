package com.example.myapplication.singleton;


public class SearchSingleton {
    // creating filtering type singleton in order to use in many purpose
    String filteringType;
    private static SearchSingleton mUserJobPostChecker;
    private SearchSingleton(){
    }
    public static SearchSingleton getInstance(){
        if(mUserJobPostChecker == null){
            mUserJobPostChecker = new SearchSingleton();
        }
        return mUserJobPostChecker;
    }
    public String getFilteringType(){
        return filteringType;
    }
    public String setFilteringType(String setFilteringType)
    {
        return  filteringType = setFilteringType;
    }





}
