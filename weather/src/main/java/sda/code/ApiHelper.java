package sda.code;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiHelper {

	public static String getDataFromApi(URI uri) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String json = null;
		HttpGet httpGet = new HttpGet(uri);

		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			json = EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
