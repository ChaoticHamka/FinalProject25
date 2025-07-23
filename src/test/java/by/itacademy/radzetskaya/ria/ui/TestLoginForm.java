package by.itacademy.radzetskaya.ria.ui;

import by.itacademy.radzetskaya.ria.ui.pages.Login.TestLoginFormUtils;
import by.itacademy.radzetskaya.ria.ui.utils.DefaultValues;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends TestLoginFormUtils {

    @Test
    public void testOpenLoginForm() {
        String heading = "Проверка параметров веб-элементов при открытии формы логина в первый раз";
        LogUi.startTest(heading);
        assertAll(
                heading,
                () -> assertFalse(isAuthButtonEnabled(), "Кнопка \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertEquals(DefaultValues.VALUE_AUTH_BUTTON, loginForm.getAuthButtonText(), "Текст кнопки должен быть \"" + DefaultValues.VALUE_AUTH_BUTTON + "\"")
        );
    }

    @Test
    public void testEmailLabelChangeOnFocused() {
        String heading = "Проверка поведения поля email при клике на него";
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_ON_FOCUSED;
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
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        String heading = "Проверка поля email на Invalid";
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
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
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
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

    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        String heading = "Проверка поля email на Invalid если ввести число";
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        loginForm.setEmailField(getRandomInt());
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
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        loginForm.setEmailField(getRandomFullName());
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
        LogUi.startTest(heading);
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        loginForm.setEmailField(getRandomUserName());
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testButtonDisplayOnInvalidField() {
        String heading = "Проверка исчезновения кнопки \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" и появления блока \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\"";
        LogUi.startTest(heading);
        Boolean isAuthDivIsNotDisplayedBeforeEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        loginForm.setEmailField(getRandomInvalidEmail());
        Boolean isAuthDivIsNotDisplayedAfterEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" должна была пропасть"),
                () -> assertEquals(DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\" должна была появиться")
        );
    }

    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = DefaultValues.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = DefaultValues.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести";
        LogUi.startTest(heading);
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnPasswordLabel(classForCheckValid);
        loginForm.setPasswordField(getRandomPassword());
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

    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = DefaultValues.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = DefaultValues.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email";
        LogUi.startTest(heading);
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        loginForm.setEmailField(getRandomEmail());
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

    @Test
    public void testValidEmailAndPassword() {
        String heading = "Проверка изменения кнопки \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" при вводе валидных данных";
        LogUi.startTest(heading);
        Boolean isAuthButtonEnabledBeforeEnter = isAuthButtonEnabled();
        loginForm.setEmailField(getRandomEmail());
        loginForm.setPasswordField(getRandomPassword());
        Boolean isAuthButtonEnabledAfterEnter = isAuthButtonEnabled();
        assertAll(
                heading,
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" должна быть активна")
        );
    }

    @Test
    public void testValidEmailAndPasswordSubmit() {
        String heading = "Проверка нажатия на кнопку \"" + DefaultValues.VALUE_AUTH_BUTTON + "\" при вводе валидных данных";
        LogUi.startTest(heading);
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        loginForm.setEmailField(getRandomEmail());
        loginForm.setPasswordField(getRandomPassword());
        loginForm.clickAuthButton();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" не должна отображаться"),
                () -> assertEquals(DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV, loginForm.getAuthErrorDivText(), "Текст блока должен быть \"" + DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" должна была появиться")
        );
    }

    @Test
    public void testCloseAndOpenAuthorisationForm() {
        String heading = "Проверка сохранения введенных данных при закрытии формы авторизации";
        LogUi.startTest(heading);
        String enterValueEmail = getRandomEmail();
        String enterValuePassword = getRandomPassword();
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
