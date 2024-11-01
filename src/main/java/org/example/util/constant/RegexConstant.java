package org.example.util.constant;

public final class RegexConstant {
    public static final String ECOSYSTEM_NAME = "^[a-zA-Zа-яА-Я0-9]{2,100}$";
    public static final String TEMPERATURE_REGEX = "^-?(40|[0-3]?\\d|50)$";
    public static final String HUMIDITY_REGEX = "^[1-9]\\d{0,2}$";
    public static final String AVAILABLE_WATER = "[1-9]\\d{0,8}";
    public static final String STEP_REGEX = "^[0-9]+$";

    private RegexConstant() {
    }
}