package org.example.util.constant;

import org.example.util.Utils;

public final class ExceptionMessage {

    // ========== Сообщения об ошибках создания ==========
    public static final String ERROR_CREATION_ECOSYSTEM_NAME_MESSAGE = Utils.colorizeRedText("Экосистема с таким названием уже существует.");

    // ========== Сообщения об ошибках ввода ==========
    public static final String ERROR_ENTER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nповторите ввод: ");
    public static final String ERROR_ENTER_MAX_ATTEMPTS_MESSAGE = Utils.colorizeRedText("Превышено допустимое количество попыток ввода.");
    public static final String ERROR_ENTER_ECOSYSTEM_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nЭкосистема с таким номером отсутствует.");
    public static final String ERROR_ENTER_ANIMAL_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nЖивотное с таким номером отсутствует.");
    public static final String ERROR_ENTER_PLANT_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nЖивотное с таким номером отсутствует.");

    public static final String ERROR_ENTER_ECOSYSTEM_NAME_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Имя экосистемы должно содержать от 2 до 100 символов, включая буквы английского и русского алфавита и цифры.
            """
    );

    public static final String ERROR_ENTER_TEMPERATURE_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Температура должна быть в пределах от -40 до +50 °C,
            """
    );

    public static final String ERROR_ENTER_HUMIDITY_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Влажность должна быть в пределах от 1 до 100 %.
            """
    );

    public static final String ERROR_ENTER_AVAILABLE_WATER_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Количество воды должно быть в пределах от 1 до 100000000 л,
            """
    );

    private ExceptionMessage() {
    }
}