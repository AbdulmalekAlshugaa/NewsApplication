package com.example.myapplication.di;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.myapplication.utilities.Constants.API_KEY;
import static com.example.myapplication.utilities.Constants.API_KEY_IDENTIFIER;
import static com.example.myapplication.utilities.Constants.BASE_URL;
import static com.example.myapplication.utilities.Constants.NETWORK_TIMEOUT;


public class NetworkModuleService {

    private static final String TAG = "RepositoryService";

    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient okHttpClient() {

        return new OkHttpClient.Builder()
                // .cache(cache())
                .followRedirects(true)
                .followSslRedirects(true)
                .connectTimeout(30, TimeUnit.SECONDS) // re-request if package is drop or TimeOut reach 60 seconds
                .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpsLoggingInterceptor()) // used if network off OR on
                .addInterceptor(appendApiKeyInterceptor())
                .addInterceptor(errorHandlingInterceptor())
                .addNetworkInterceptor(networkInterceptor())
                .build();
    }
    // this API key interceptor
    private static Interceptor appendApiKeyInterceptor() {
        return chain -> {
            Request original = chain.request();
            HttpUrl originalUrl = original.url();
            HttpUrl url = originalUrl.newBuilder()
                    .addQueryParameter(API_KEY_IDENTIFIER,  API_KEY)
                    .build();
            Request.Builder requestBuilder = original.newBuilder().url(url);
            Request request = requestBuilder.build();
            return chain.proceed(request);

        };
    }
    private static Interceptor errorHandlingInterceptor() {
        return chain -> {
            Request request  = chain.request();
            Response response = chain.proceed(request);
            if (response.code() == 404 || response.code() == 500){
                // Toast.makeText(BaseApplication, "Error",Toast.LENGTH_LONG).show();
            }
            return response;

        };
    }

    /**
     * This interceptor will be called ONLY if the network is available
     *
     * @return
     */

    private Interceptor networkInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());
            return response.newBuilder()
                    .build();
        };
    }

    private static HttpLoggingInterceptor httpsLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d(TAG, "http log: from logcat" + message);

                    }
                });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return httpLoggingInterceptor;
    }

    //
    public ApiClientService movieApiRepositoryService() {
        // create ApiInterface
        return retrofit().create(ApiClientService.class);
    }

      // used in case if the data requested by the interface is an empty
    static class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return (Converter<ResponseBody, Object>) body -> {
                if (body.contentLength() == 0) return null;
                return delegate.convert(body);};
        }
    }
}