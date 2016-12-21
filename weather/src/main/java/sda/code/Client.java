package sda.code;

/**
 * Created by trot on 21.12.16.
 */
public class Client {
    private ClientStrategy strategy;

    public Client(ClientStrategy strategy) {
        this.strategy = strategy;
    }

    public void getWeather(CityQuery cityQuery) {
        strategy.getWeather(cityQuery);
    }
}
