package sda.code;

import sda.code.clients.AsyncClient;
import sda.code.clients.SyncClient;
import sda.code.strategy.Client;

public class WeatherApp {

    public static void main(String[] args) {

        CityQuery cityQuery = new CityQuery("Lodz", "PL");

        System.out.println("Aplikacja pogodowa.");

        Client client = new Client(new SyncClient());
        client.setCity(cityQuery);
        client.getWeather();

        client = new Client(new AsyncClient());
        client.setCity("Kutno", "PL");
        client.getWeather();

    }
}