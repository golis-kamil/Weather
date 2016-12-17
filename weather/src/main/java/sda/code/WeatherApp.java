package sda.code;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
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

	//TODO wystawic klucz do pliku konfiguracyjnego - ale nie wysatwiac np. na github
	private static final String APPID ="1f81d97565a7021d5119e8df69ab9313";
	private static final String ADRES_API = "http://api.openweathermap.org/data/2.5/weather";
	
	public static void main(String[] args) {

		String json = null;
		URI uri=null;

		CityQuery cityQuery = new CityQuery("Lodz");
		
		System.out.println("Aplikacja pogodowa.");

		CloseableHttpClient httpclient = HttpClients.createDefault();

		// HttpGet URL dla pobrania pogody z api. Ca³y link poni¿ej. Budowany stringbuilderem. 
		// http://api.openweathermap.org/data/2.5/weather?q=Lodz,pl&appid=1f81d97565a7021d5119e8df69ab9313
//		final String adressUrl = new StringBuilder(ADDRESAPI).append("?q=").append("Lodz,PL").append("&units=metric")
//				.append("&lang=pl").append("&appid=").append(APPID).toString();

		//Z wykorzystaniem metod URIBuildera zamiast StringBuildera
		try {
			uri = new URIBuilder(ADRES_API)
//					.setScheme("http")
//			        .setHost("api.openweathermap.org")
//			        .setPath("/data/2.5/weather")
			        .setParameter("q", cityQuery.toString())
			        .setParameter("units", "metric")
			        .setParameter("lang", "pl")
			        .setParameter("appid", APPID)
			        .build();
				
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			return;
		}
		
		HttpGet httpGet = new HttpGet(uri);

		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			json = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Wykluczamy pola które nie maj¹ anotacji @Exclude dziêki czemu mo¿na
		// rozbudowaæ klasy modelu
		// o w³asne pola które nie bed¹ de/serializowane do/z jsona. Ta funkcja
		// dostêpna jest z GsonBuildera.
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Weather weather = null;

		if (json == null || json.isEmpty()) {
			System.out.println("Brak odpowiedzi z serwera.");
			return;
		}

		weather = gson.fromJson(json, Weather.class);

		if (weather == null) {
			System.err.println("Nie uda³o siê zdeserializowaæ odpowiedzi.");
			return;
		}
		if (weather.getName() != null) {
			System.out.println(weather.getName());
		}
		if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
			//Dla testów wykorzystanie strumieni.
			weather.getWeather().stream().forEach(x -> System.out.println(x.getDescription()));
			//To samo co wy¿ej ale za pomoc¹ foreach.
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
