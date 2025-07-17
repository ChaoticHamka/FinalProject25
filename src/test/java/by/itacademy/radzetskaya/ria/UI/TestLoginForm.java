package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.pages.Login.LoginForm;
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
    public void openLoginForm() {
        loginForm = new LoginForm();
        loginForm.openAuthorizationForm();
    }

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm() {
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(loginForm.isAuthButtonEnabled(), "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertEquals("Войти", loginForm.getAuthButtonText(), "Текст кнопки должен быть \"Войти\"")
        );
    }

    //проверяем, что поля емейла и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused() {
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля емейла при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля Емейла нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testPasswordLabelChangeOnFocused() {
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поля емейла и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmptyPasswordLabelChangeOnInvalid() {
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля пароля не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поле емейла имеет класс Invalid, если в него введено что-то кроме емейла
    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(Integer.toString(faker.random().nextInt(MAX_RANDOM_VALUE)));
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести число",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testEmailLabelChangeOnInvalidFullName() {
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(faker.name().fullName());
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести имя и фамилию",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
    }
    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        loginForm.setEmailField(faker.name().username());
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести логин",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
    }

    //проверка исчезновения кнопки "Войти" и появления блока "Проверьте емейл"
    @Test
    public void testButtonDisplayOnInvalidField() {
        Boolean isAuthDivIsNotDisplayedBeforeEnter = loginForm.isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = loginForm.isAuthErrorDivNotDisplayed();
        loginForm.setEmailField(faker.internet().emailAddress().replace("@",""));
        Boolean isAuthDivIsNotDisplayedAfterEnter = loginForm.isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = loginForm.isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка поведения блоков Div если ввести почти емейл",
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Войти\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Проверьте адрес почты\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"Войти\" должна была пропасть"),
                () -> assertEquals("Проверьте адрес почты", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Проверьте адрес почты\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Проверьте адрес почты\" должна была появиться")
        );
    }

    //в пароле что-то есть классы - m-notempty m-valid
    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Boolean isLabelHasClassNotEmptyBeforeEnter = loginForm.isPasswordLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = loginForm.isPasswordLabelContainClass(classForCheckValid);
        loginForm.setPasswordField(faker.internet().password());
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = loginForm.isPasswordLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = loginForm.isPasswordLabelContainClass(classForCheckValid);
        assertAll(
                "Проверка поля пароля, если в него что-нибудь ввести",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля пароля должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля пароля должен был появиться класс " + classForCheckValid)
        );
    }

    //верный емейл - m-notempty m-valid
    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Boolean isLabelHasClassNotEmptyBeforeEnter = loginForm.isEmailLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = loginForm.isEmailLabelContainClass(classForCheckValid);
        loginForm.setEmailField(faker.internet().emailAddress());
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = loginForm.isEmailLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = loginForm.isEmailLabelContainClass(classForCheckValid);
        assertAll(
                "Проверка поля емейла, если в него ввести валидный емейл",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля емейла должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля емейла должен был появиться класс " + classForCheckValid)
        );
    }

    //верный емейл и есть пароль
    @Test
    public void testValidEmailAndPassword() {
        Boolean isAuthButtonEnabledBeforeEnter = loginForm.isAuthButtonEnabled();
        loginForm.setEmailField(faker.internet().emailAddress());
        loginForm.setPasswordField(faker.internet().password());
        waiting(2);
        Boolean isAuthButtonEnabledAfterEnter = loginForm.isAuthButtonEnabled();
        assertAll(
                "Проверка изменения кнопки \"Войти\" при вводе валидных данных",
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"Войти\" должна быть активна")
        );
    }
    @Test
    public void testValidEmailAndPasswordSubmit() {
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = loginForm.isAuthErrorDivNotDisplayed();
        loginForm.setEmailField(faker.internet().emailAddress());
        loginForm.setPasswordField(faker.internet().password());
        loginForm.clickAuthButton();
        waiting(2);
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = loginForm.isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка нажатия на кнопку \"Войти\" при вводе валидных, но неверных данных",
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Неправильный логин или пароль\" не должна отображаться"),
                () -> assertEquals("Неправильный логин или пароль", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Неправильный логин или пароль\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Неправильный логин или пароль\" должна была появиться")
        );
    }
}
