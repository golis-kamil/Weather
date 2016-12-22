package sda.code.settings;

public enum SettingsDefaults {
    APPLICATION_ID("appId"),
    ADDRESS("adress"),
    DEFAULT_CITY("defaultCity"),
    DEFAULT_LANG("defaultLanguage"),
    DEFAULT_LANG_VALUE("english"),
    DEFAULT_CITY_VALUE("warsaw"),
    DEFAULT_ADDRESS_VALUE("whttp://api.openweathermap.org/data/2.5/weather"),
    DEFAULT_APP_ID_VAL("1f81d97565a7021d5119e8df69ab9313"),
    DEFAULT_UNITS_VAL("metric"),
    DEFAULT_UNITS("defaultUnits");

    private String defaults;

    SettingsDefaults(String defaults) {
        this.defaults = defaults;
    }

    public String getValue() {
        return defaults;
    }
}
