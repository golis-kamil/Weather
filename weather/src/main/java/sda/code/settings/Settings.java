package sda.code.settings;

import sda.code.clients.AsyncClient;
import sda.code.clients.SyncClient;
import sda.code.strategy.ClientStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public enum Settings {
    CONFIG;

    private final Properties props;
    private InputStream config = null;

    Settings() {
        props = new Properties();
        config = Settings.class.getResourceAsStream("/default.conf");
        try {
            props.load(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getApiId() {
        return Optional.ofNullable(props.getProperty(SettingsDefaults.APPLICATION_ID.getValue()))
                .orElse(SettingsDefaults.DEFAULT_APP_ID_VAL.getValue()).toString();
    }

    public String getAddress() {
        return Optional.ofNullable(props.getProperty(SettingsDefaults.ADDRESS.getValue()))
                .orElse(SettingsDefaults.DEFAULT_ADDRESS_VALUE.getValue()).toString();
    }

    public String getDefaultCity() {
        return Optional.ofNullable(props.getProperty(SettingsDefaults.DEFAULT_CITY.getValue()))
                .orElse(SettingsDefaults.DEFAULT_CITY_VALUE.getValue()).toString().toLowerCase();
    }

    public String getDefaultLanguage() {
        String lang = Optional.ofNullable(props.getProperty(SettingsDefaults.DEFAULT_LANG.getValue()))
                .orElse(SettingsDefaults.DEFAULT_LANG_VALUE.getValue()).toString().toLowerCase();
        switch (lang) {
            case "polish":
                return Language.POLISH.getLanguage().toLowerCase();

            case "german":
                return Language.GERMAN.getLanguage().toLowerCase();

            default:
                return Language.ENGLISH.getLanguage().toLowerCase();
        }
    }

    public String getDefaultUnits() {
        String units = Optional.ofNullable(props.getProperty(SettingsDefaults.DEFAULT_UNITS.getValue()))
                .orElse(SettingsDefaults.DEFAULT_UNITS_VAL.getValue()).toString().toLowerCase();
        switch (units) {
            case "imperial":
                return Units.IMPERIAL.toString().toLowerCase();

            default:
                return Units.METRIC.toString().toLowerCase();
        }
    }

    public ClientStrategy getDefaultClient() {
        String client = Optional.ofNullable(props.getProperty(SettingsDefaults.DEFAULT_CLIENT.getValue()))
                .orElse(SettingsDefaults.DEFAULT_CLIENT_VAL.getValue()).toString().toLowerCase();
        switch (client) {
            case "async":
                return new AsyncClient();

            default:
                return new SyncClient();
        }
    }
}
