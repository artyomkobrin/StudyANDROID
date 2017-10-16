package com.example.lyavon.tourism;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 12.09.2017.
 */

public class Retrofit2App extends Application{

    private static   Face face;
    private Retrofit retrofit;
    private Gson gson = new GsonBuilder().create();

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        face = retrofit.create(Face.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static Face getApi() {
        return face;
    }
}
