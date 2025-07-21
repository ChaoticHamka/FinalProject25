package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.pages.Login.TestLoginFormUtils;
import by.itacademy.radzetskaya.ria.UI.utils.Finals;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends TestLoginFormUtils {

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm() {
        String heading = "Проверка параметров веб-элементов при открытии формы логина в первый раз";
        LogUI.startTest(heading);
        assertAll(
                heading,
                () -> assertFalse(isAuthButtonEnabled(), "Кнопка \"" + Finals.VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertEquals(Finals.VALUE_AUTH_BUTTON, loginForm.getAuthButtonText(), "Текст кнопки должен быть \"" + Finals.VALUE_AUTH_BUTTON + "\"")
        );
    }

    //проверяем, что поля email и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused() {
        String heading = "Проверка поведения поля email при клике на него";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля email нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testPasswordLabelChangeOnFocused() {
        String heading = "Проверка поведения поля пароля при клике на него";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поля email и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        String heading = "Проверка поля email на Invalid";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmptyPasswordLabelChangeOnInvalid() {
        String heading = "Проверка поля пароля на Invalid";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля пароля не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    //проверяем, что поле email имеет класс Invalid, если в него введено что-то кроме email
    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        String heading = "Проверка поля email на Invalid если ввести число";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerInt();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmailLabelChangeOnInvalidFullName() {
        String heading = "Проверка поля email на Invalid если ввести имя и фамилию";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerFullName();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        String heading = "Проверка поля email на Invalid если ввести логин";
        LogUI.startTest(heading);
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerUserName();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    //проверка исчезновения кнопки "Войти" и появления блока "Проверьте email"
    @Test
    public void testButtonDisplayOnInvalidField() {
        String heading = "Проверка исчезновения кнопки \"" + Finals.VALUE_AUTH_BUTTON + "\" и появления блока \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\"";
        LogUI.startTest(heading);
        Boolean isAuthDivIsNotDisplayedBeforeEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValue = fakerEmail().replace("@", "");
        loginForm.setEmailField(enterValue);
        Boolean isAuthDivIsNotDisplayedAfterEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_AUTH_BUTTON + "\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_AUTH_BUTTON + "\" должна была пропасть"),
                () -> assertEquals(Finals.VALUE_CHECK_EMAIL_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\" должна была появиться")
        );
    }

    //в пароле что-то есть классы - m-notempty m-valid
    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = Finals.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = Finals.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести";
        LogUI.startTest(heading);
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnPasswordLabel(classForCheckValid);
        String enterValue = fakerPassword();
        loginForm.setPasswordField(enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = checkClassOnPasswordLabel(classForCheckValid);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля пароля не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля пароля должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля пароля должен был появиться класс " + classForCheckValid)
        );
    }

    //верный email - m-notempty m-valid
    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = Finals.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = Finals.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email";
        LogUI.startTest(heading);
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        String enterValue = fakerEmail();
        loginForm.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = checkClassOnEmailLabel(classForCheckValid);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля email должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля email должен был появиться класс " + classForCheckValid)
        );
    }

    //верный email и есть пароль
    @Test
    public void testValidEmailAndPassword() {
        String heading = "Проверка изменения кнопки \"" + Finals.VALUE_AUTH_BUTTON + "\" при вводе валидных данных";
        LogUI.startTest(heading);
        Boolean isAuthButtonEnabledBeforeEnter = isAuthButtonEnabled();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        waiting(2);
        Boolean isAuthButtonEnabledAfterEnter = isAuthButtonEnabled();
        assertAll(
                heading,
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"" + Finals.VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"" + Finals.VALUE_AUTH_BUTTON + "\" должна быть активна")
        );
    }

    @Test
    public void testValidEmailAndPasswordSubmit() {
        String heading = "Проверка нажатия на кнопку \"" + Finals.VALUE_AUTH_BUTTON + "\" при вводе валидных данных";
        LogUI.startTest(heading);
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        loginForm.clickAuthButton();
        waiting(3);
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" не должна отображаться"),
                () -> assertEquals(Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" должна была появиться")
        );

    }

    @Test
    public void testCloseAndOpenAuthorisationForm() {
        String heading = "Проверка сохранения введенных данных при закрытии формы авторизации";
        LogUI.startTest(heading);
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        loginForm.clickCloseAuthorizationForm();
        loginForm.openAuthorizationForm();
        assertAll(
                heading,
                () -> assertEquals(enterValueEmail, loginForm.getEmailFieldValue(), "Email должен был остаться тем же"),
                () -> assertEquals(enterValuePassword, loginForm.getPasswordFieldValue(), "Пароль должен был остаться тем же")
        );
    }
}
