package com.example.focustest;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyRequest {

    private static final String path = "https://www.cbr-xml-daily.ru/daily_json.js";

    private HandlerThread handlerThread;

    private static volatile boolean isActive = false;
    public static List<Valute> valutes = new ArrayList<>();

    public CurrencyRequest(MyCallBack callBack) {

        if (isActive) {
            Log.d("####", "request already sent");
            return;
        }

        Log.d("####", "Update the exchange rate");

        Handler mainHandler = new Handler(Looper.getMainLooper());
        handlerThread = new HandlerThread("currency_request");
        handlerThread.start();


        final Handler handler = new Handler(handlerThread.getLooper());

        handler.post(() -> {

            isActive = true;

            HttpURLConnection urlConnection = null;

            try {

                URL url = new URL(path);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();

                Log.d("####", "New curce is loaded");

                ValCurs json = JsonParser.readJson(inputStream);

                Log.d("####", "json = " + json.toString());

                for (Map.Entry<String, Valute> entry : json.getValuteList().entrySet()) {
                    valutes.add(entry.getValue());
                }

                Log.d("####", "valutes = " + valutes);
                mainHandler.post(callBack::callbackCall);
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                isActive = false;
            }
        });
    }

    public void onDestroy() {
        handlerThread.quit();
    }

}

