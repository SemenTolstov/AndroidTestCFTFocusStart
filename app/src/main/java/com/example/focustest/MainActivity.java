
package com.example.focustest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button button;
    //    ArrayList<Valute> valutes = new ArrayList<>();
    CurrencyRequest currencyRequest = new CurrencyRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        CurrencyAdapter adapter = new CurrencyAdapter(this, currencyRequest.valutes);
        // устанавливаем для списка адаптер

        button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(adapter);
            }
        });
    }

}