package sda.code.clients;

import sda.code.CityQuery;
import sda.code.WeatherClient;
import sda.code.strategy.ClientStrategy;

/**
 * Created by trot on 21.12.16.
 */
public class SyncClient implements ClientStrategy {

    private WeatherClient weatherClient;

    public SyncClient() {
        this.weatherClient = new WeatherClient();
    }

    @Override
    public void getWeather(CityQuery cityQuery) {
        System.out.println("Sync Client.");
        weatherClient.setCity(cityQuery);
        weatherClient.parseWeather();
    }
}
