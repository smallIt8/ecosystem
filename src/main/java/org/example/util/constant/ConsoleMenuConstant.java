package org.example.util.constant;

import org.example.util.Utils;

public final class ConsoleMenuConstant {

    // ========== Сообщения о выполняемых действиях ==========
    public static final String FINISHING_MESSAGE = "Завершение программы";

    // ========== Информационные сообщения ==========
    public static final String EMPTY_LIST_ECOSYSTEM_MESSAGE = Utils.colorizeGreenText("Сейчас нет созданных экосистем.");
    public static final String LIST_ECOSYSTEMS_MESSAGE = Utils.colorizeGreenText("Сейчас доступны следующие экосистемы:");
    public static final String LIST_FILM_TIMES_MESSAGE = Utils.colorizeGreenText("Сейчас доступно следующее время добавляемого сеанса фильма:");
    public static final String LIST_FILM_SESSIONS_MESSAGE = Utils.colorizeGreenText("Сейчас доступны следующие сеансы выбранного фильма:");
    public static final String LIST_FILM_SEATS_MESSAGE = Utils.colorizeGreenText("Сейчас доступны следующие места на сеанс выбранного фильма:");
    public static final String PURCHASING_TICKET_FILM_MESSAGE = Utils.colorizeGreenText("Вы приобретаете билет на следующее мероприятие:");
    public static final String USER_LIST_TICKETS_MESSAGE = Utils.colorizeGreenText("Список купленных билетов:");

    // ========== Сообщения о выполненных действиях ==========
    public static final String CREATED_ECOSYSTEM_MESSAGE = Utils.colorizeGreenText("Вы создали новую экосистему.");
    public static final String SELECTED_ECOSYSTEM_MESSAGE = Utils.colorizeGreenText("Вы выбрали экосистему: ");

    // ========== Инструкции пользователю ==========
    public static final String ENTER_ECOSYSTEM_NUMBER = Utils.colorizeOrangeText("введите номер экосистемы': ");
    public static final String ENTER_ECOSYSTEM_NAME = Utils.colorizeOrangeText("введите название экосистемы: ");
    public static final String ENTER_ANIMAL_NUMBER = Utils.colorizeOrangeText("введите номер животного (0 - для завершения): ");
    public static final String ENTER_PLANT_NUMBER = Utils.colorizeOrangeText("введите номер растения (0 - для завершения): ");
    public static final String ENTER_TEMPERATURE_YEAR = Utils.colorizeOrangeText("введите температуру (°C): ");
    public static final String ENTER_HUMIDITY_COUNTRY = Utils.colorizeOrangeText("введите влажность (%): ");
    public static final String ENTER_AVAILABLE_WATER = Utils.colorizeOrangeText("введите количество доступной воды (л): ");

    // ========== Меню MAIN ==========
    public static final String MAIN_MENU = """
            
                   Добро пожаловать в виртуальную симуляцию экосистемы!
            Выберите необходимый пункт меню:
            1. Продолжить работу с существующими симуляциями
            2. Создать новую симуляцию
            0. Выход
            
            ввод:\s""";

    public static final String MENU_ECOSYSTEM_ADD = "Добавление новой экосистемы: ";

    private ConsoleMenuConstant() {
    }
}