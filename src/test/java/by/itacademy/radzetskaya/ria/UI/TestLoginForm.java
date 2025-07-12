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

    //проверяем, что поля емейла и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused(){
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginPage.isEmailLabelContainClass(classForCheck);
        loginPage.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginPage.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля емейла при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick,"По умолчанию у поля Емейла нет класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testPasswordLabelChangeOnFocused(){
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginPage.isPasswordLabelContainClass(classForCheck);
        loginPage.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginPage.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick,"По умолчанию у поля пароля нет класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поля емейла и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmailLabelChangeOnInvalid(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginPage.isEmailLabelContainClass(classForCheck);
        loginPage.clickOnEmailLabel();
        loginPage.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginPage.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick,"Сначала у поля емейла не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testPasswordLabelChangeOnInvalid(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginPage.isPasswordLabelContainClass(classForCheck);
        loginPage.clickOnPasswordLabel();
        loginPage.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginPage.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick,"Сначала у поля пароля не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля пароль должен был появиться класс " + classForCheck)
        );
    }

}
