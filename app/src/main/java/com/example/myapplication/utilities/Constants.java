package com.example.myapplication.utilities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Constants {
    private static final String TAG = "Constants";
    // article api Params
    public static final String BASE_URL = "https://api.nytimes.com/svc/";
    public static final String API_KEY = "lpXE3nOHJPHkvaZgVoOuuaLGGzUBFoYk";

    public static final String API_KEY_IDENTIFIER = "api-key"; // api key path use in appendAPIkey
    public static final String IMAGE_PATH = "";
    public static final int NETWORK_TIMEOUT = 30;

    // convert date
    public static String convertTimeStampDate(String inputDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(inputDate);
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
    }

}


