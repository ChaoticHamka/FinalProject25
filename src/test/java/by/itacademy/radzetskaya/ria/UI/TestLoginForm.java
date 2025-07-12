package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.Login.LoginForm;
import by.itacademy.radzetskaya.ria.UI.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends BaseTest {

    LoginForm loginPage;

    @BeforeEach
    public void openLoginForm(){
        loginPage = new LoginForm();
        loginPage.openAuthorizationForm();
    }

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm(){
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(loginPage.isAuthButtonEnabled(),"Кнопка \"Войти\" должна быть неактивна"),
                () -> assertEquals("Войти", loginPage.getAuthButtonText(), "Текст кнопки должен быть \"Войти\"")
        );
    }

}
