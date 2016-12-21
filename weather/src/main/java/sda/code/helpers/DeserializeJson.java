package sda.code.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sda.code.weathermodel.Weather;

import java.util.Optional;

public class DeserializeJson {

    //private static Gson gson = null;

    public static Optional<Weather> getWeatherFromJson(String json) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        if (json == null || json.isEmpty()) {
            System.out.println("Brak odpowiedzi z serwera.");
            return Optional.empty();
        }
        Weather weather = gson.fromJson(json, Weather.class);
        return Optional.ofNullable(weather);
    }
}
