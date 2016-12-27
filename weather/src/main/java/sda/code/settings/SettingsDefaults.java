package sda.code.settings;

public enum SettingsDefaults {
    APPLICATION_ID("appId"),
    DEFAULT_APP_ID_VAL("1f81d97565a7021d5119e8df69ab9313"),
    ADDRESS("adress"),
    DEFAULT_ADDRESS_VALUE("whttp://api.openweathermap.org/data/2.5/weather"),
    DEFAULT_CITY("defaultCity"),
    DEFAULT_CITY_VALUE("warsaw"),
    DEFAULT_LANG("defaultLanguage"),
    DEFAULT_LANG_VALUE("english"),
    DEFAULT_UNITS("defaultUnits"),
    DEFAULT_UNITS_VAL("metric"),
    DEFAULT_CLIENT("defaultClient"),
    DEFAULT_CLIENT_VAL("sync");

    private String defaults;

    SettingsDefaults(String defaults) {
        this.defaults = defaults;
    }

    public String getValue() {
        return defaults;
    }
}
