package sda.code;

public enum Language {
    POLISH("PL"), GERMAN("DE"), ENGLISH("EN");

    private String lang;

    Language(String lang) {
        this.lang = lang;
    }

    public String setLanguage() {
        return lang;
    }

}
