package by.itacademy.radzetskaya.ria.API.utils;

import by.itacademy.radzetskaya.ria.Base.BaseLog;

public class LogAPI extends BaseLog {

    public static void startTest(String message) {
        info("[ТестAPI: " + message + "]");
    }

    public static void setValue(String field, String value) {
        debug("Устанавливаем значение поля " + field + " " + value);
    }

    public static void endTest() {
        info("===Завершение теста===");
    }

}
