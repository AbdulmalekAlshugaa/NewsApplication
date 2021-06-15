package com.example.myapplication.singleton;


public class SortBySingleton {
    // creating filtering type singleton in order to use in many purpose
    String filteringType;
    private static SortBySingleton sortBySingleton;
    private SortBySingleton(){
    }
    public static SortBySingleton getInstance(){
        if(sortBySingleton == null){
            sortBySingleton = new SortBySingleton();
        }
        return sortBySingleton;
    }
    public String getSortBy(){
        return filteringType;
    }
    public String setSortBy(String setFilteringType)
    {
        return  filteringType = setFilteringType;
    }





}
