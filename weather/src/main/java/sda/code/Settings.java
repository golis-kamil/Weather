package sda.code;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public enum Settings {
	CONFIG;

	private final Properties props;
	private InputStream config = null;

	private Settings() {
		props = new Properties();
		config = Settings.class.getResourceAsStream("/default.conf");
		try {
			props.load(config);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getApiId() {
		return Optional.ofNullable(props.getProperty("appId")).orElse("123").toString();
	}

	public String getAdress() {
		return Optional.ofNullable(props.getProperty("adress")).orElse("www.google.com").toString();
	}

	public String getDefaultCity() {
		return Optional.ofNullable(props.getProperty("defaultCity")).orElse("Warsaw").toString();
	}

	public String getDefaultLanguage() {
		String lang = Optional.ofNullable(props.getProperty("defaultLanguage")).orElse("English").toString();
		switch (lang.toLowerCase()) {
		case "polish":
			return Language.POLISH.setLanguage();

		case "german":
			return Language.GERMAN.setLanguage();

		default:
			return Language.ENGLISH.setLanguage();
		}
	}

	public String getDefaultUnits() {
		String units = Optional.ofNullable(props.getProperty("defaultUnits")).orElse("metric").toString();
		switch (units.toLowerCase()) {
		case "imperial":
			return Units.IMPERIAL.toString();

		default:
			return Units.METRIC.toString();
		}
	}
}
