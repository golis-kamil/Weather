package sda.code.helpers;

import org.apache.http.client.utils.URIBuilder;
import sda.code.CityQuery;
import sda.code.settings.Settings;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class UriHelper {

    private static URI uri;

    public static Optional<URI> getUri(CityQuery city) {
        uri = null;

        try {
            uri = new URIBuilder(Settings.CONFIG.getAddress())
                    .setParameter("q", city.toString())
                    .setParameter("units", Settings.CONFIG.getDefaultUnits())
                    .setParameter("lang", Settings.CONFIG.getDefaultLanguage())
                    .setParameter("appid", Settings.CONFIG.getApiId())
                    .build();

        } catch (URISyntaxException e1) {
            e1.printStackTrace();
            return Optional.empty();

        }
        return Optional.ofNullable(uri);
    }
}
