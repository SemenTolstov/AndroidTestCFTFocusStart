package com.example.focustest;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonParser {
    public static ValCurs valCurs;

    public static ValCurs readJson(InputStream inputStream) {
        Gson gson = new Gson();

        try (Reader reader = new InputStreamReader(inputStream, "UTF-8")) {

            valCurs = gson.fromJson(reader, ValCurs.class);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return valCurs;
    }
}

