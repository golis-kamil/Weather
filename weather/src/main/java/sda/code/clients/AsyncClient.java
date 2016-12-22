package sda.code.clients;

import sda.code.CityQuery;
import sda.code.WeatherClient;
import sda.code.strategy.ClientStrategy;

/**
 * Created by trot on 21.12.16.
 */
public class AsyncClient implements ClientStrategy {

    private WeatherClient weatherClient;

    public AsyncClient() {
        this.weatherClient = new WeatherClient();
    }

    @Override
    public void getWeather(CityQuery cityQuery) {
        System.out.println("Async Client.");
        weatherClient.setCity(cityQuery);
        weatherClient.parseWeather();
    }
}
