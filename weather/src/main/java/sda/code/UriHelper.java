package sda.code;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.apache.http.client.utils.URIBuilder;

public class UriHelper {

	private static URI uri;

	public static URI getUri(CityQuery city) {
		uri = null;

		try {
			uri = new URIBuilder(Settings.CONFIG.getAdress()).setParameter("q", city.toString())
					.setParameter("units", Settings.CONFIG.getDefaultUnits()).setParameter("lang", Settings.CONFIG.getDefaultLanguage())
					.setParameter("appid", Settings.CONFIG.getApiId()).build();

		} catch (URISyntaxException e1) {
			e1.printStackTrace();

		}
		return uri;
	}
}
