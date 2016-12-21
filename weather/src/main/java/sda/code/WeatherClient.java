package sda.code;

import sda.code.helpers.DeserializeJson;
import sda.code.helpers.HttpClientApi;
import sda.code.helpers.UriHelper;

/**
 * Created by trot on 21.12.16.
 */
public class WeatherClient {

    private CityQuery cityQuery;

    public void setCity(CityQuery cityQuery) {
        this.cityQuery = cityQuery;
    }

    public void parseWeather() {

        UriHelper.getUri(cityQuery).flatMap(HttpClientApi::getDataAsJSON)
                .flatMap(DeserializeJson::getWeatherFromJson).ifPresent(Presenter::show);

    }
}
