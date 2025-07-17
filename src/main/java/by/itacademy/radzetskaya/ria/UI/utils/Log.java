package by.itacademy.radzetskaya.ria.UI.utils;

public class Log extends BaseLog {

    public static void startTest(String message) {
        info("[Тест: " + message + "]");
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

    public static void valueInfo(String message, Boolean value) {
        debug("-> " + message + value);
    }

    public static void setValue(String value) {
        debug("Вводим значение - " + value);
    }

    public static void setEmailAndPassword(String email, String password) {
        debug("Вводим значения емейла - " + email + " и пароля - " + password);
    }

    public static void endTest() {
        info("===Завершение теста===");
    }
}
