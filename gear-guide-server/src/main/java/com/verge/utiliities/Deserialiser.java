package com.verge.utiliities;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class Deserialiser {

    private static Gson gson = new Gson();

    public static <T> T deserialise(String objString, Class<T> clazz) {
        return gson.fromJson(objString, clazz);
    }
}
