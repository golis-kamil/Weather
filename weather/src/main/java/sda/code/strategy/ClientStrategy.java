package sda.code.strategy;

import sda.code.CityQuery;

/**
 * Created by trot on 21.12.16.
 */
public interface ClientStrategy {
    void getWeather(CityQuery cityQuery);
}
