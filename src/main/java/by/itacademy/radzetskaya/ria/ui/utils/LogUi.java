package by.itacademy.radzetskaya.ria.ui.utils;

import by.itacademy.radzetskaya.ria.Base.BaseLog;

public class LogUi extends BaseLog {

    public static void startTest(String message) {
        info("[ТестUI: " + message + "]");
    }

    public static void defaultActions(String message) {
        info(message);
    }

    public static void testActions(String message) {
        info("Выполнение действий теста: " + message);
    }

    public static void actionsInfoCheckClass(String classForCheck, String message) {
        debug("Проверяем наличие класса " + classForCheck + message);
    }

    public static void valueInfo(Boolean value) {
        debug("\tТекущее значение = " + value);
    }

    public static void valueInfo(String field, String value) {
        debug("\tТекущее значение поля " + field + " = " + value);
    }

    public static void valueInfo(String message, Boolean value) {
        debug("-> " + message + value);
    }

    public static void setValueEmail(String value) {
        debug("Вводим значение в поле email " + value);
    }

    public static void setValuePassword(String value) {
        debug("Вводим значение в поле пароля " + value);
    }

    public static void setArticle(String value) {
        debug("Выбрана статья " + value);
    }

    public static void endTest() {
        info("===Завершение теста===");
    }
}
