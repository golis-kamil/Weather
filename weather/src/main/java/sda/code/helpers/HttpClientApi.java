package sda.code.helpers;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

public class HttpClientApi {

    private static final int HTTP_OK = 200;
    private static final String RESPONSE_ENCODING = "UTF-8";

    private static String json = null;
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static Optional<String> getDataAsJSON(URI uri) {

        HttpGet httpGet = new HttpGet(uri);

        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() == HTTP_OK) {
                HttpEntity entity = response.getEntity();
                json = EntityUtils.toString(entity, RESPONSE_ENCODING);
                EntityUtils.consume(entity);
            }
//            System.out.println(response.getStatusLine());
        } catch (IOException e) {
            System.err.println("Blad odczytu z serwera.");
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.ofNullable(json);
    }
}
