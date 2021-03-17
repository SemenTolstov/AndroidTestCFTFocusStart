
package com.example.focustest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MyCallBack {

    private CurrencyRequest currencyRequest;
    private Button button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        CurrencyAdapter adapter = new CurrencyAdapter(this, CurrencyRequest.valutes);
        button = (Button) findViewById(R.id.button);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(v -> {
            if (!isOnline()) {
                Toast.makeText(getApplicationContext(),
                        "Нет соединения с интернетом!", Toast.LENGTH_LONG).show();
                return;
            }

            if (currencyRequest != null) {
                currencyRequest.onDestroy();
                currencyRequest = null;
            }

            currencyRequest = new CurrencyRequest(this);
        });
    }

    protected boolean isOnline() {
        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(cs);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void callbackCall() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}