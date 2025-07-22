package by.itacademy.radzetskaya.ria.ui;

import by.itacademy.radzetskaya.ria.ui.pages.passwordRecovery.TestPasswordRecoveryUtils;
import by.itacademy.radzetskaya.ria.ui.utils.DefaultValues;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordRecovery extends TestPasswordRecoveryUtils {

    @Test
    public void testOpenRecoveryFormByClickOnPasswordRecoveryText() {
        String heading = "Проверка открытия формы восстановления пароля после нажатия на текст \"Восстановить пароль\"";
        LogUi.startTest(heading);
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryFormNotDisplayedAfter = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedAfter = isAuthFormNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isPasswordRecoveryFormNotDisplayedBefore, "Сначала форма восстановления пароля не должна отображаться"),
                () -> assertFalse(isAuthFormNotDisplayedBefore, "Сначала форма авторизации должна отображаться"),
                () -> assertFalse(isPasswordRecoveryFormNotDisplayedAfter, "Форма восстановления пароля должна была открыться"),
                () -> assertTrue(isAuthFormNotDisplayedAfter, "Форма авторизации должна была скрыться")
        );
    }

    @Test
    public void testOpenRecoveryFormByClickOnGetAccessToAccountText() {
        String heading = "Проверка открытия формы восстановления пароля после нажатия на \"Получить доступ к аккаунту\"";
        LogUi.startTest(heading);
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickOnGetAccessToAccount();
        Boolean isPasswordRecoveryFormNotDisplayedAfter = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedAfter = isAuthFormNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isPasswordRecoveryFormNotDisplayedBefore, "Сначала форма восстановления пароля не должна отображаться"),
                () -> assertFalse(isAuthFormNotDisplayedBefore, "Сначала форма авторизации должна отображаться"),
                () -> assertFalse(isPasswordRecoveryFormNotDisplayedAfter, "Форма восстановления пароля должна была открыться"),
                () -> assertTrue(isAuthFormNotDisplayedAfter, "Форма авторизации должна была скрыться")
        );
    }

    @Test
    public void testOpenRecoveryFormAndClickBack() {
        String heading = "Проверка открытия формы авторизации, если нажать \"Назад\"";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickBack();
        Boolean isPasswordRecoveryFormNotDisplayedAfter = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedAfter = isAuthFormNotDisplayed();
        assertAll(
                heading,
                () -> assertFalse(isPasswordRecoveryFormNotDisplayedBefore, "Сначала форма восстановления пароля должна отображаться"),
                () -> assertTrue(isAuthFormNotDisplayedBefore, "Сначала форма авторизации не должна отображаться"),
                () -> assertTrue(isPasswordRecoveryFormNotDisplayedAfter, "Форма восстановления пароля должна быть скрыта"),
                () -> assertFalse(isAuthFormNotDisplayedAfter, "Форма авторизации должна была открыться")
        );
    }

    @Test
    public void testEmailLabelChangeOnFocused() {
        String heading = "Проверка поведения поля email при клике на него";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        String classForCheck = DefaultValues.CSS_CLASS_ON_FOCUSED;
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        passwordRecovery.clickOnEmailLabel();
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля email нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        String heading = "Проверка поля email на Invalid если ввести логин";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        String classForCheck = DefaultValues.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = getRandomUserName();
        passwordRecovery.setEmailField(enterValue);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testButtonDisplayOnInvalidField() {
        String heading = "Проверка исчезновения кнопки \"" + DefaultValues.VALUE_RECOVERY_PASSWORD_BUTTON + "\" и появления блока \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\"";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryDivIsNotDisplayedBeforeEnter = isPasswordRecoveryDivNotDisplayed();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter = isPasswordRecoveryErrorDivNotDisplayed();
        passwordRecovery.setEmailField(getRandomInvalidEmail());
        Boolean isPasswordRecoveryDivIsNotDisplayedAfterEnter = isPasswordRecoveryDivNotDisplayed();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter = isPasswordRecoveryErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertFalse(isPasswordRecoveryDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_RECOVERY_PASSWORD_BUTTON + "\" должна показываться"),
                () -> assertTrue(isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\" не должна отображаться"),
                () -> assertTrue(isPasswordRecoveryDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_RECOVERY_PASSWORD_BUTTON + "\" должна была пропасть"),
                () -> assertEquals(DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV, passwordRecovery.getPasswordRecoveryErrorDivText(), "Текст блока должен быть \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\""),
                () -> assertFalse(isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_ERROR_DIV + "\" должна была появиться")
        );
    }

    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = DefaultValues.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = DefaultValues.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        passwordRecovery.setEmailField(getRandomEmail());
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
    public void testValidEmailSubmit() {
        String heading = "Проверка нажатия на кнопку \"" + DefaultValues.VALUE_RECOVERY_PASSWORD_BUTTON + "\" при вводе валидных данных";
        LogUi.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter = isPasswordRecoveryErrorDivNotDisplayed();
        passwordRecovery.setEmailField(getRandomEmail());
        passwordRecovery.clickPasswordRecoveryButton();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter = isPasswordRecoveryErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" не должна отображаться"),
                () -> assertEquals(DefaultValues.VALUE_NOT_SUCH_USER_ERROR_DIV, passwordRecovery.getPasswordRecoveryErrorDivText(), "Текст блока должен быть \"" + DefaultValues.VALUE_NOT_SUCH_USER_ERROR_DIV + "\""),
                () -> assertFalse(isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + DefaultValues.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" должна была появиться")
        );
    }
}
