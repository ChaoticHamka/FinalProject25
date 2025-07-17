package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.Log;
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
        Log.info("Проверка параметров веб-элементов при открытии формы логина в первый раз");
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(loginForm.isAuthButtonEnabled(), "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertEquals("Войти", loginForm.getAuthButtonText(), "Текст кнопки должен быть \"Войти\"")
        );
        Log.info("---Завершение теста---");
    }

    //проверяем, что поля емейла и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused() {
        Log.info("Проверка поведения поля емейла при клике на него");
        String classForCheck = "m-focused";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeClick);
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterClick);
        assertAll(
                "Проверка поведения поля емейла при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля Емейла нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }
    @Test
    public void testPasswordLabelChangeOnFocused() {
        Log.info("Проверка поведения поля пароля при клике на него");
        String classForCheck = "m-focused";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeClick);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterClick);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }

    //проверяем, что поля емейла и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        Log.info("Проверка лейбла емейла на Invalid");
        String classForCheck = "m-invalid";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeClick = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeClick);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterClick);
        assertAll(
                "Проверка лейбла емейла на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }
    @Test
    public void testEmptyPasswordLabelChangeOnInvalid() {
        Log.info("Проверка лейбла пароля на Invalid");
        String classForCheck = "m-invalid";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeClick = loginForm.isPasswordLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeClick);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = loginForm.isPasswordLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterClick);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля пароля не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }

    //проверяем, что поле емейла имеет класс Invalid, если в него введено что-то кроме емейла
    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        Log.info("Проверка поля емейла на Invalid если ввести число");
        String classForCheck = "m-invalid";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeEnter);
        String enterValue = Integer.toString(faker.random().nextInt(MAX_RANDOM_VALUE));
        loginForm.setEmailField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterEnter);
        assertAll(
                "Проверка поля емейла на Invalid если ввести число",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }
    @Test
    public void testEmailLabelChangeOnInvalidFullName() {
        Log.info("Проверка поля емейла на Invalid если ввести имя и фамилию");
        String classForCheck = "m-invalid";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeEnter);
        String enterValue = faker.name().fullName();
        loginForm.setEmailField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterEnter);
        assertAll(
                "Проверка поля емейла на Invalid если ввести имя и фамилию",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }
    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        Log.info("Проверка поля емейла на Invalid если ввести логин");
        String classForCheck = "m-invalid";
        Log.debug("Проверяем наличие класса " + classForCheck);
        Boolean isLabelHasClassBeforeEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("До действия - " + isLabelHasClassBeforeEnter);
        String enterValue = faker.name().username();
        loginForm.setEmailField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = loginForm.isEmailLabelContainClass(classForCheck);
        Log.debug("После действия - " + isLabelHasClassAfterEnter);
        assertAll(
                "Проверка поля емейла на Invalid если ввести логин",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.info("---Завершение теста---");
    }

    //проверка исчезновения кнопки "Войти" и появления блока "Проверьте емейл"
    @Test
    public void testButtonDisplayOnInvalidField() {
        Log.info("Проверка исчезновения кнопки \"Войти\" и появления блока \"Проверьте емейл\"");
        Boolean isAuthDivIsNotDisplayedBeforeEnter = loginForm.isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = loginForm.isAuthErrorDivNotDisplayed();
        Log.debug("Блок \"Войти\" скрыт - " + isAuthDivIsNotDisplayedBeforeEnter);
        Log.debug("Блок \"Проверьте емейл\" скрыт - " + isAuthErrorDivIsNotDisplayedBeforeEnter);
        String enterValue = faker.internet().emailAddress().replace("@", "");
        loginForm.setEmailField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        Boolean isAuthDivIsNotDisplayedAfterEnter = loginForm.isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = loginForm.isAuthErrorDivNotDisplayed();
        Log.debug("Блок \"Войти\" скрыт - " + isAuthDivIsNotDisplayedAfterEnter);
        Log.debug("Блок \"Проверьте емейл\" скрыт - " + isAuthErrorDivIsNotDisplayedAfterEnter);
        assertAll(
                "Проверка поведения блоков Div если ввести почти емейл",
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Войти\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Проверьте адрес почты\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"Войти\" должна была пропасть"),
                () -> assertEquals("Проверьте адрес почты", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Проверьте адрес почты\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Проверьте адрес почты\" должна была появиться")
        );
        Log.info("---Завершение теста---");
    }

    //в пароле что-то есть классы - m-notempty m-valid
    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Log.info("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести");
        Log.debug("Проверяем наличие классов " + classForCheckNotEmpty + " и " + classForCheckValid);
        Boolean isLabelHasClassNotEmptyBeforeEnter = loginForm.isPasswordLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = loginForm.isPasswordLabelContainClass(classForCheckValid);
        Log.debug("До действия " + classForCheckNotEmpty + " - " + isLabelHasClassNotEmptyBeforeEnter);
        Log.debug("До действия " + classForCheckValid + " - " + isLabelHasClassValidBeforeEnter);
        String enterValue = faker.internet().password();
        loginForm.setPasswordField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = loginForm.isPasswordLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = loginForm.isPasswordLabelContainClass(classForCheckValid);
        Log.debug("После действия " + classForCheckNotEmpty + " - " + isLabelHasClassNotEmptyAfterEnter);
        Log.debug("После действия " + classForCheckValid + " - " + isLabelHasClassValidAfterEnter);
        assertAll(
                "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля пароля должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля пароля должен был появиться класс " + classForCheckValid)
        );
        Log.info("---Завершение теста---");
    }

    //верный емейл - m-notempty m-valid
    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Log.info("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный емейл");
        Log.debug("Проверяем наличие классов " + classForCheckNotEmpty + " и " + classForCheckValid);
        Boolean isLabelHasClassNotEmptyBeforeEnter = loginForm.isEmailLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = loginForm.isEmailLabelContainClass(classForCheckValid);
        Log.debug("До действия " + classForCheckNotEmpty + " - " + isLabelHasClassNotEmptyBeforeEnter);
        Log.debug("До действия " + classForCheckValid + " - " + isLabelHasClassValidBeforeEnter);
        String enterValue = faker.internet().emailAddress();
        loginForm.setEmailField(enterValue);
        Log.debug("Вводим значение - " + enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = loginForm.isEmailLabelContainClass(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = loginForm.isEmailLabelContainClass(classForCheckValid);
        Log.debug("После действия " + classForCheckNotEmpty + " - " + isLabelHasClassNotEmptyAfterEnter);
        Log.debug("После действия " + classForCheckValid + " - " + isLabelHasClassValidAfterEnter);
        assertAll(
                "Проверка поля емейла на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный емейл",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля емейла должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля емейла должен был появиться класс " + classForCheckValid)
        );
        Log.info("---Завершение теста---");
    }

    //верный емейл и есть пароль
    @Test
    public void testValidEmailAndPassword() {
        Log.info("Проверка изменения кнопки \"Войти\" при вводе валидных данных");
        Boolean isAuthButtonEnabledBeforeEnter = loginForm.isAuthButtonEnabled();
        Log.debug("Кнопка \"Войти\" активна - " + isAuthButtonEnabledBeforeEnter);
        String enterValueEmail = faker.internet().emailAddress();
        String enterValuePassword = faker.internet().password();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        Log.debug("Вводим значения емейла - " + enterValueEmail + " и пароля - " + enterValuePassword);
        waiting(2);
        Boolean isAuthButtonEnabledAfterEnter = loginForm.isAuthButtonEnabled();
        Log.debug("Кнопка \"Войти\" активна - " + isAuthButtonEnabledAfterEnter);
        assertAll(
                "Проверка изменения кнопки \"Войти\" при вводе валидных данных",
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"Войти\" должна быть активна")
        );
        Log.info("---Завершение теста---");
    }
    @Test
    public void testValidEmailAndPasswordSubmit() {
        Log.info("Проверка нажатия на кнопку \"Войти\" при вводе валидных данных");
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = loginForm.isAuthErrorDivNotDisplayed();
        Log.debug("Блок \"Неправильный логин или пароль\" активен - " + isAuthErrorDivIsNotDisplayedBeforeEnter);
        String enterValueEmail = faker.internet().emailAddress();
        String enterValuePassword = faker.internet().password();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        Log.debug("Вводим значения емейла - " + enterValueEmail + " и пароля - " + enterValuePassword);
        loginForm.clickAuthButton();
        waiting(2);
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = loginForm.isAuthErrorDivNotDisplayed();
        Log.debug("Блок \"Неправильный логин или пароль\" активен - " + isAuthErrorDivIsNotDisplayedAfterEnter);
        assertAll(
                "Проверка нажатия на кнопку \"Войти\" при вводе валидных данных",
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Неправильный логин или пароль\" не должна отображаться"),
                () -> assertEquals("Неправильный логин или пароль", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Неправильный логин или пароль\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Неправильный логин или пароль\" должна была появиться")
        );
        Log.info("---Завершение теста---");
    }
}
