package com.example.focustest;

import android.app.Application;

import java.util.List;

public class CurrencyConverterApp extends Application {

    private static CurrencyConverterApp instance;
    public List<Valute> valutes;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static CurrencyConverterApp getContext() {
        return instance;
    }
}
