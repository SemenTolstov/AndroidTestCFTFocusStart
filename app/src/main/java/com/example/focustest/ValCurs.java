package com.example.focustest;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ValCurs {
    @SerializedName("Valute")
    private Map<String, Valute> valuteList;

    public Map<String, Valute> getValuteList() {
        return valuteList;
    }

    @Override
    public String toString() {
        return "ValCurs{" +
                "valuteList=" + valuteList +
                '}';
    }
}
