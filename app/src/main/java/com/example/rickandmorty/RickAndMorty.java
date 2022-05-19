package com.example.rickandmorty;

import android.app.Application;
import android.content.Context;

public class RickAndMorty extends Application {
    private static Context context;

    public static Context getAppContext() {
        return RickAndMorty.context;
    }

    public void onCreate() {
        super.onCreate();
        RickAndMorty.context = getApplicationContext();
    }
}
