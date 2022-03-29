package com.alivepython.jsonplaceholder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_client {
    public static Retrofit api;
    public static Retrofit_Instance services;

    public static Retrofit_Instance getServices(){
        if (services==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                OkHttpClient okHttpClient= new OkHttpClient.Builder()
                        .connectTimeout(7000, TimeUnit.SECONDS)
                        .readTimeout(7000, TimeUnit.SECONDS)
                        .build();

                api= new Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com/")
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            services= api.create(Retrofit_Instance.class);
            return services;
        }
        return services;
    }
}
