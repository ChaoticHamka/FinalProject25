package by.itacademy.radzetskaya.ria.API;

import by.itacademy.radzetskaya.ria.API.modules.Login;
import by.itacademy.radzetskaya.ria.API.utils.BaseAPI;
import by.itacademy.radzetskaya.ria.API.utils.LogAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogin extends BaseAPI {

    private Login login;

    @BeforeEach
    public void setLogin() {
        this.login = new Login();
    }

    @Test
    public void testDefault() {
        String heading = "Проверка по умолчанию (email и пароль валидные)";
        LogAPI.startTest(heading);
        login.setResponseDefault();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testWrongPassword() {
        String heading = "Проверка на неверный пароль (email и пароль валидные)";
        LogAPI.startTest(heading);
        login.setResponseWithEmail();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("wrong", login.getResponseAsJSON().getString("errors.password"), "password должен быть \"wrong\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testWrongPasswordLimit() {
        String heading = "Проверка на неверный пароль (email и пароль валидные)";
        LogAPI.startTest(heading);
        login.setResponseWithEmail();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("logins limit", login.getResponseAsJSON().getString("errors.auth"), "auth должен быть \"logins limit\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testWithoutHeaders() {
        String heading = "Проверка без хедеров (email и пароль валидные)";
        LogAPI.startTest(heading);
        login.setResponseDefaultWithoutHeaders();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyPassword() {
        String heading = "Проверка с пустым паролем (email валидный)";
        LogAPI.startTest(heading);
        login.setResponseEmptyPassword();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.password"), "password должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyLogin() {
        String heading = "Проверка с пустым email (пароль валидный)";
        LogAPI.startTest(heading);
        login.setResponseEmptyLogin();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testNotEmail() {
        String heading = "Проверка вместо email имя (пароль валидный)";
        LogAPI.startTest(heading);
        login.setResponseLoginNotEmail();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyLoginAndPassword() {
        String heading = "Проверка с пустыми email и паролем";
        LogAPI.startTest(heading);
        login.setResponseEmptyLoginAndPassword();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyBody() {
        String heading = "Проверка с пустым body";
        LogAPI.startTest(heading);
        login.setResponseEmptyBody();
        assertAll(
                heading,
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }
}
