package com.example.androidfluxarchitecture.app;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joanna on 22.06.16.
 */
public class RetrofitFactory {

    public static final String REST_ENDPOINT_URL = "https://api.github.com";
    public static Retrofit adapter;
    private static OkHttpClient client;

    public static Retrofit getAdapter() {
        if (adapter != null) {
            return adapter;
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        adapter = new Retrofit.Builder()
                .baseUrl(REST_ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return adapter;
    }
}
