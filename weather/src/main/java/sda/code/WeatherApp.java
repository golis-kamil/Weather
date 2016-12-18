package sda.code;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sda.code.weathermodel.Weather;
import sda.code.weathermodel.Weather_;

public class WeatherApp {

	// private static final String APPID ="1f81d97565a7021d5119e8df69ab9313";
	// private static final String ADRES_API =
	// "http://api.openweathermap.org/data/2.5/weather";
	public static void main(String[] args) {

		String json = null;
		URI uri = null;

		CityQuery cityQuery = new CityQuery("Lodz");

		System.out.println("Aplikacja pogodowa.");

		uri = UriHelper.getUri(cityQuery);
		json = ApiHelper.getDataFromApi(uri);
		Weather weather = null;
		show(json);
	}

	private static void show(String json) {
		Weather weather;
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		if (json == null || json.isEmpty()) {
			System.out.println("Brak odpowiedzi z serwera.");
			return;
		}

		weather = gson.fromJson(json, Weather.class);

		if (weather == null) {
			System.err.println("Nie uda�o si� zdeserializowa� odpowiedzi.");
			return;
		}
		if (weather.getName() != null) {
			System.out.println(weather.getName());
		}
		if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
			// Dla test�w wykorzystanie strumieni.
			weather.getWeather().stream().forEach(x -> System.out.println(x.getDescription()));
			// To samo co wy�ej ale za pomoc� foreach.
			// for (Weather_ w : weather.getWeather()) {
			// // System.out.println(weather.getWeather().get(0));
			// System.out.println(w.getDescription());
			// }
		}
		if (weather.getMain() != null) {
			System.out.println(weather.getMain().getTemp());
		}
	}

	
}