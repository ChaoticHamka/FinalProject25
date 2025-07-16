package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.Login.LoginForm;
import by.itacademy.radzetskaya.ria.UI.utils.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends BaseTest {

    private LoginForm loginForm;
    private Faker faker = new Faker();
    private final int MAX_RANDOM_VALUE = 9999;

    @BeforeEach
    public void openLoginForm(){
        loginForm = new LoginForm();
        loginForm.openAuthorizationForm();
    }

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm(){
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(loginForm.isAuthButtonEnabled(),"Кнопка \"Войти\" должна быть неактивна"),
                () -> assertEquals("Войти", loginForm.getAuthButtonText(), "Текст кнопки должен быть \"Войти\"")
        );
    }

    //проверяем, что поля емейла и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused(){
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля емейла при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick,"По умолчанию у поля Емейла нет класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testPasswordLabelChangeOnFocused(){
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick,"По умолчанию у поля пароля нет класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поля емейла и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick,"Сначала у поля емейла не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testEmptyPasswordLabelChangeOnInvalid(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick,"Сначала у поля пароля не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick,"У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поле емейла имеет класс Invalid, если в него введено что-то кроме емейла
    @Test
    public void testEmailLabelChangeOnInvalidNumber(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(Integer.toString(faker.random().nextInt(MAX_RANDOM_VALUE)));
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести число",
                () -> assertFalse(isLabelHasClassBeforeEnter,"Сначала у поля емейла не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testEmailLabelChangeOnInvalidFullName(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(faker.name().fullName());
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести имя и фамилию",
                () -> assertFalse(isLabelHasClassBeforeEnter,"Сначала у поля емейла не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testEmailLabelChangeOnInvalidLogin(){
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(faker.name().username());
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести имя",
                () -> assertFalse(isLabelHasClassBeforeEnter,"Сначала у поля емейла не должно быть класса "+ classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter,"У поля Емейла должен был появиться класс " + classForCheck)
        );
    }

}
