package sda.code;

import sda.code.weathermodel.Weather;

public class Presenter {

    public static void show(Weather weather) {
        //Weather weather = new DeserializeJson().getWeatherFromJson(json).get();

//        if (weather == null) {
//            System.err.println("Nie udało się zdeserializować odpowiedzi.");
//            return;
//        }
        if (weather.getName() != null) {
            System.out.println(weather.getName());
        }
        if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
            weather.getWeather().stream().forEach(x -> System.out.println(x.getDescription()));
        }
        if (weather.getMain() != null) {
            System.out.println(weather.getMain().getTemp());
        }
    }
}
