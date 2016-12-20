package sda.code;

import java.net.URI;

public class WeatherApp {

    public static void main(String[] args) {

        CityQuery cityQuery = new CityQuery("Lodz");

        System.out.println("Aplikacja pogodowa.");

        UriHelper.getUri(cityQuery).flatMap(HttpClientApi::getDataAsJSON)
                .flatMap(DeserializeJson::getWeatherFromJson).ifPresent(Presenter::show);
    }
}