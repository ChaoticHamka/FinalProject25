package by.itacademy.radzetskaya.ria.api;

import by.itacademy.radzetskaya.ria.api.modules.LoginUtils;
import by.itacademy.radzetskaya.ria.api.utils.LogApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogin extends LoginUtils {

    @Test
    public void testDefault() {
        String heading = "Проверка по умолчанию (email и пароль валидные)";
        LogApi.startTest(heading);
        setResponseDefault();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
    }

    @Test
    public void testWrongPassword() {
        String heading = "Проверка на неверный пароль (email и пароль валидные)";
        LogApi.startTest(heading);
        setResponseWithEmail();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("wrong", getResponseAsJSON().getString("errors.password"), "password должен быть \"wrong\"")
        );
    }

    @Test
    public void testWrongPasswordLimit() {
        String heading = "Проверка на неверный пароль при лимите (email и пароль валидные)";
        LogApi.startTest(heading);
        for (int i = 0; i < 10; i++) {
            setResponseWithEmail();
        }
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("logins limit", getResponseAsJSON().getString("errors.auth"), "auth должен быть \"logins limit\"")
        );
    }

    @Test
    public void testWithoutHeaders() {
        String heading = "Проверка без хедеров (email и пароль валидные)";
        LogApi.startTest(heading);
        setResponseDefaultWithoutHeaders();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
    }

    @Test
    public void testEmptyPassword() {
        String heading = "Проверка с пустым паролем (email валидный)";
        LogApi.startTest(heading);
        setResponseEmptyPassword();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", getResponseAsJSON().getString("errors.password"), "password должен быть \"empty\"")
        );
    }

    @Test
    public void testEmptyLogin() {
        String heading = "Проверка с пустым email (пароль валидный)";
        LogApi.startTest(heading);
        setResponseEmptyLogin();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
    }

    @Test
    public void testNotEmail() {
        String heading = "Проверка вместо email имя (пароль валидный)";
        LogApi.startTest(heading);
        setResponseLoginNotEmail();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
    }

    @Test
    public void testEmptyLoginAndPassword() {
        String heading = "Проверка с пустыми email и паролем";
        LogApi.startTest(heading);
        setResponseEmptyLoginAndPassword();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
    }

    @Test
    public void testEmptyBody() {
        String heading = "Проверка с пустым body";
        LogApi.startTest(heading);
        setResponseEmptyBody();
        assertAll(
                heading,
                () -> assertEquals(200, getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
    }
}
