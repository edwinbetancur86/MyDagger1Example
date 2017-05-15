package com.mobileappsandroid.training.mydagger1example.Dagger;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.solver.Cache;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 5/12/2017.
 */

@Module
public class NetModule
{
    private String baseURL;


    public NetModule(String baseURL)
    {
        this.baseURL = baseURL;
    }

    /*@Provides
    @Singleton
    public Cache provideOkHttpCache(Application application)
    {
        int cacheSize = 10 * 1024 * 1024; // 10MB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }*/

    /*@Provides
    @Singleton
    public Gson provideGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }*/

    /*@Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.cache();
        return client;
    }*

    /*@Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application)
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }*/

    @Provides
    @Singleton
    Retrofit provideRetrofit()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        OkHttpClient client = new OkHttpClient();
        client.cache();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(client)
                .baseUrl(baseURL)
                .build();

        return retrofit;
    }

}
