package by.itacademy.radzetskaya.ria.API;

import by.itacademy.radzetskaya.ria.API.modules.Login;
import by.itacademy.radzetskaya.ria.API.utils.LogAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogin{

    private Login login;

    @BeforeEach
    public void setLogin(){
        this.login = new Login();
    }

//    @Test
    public void testDefault(){
        LogAPI.startTest("Проверка по умолчанию (емейл и пароль валидные)");
        login.setResponseDefault();
        assertAll(
                "Проверка по умолчанию (емейл и пароль валидные)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testWrongPassword(){
        LogAPI.startTest("Проверка на неверный пароль (емейл и пароль валидные)");
        login.setResponseWithEmail();
        assertAll(
                "Проверка на неверный пароль (емейл и пароль валидные)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("wrong", login.getResponseAsJSON().getString("errors.password"), "password должен быть \"wrong\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testWrongPasswordLimit(){
        LogAPI.startTest("Проверка на неверный пароль (емейл и пароль валидные)");
        login.setResponseWithEmail();
        assertAll(
                "Проверка на неверный пароль (емейл и пароль валидные)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("logins limit", login.getResponseAsJSON().getString("errors.auth"), "auth должен быть \"logins limit\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testWithoutHeaders(){
        LogAPI.startTest("Проверка без хедеров (емейл и пароль валидные)");
        login.setResponseDefaultWithoutHeaders();
        assertAll(
                "Проверка без хедеров (емейл и пароль валидные)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testEmptyPassword(){
        LogAPI.startTest("Проверка с пустым паролем (емейл валидный)");
        login.setResponseEmptyPassword();
        assertAll(
                "Проверка с пустым паролем (емейл валидный)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.password"), "password должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testEmptyLogin(){
        LogAPI.startTest("Проверка с пустым емейлом (пароль валидный)");
        login.setResponseEmptyLogin();
        assertAll(
                "Проверка с пустым емейлом (пароль валидный)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

//    @Test
    public void testNotEmail(){
        LogAPI.startTest("Проверка вместо емейла имя (пароль валидный)");
        login.setResponseLoginNotEmail();
        assertAll(
                "Проверка вместо емейла имя (пароль валидный)",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("not_exist", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"not_exist\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyLoginAndPassword(){
        LogAPI.startTest("Проверка с пустыми емейлом и паролем");
        login.setResponseEmptyLoginAndPassword();
        assertAll(
                "Проверка с пустыми емейлом и паролем",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }

    @Test
    public void testEmptyBody(){
        LogAPI.startTest("Проверка с пустым body");
        login.setResponseEmptyBody();
        assertAll(
                "Проверка с пустым body",
                () -> assertEquals(200, login.getResponseStatusCode(), "Статус-код должен быть 200"),
                () -> assertEquals("error", login.getResponseAsJSON().getString("status"), "Статус должен быть \"error\""),
                () -> assertEquals("empty", login.getResponseAsJSON().getString("errors.login"), "login должен быть \"empty\"")
        );
        LogAPI.endTest();
    }
}
