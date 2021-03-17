package com.example.focustest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Valute> valuteList;

    CurrencyAdapter(Context context, List<Valute> valuteList) {
        this.valuteList = valuteList;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Valute valute = valuteList.get(position);
        holder.nameView.setText(valute.code);
        holder.capitalView.setText(valute.value);
    }

    @Override
    public int getItemCount() {
        return valuteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, capitalView;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            capitalView = (TextView) view.findViewById(R.id.capital);
        }
    }
}
