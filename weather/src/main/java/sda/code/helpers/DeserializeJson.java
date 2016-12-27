package sda.code.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sda.code.weathermodel.Weather;

import java.util.Optional;

public class DeserializeJson {

    public static Optional<Weather> getWeatherFromJson(String json) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        if (json == null || json.isEmpty()) {
            System.out.println("Brak odpowiedzi z serwera.");
            return Optional.empty();
        } else if (json.equals("{\"cod\":\"502\",\"message\":\"Error: Not found city\"}")) {
            System.out.println("Nie znalezniono takiego miasta.");
            return Optional.empty();
        }
        Weather weather = gson.fromJson(json, Weather.class);
        return Optional.ofNullable(weather);
    }
}
