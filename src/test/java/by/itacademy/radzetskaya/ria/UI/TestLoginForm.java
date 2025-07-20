package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import by.itacademy.radzetskaya.ria.UI.pages.Login.TestLoginFormUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends TestLoginFormUtils {

    private final String CSS_CLASS_ON_FOCUSED = "m-focused";
    private final String CSS_CLASS_INVALID = "m-invalid";
    private final String CSS_CLASS_NOT_EMPTY = "m-notempty";
    private final String CSS_CLASS_VALID = "m-valid";
    private final String VALUE_AUTH_BUTTON = "Войти";
    private final String VALUE_CHECK_EMAIL_ERROR_DIV = "Проверьте адрес почты";
    private final String VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV = "Неправильный логин или пароль";

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm() {
        LogUI.startTest("Проверка параметров веб-элементов при открытии формы логина в первый раз");
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(isAuthButtonEnabled(), "Кнопка \"" + VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertEquals(VALUE_AUTH_BUTTON, loginForm.getAuthButtonText(), "Текст кнопки должен быть \"" + VALUE_AUTH_BUTTON + "\"")
        );
    }

    //проверяем, что поля email и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused() {
        LogUI.startTest("Проверка поведения поля email при клике на него");
        String classForCheck = CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поведения поля email при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля email нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testPasswordLabelChangeOnFocused() {
        LogUI.startTest("Проверка поведения поля пароля при клике на него");
        String classForCheck = CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поля email и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        LogUI.startTest("Проверка поля email на Invalid");
        String classForCheck = CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля email на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmptyPasswordLabelChangeOnInvalid() {
        LogUI.startTest("Проверка поля пароля на Invalid");
        String classForCheck = CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля пароля не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поле email имеет класс Invalid, если в него введено что-то кроме email
    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        LogUI.startTest("Проверка поля email на Invalid если ввести число");
        String classForCheck = CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerInt();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля email на Invalid если ввести число",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmailLabelChangeOnInvalidFullName() {
        LogUI.startTest("Проверка поля email на Invalid если ввести имя и фамилию");
        String classForCheck = CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerFullName();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля email на Invalid если ввести имя и фамилию",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        LogUI.startTest("Проверка поля email на Invalid если ввести логин");
        String classForCheck = CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerUserName();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля email на Invalid если ввести логин",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    //проверка исчезновения кнопки "Войти" и появления блока "Проверьте email"
    @Test
    public void testButtonDisplayOnInvalidField() {
        LogUI.startTest("Проверка исчезновения кнопки \"" + VALUE_AUTH_BUTTON + "\" и появления блока \"" + VALUE_CHECK_EMAIL_ERROR_DIV + "\"");
        Boolean isAuthDivIsNotDisplayedBeforeEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValue = fakerEmail().replace("@", "");
        loginForm.setEmailField(enterValue);
        Boolean isAuthDivIsNotDisplayedAfterEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка исчезновения кнопки \"" + VALUE_AUTH_BUTTON + "\" и появления блока \"" + VALUE_CHECK_EMAIL_ERROR_DIV + "\"",
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + VALUE_AUTH_BUTTON + "\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + VALUE_CHECK_EMAIL_ERROR_DIV + "\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"" + VALUE_AUTH_BUTTON + "\" должна была пропасть"),
                () -> assertEquals(VALUE_CHECK_EMAIL_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + VALUE_CHECK_EMAIL_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + VALUE_CHECK_EMAIL_ERROR_DIV + "\" должна была появиться")
        );
    }

    //в пароле что-то есть классы - m-notempty m-valid
    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = CSS_CLASS_VALID;
        LogUI.startTest("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести");
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnPasswordLabel(classForCheckValid);
        String enterValue = fakerPassword();
        loginForm.setPasswordField(enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = checkClassOnPasswordLabel(classForCheckValid);
        assertAll(
                "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля пароля должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля пароля должен был появиться класс " + classForCheckValid)
        );
    }

    //верный email - m-notempty m-valid
    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = CSS_CLASS_VALID;
        LogUI.startTest("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email");
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        String enterValue = fakerEmail();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = checkClassOnEmailLabel(classForCheckValid);
        assertAll(
                "Проверка поля email на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля email должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля email должен был появиться класс " + classForCheckValid)
        );
    }

    //верный email и есть пароль
    @Test
    public void testValidEmailAndPassword() {
        LogUI.startTest("Проверка изменения кнопки \"" + VALUE_AUTH_BUTTON + "\" при вводе валидных данных");
        Boolean isAuthButtonEnabledBeforeEnter = isAuthButtonEnabled();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        waiting(2);
        Boolean isAuthButtonEnabledAfterEnter = isAuthButtonEnabled();
        assertAll(
                "Проверка изменения кнопки \"" + VALUE_AUTH_BUTTON + "\" при вводе валидных данных",
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"" + VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"" + VALUE_AUTH_BUTTON + "\" должна быть активна")
        );
    }

    @Test
    public void testValidEmailAndPasswordSubmit() {
        LogUI.startTest("Проверка нажатия на кнопку \"" + VALUE_AUTH_BUTTON + "\" при вводе валидных данных");
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        loginForm.clickAuthButton();
        waiting(3);
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка нажатия на кнопку \"" + VALUE_AUTH_BUTTON + "\" при вводе валидных данных",
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" не должна отображаться"),
                () -> assertEquals(VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" должна была появиться")
        );

    }
}
