package com.example.focustest;
import com.google.gson.annotations.SerializedName;

class Valute {
    @SerializedName("Value")
    public String value;

    @SerializedName("CharCode")
    public String code;

    @SerializedName("Nominal")
    public float nominal;

    @SerializedName("Name")
    public String name;

    @Override
    public String toString() {
        return "Valute{" +
                "value='" + value + '\'' +
                ", code='" + code + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                '}';
    }


}