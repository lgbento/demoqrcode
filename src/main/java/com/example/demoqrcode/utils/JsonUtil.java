package com.example.demoqrcode.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtil {

    public static Gson getGsonParser() {
        // fix com.google.gson.JsonSyntaxException on parsing dates
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                Date date = null;
                try {
                    long longDate = json.getAsJsonPrimitive().getAsLong();
                    date = new Date(longDate);
                } catch (NumberFormatException nfe) {
                    String stringDate = json.getAsJsonPrimitive().getAsString();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = sdf.parse(stringDate);
                    } catch (ParseException pe) {
                        // other date formats ?
                    }
                }
                return date;
            }
        });
        return builder.create();
    }
}
