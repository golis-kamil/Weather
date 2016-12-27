package sda.code.strategy;

import sda.code.CityQuery;
import sda.code.settings.Settings;
import sda.code.settings.SettingsDefaults;

/**
 * Created by trot on 21.12.16.
 */
public class Client {

    private ClientStrategy strategy;
    private CityQuery cityQuery;

    public Client(ClientStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Nie okreslono rodzaju klienta");
        }

        this.strategy = strategy;
    }

    public Client() {
        this.strategy = Settings.CONFIG.getDefaultClient();
    }

    public void setCity(String city) {
        this.cityQuery = new CityQuery(city);
    }

    public void setCity(String city, String countryCode) {
        this.cityQuery = new CityQuery(city, countryCode);
    }

    public void setCity(CityQuery cityQuery) {
        this.cityQuery = cityQuery;
    }

    public void getWeather() {
        if (this.cityQuery == null) {
            this.cityQuery = new CityQuery(SettingsDefaults.DEFAULT_CITY_VALUE.getValue());
        }
        strategy.getWeather(cityQuery);
    }
}
