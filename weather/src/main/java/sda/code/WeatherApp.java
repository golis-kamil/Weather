package sda.code;

import sda.code.clients.AsyncClient;
import sda.code.clients.SyncClient;

public class WeatherApp {

    public static void main(String[] args) {

        CityQuery cityQuery = new CityQuery("Lodz", "PL");

        System.out.println("Aplikacja pogodowa.");

        Client client = new Client(new SyncClient());
        client.getWeather(cityQuery);

        client = new Client(new AsyncClient());
        client.getWeather(new CityQuery("Kutno", "PL"));
    }
}