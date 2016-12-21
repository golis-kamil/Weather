package sda.code.clients;

import sda.code.CityQuery;
import sda.code.ClientStrategy;
import sda.code.WeatherClient;

/**
 * Created by trot on 21.12.16.
 */
public class SyncClient implements ClientStrategy {

    private WeatherClient client;

    public SyncClient() {
        this.client = new WeatherClient();
    }

    @Override
    public void getWeather(CityQuery cityQuery) {
        System.out.println("Sync Client.");
        client.setCity(cityQuery);
        client.parseWeather();
    }
}
