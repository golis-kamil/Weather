package sda.code;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


public class SettingsTest {

	@Test
	public void loadingConfig() {
		// fail("Uncomment test");
        assertEquals("http://api.openweathermap.org/data/2.5/weather", Settings.CONFIG.getAddress());
        assertEquals("1f81d97565a7021d5119e8df69ab9313",Settings.CONFIG.getApiId());
	}
	
	@Test
	public void getDefaultCity() {
		assertEquals("Lodz",Settings.CONFIG.getDefaultCity());
	}
	
	@Test
	public void testUri() throws URISyntaxException {
		URI uri = new URI("http://api.openweathermap.org/data/2.5/weather?q=Lodz&units=metric&lang=pl&appid=1f81d97565a7021d5119e8df69ab9313");
		assertEquals(uri,UriHelper.getUri(new CityQuery("Lodz")));
	}
}
