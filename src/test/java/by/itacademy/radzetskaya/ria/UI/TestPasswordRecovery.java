package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.pages.passwordRecovery.TestPasswordRecoveryUtils;
import by.itacademy.radzetskaya.ria.UI.utils.Finals;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordRecovery extends TestPasswordRecoveryUtils {

    @Test
    public void testOpenRecoveryFormByClickOnPasswordRecoveryText() {
        String heading = "Проверка открытия формы восстановления пароля после нажатия на текст \"Восстановить пароль\"";
        LogUI.startTest(heading);
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickOnPasswordRecoveryText();
        waiting(2);
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
        LogUI.startTest(heading);
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickOnGetAccessToAccount();
        waiting(2);
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
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        waiting(2);
        Boolean isPasswordRecoveryFormNotDisplayedBefore = isPasswordRecoveryFormNotDisplayed();
        Boolean isAuthFormNotDisplayedBefore = isAuthFormNotDisplayed();
        passwordRecovery.clickBack();
        waiting(2);
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
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        String classForCheck = Finals.CSS_CLASS_ON_FOCUSED;
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
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        String classForCheck = Finals.CSS_CLASS_INVALID;
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerUserName();
        passwordRecovery.setEmailField(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                heading,
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля email не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля email должен был появиться класс " + classForCheck)
        );
    }

    @Test
    public void testButtonDisplayOnInvalidField() {
        String heading = "Проверка исчезновения кнопки \"" + Finals.VALUE_RECOVERY_PASSWORD_BUTTON + "\" и появления блока \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\"";
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryDivIsNotDisplayedBeforeEnter = isPasswordRecoveryDivNotDisplayed();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter = isPasswordRecoveryErrorDivNotDisplayed();
        String enterValue = fakerEmail().replace("@", "");
        passwordRecovery.setEmailField(enterValue);
        Boolean isPasswordRecoveryDivIsNotDisplayedAfterEnter = isPasswordRecoveryDivNotDisplayed();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter = isPasswordRecoveryErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertFalse(isPasswordRecoveryDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_RECOVERY_PASSWORD_BUTTON + "\" должна показываться"),
                () -> assertTrue(isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\" не должна отображаться"),
                () -> assertTrue(isPasswordRecoveryDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_RECOVERY_PASSWORD_BUTTON + "\" должна была пропасть"),
                () -> assertEquals(Finals.VALUE_CHECK_EMAIL_ERROR_DIV, passwordRecovery.getPasswordRecoveryErrorDivText(), "Текст блока должен быть \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\""),
                () -> assertFalse(isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_CHECK_EMAIL_ERROR_DIV + "\" должна была появиться")
        );
    }

    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = Finals.CSS_CLASS_NOT_EMPTY;
        String classForCheckValid = Finals.CSS_CLASS_VALID;
        String heading = "Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный email";
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        String enterValue = fakerEmail();
        passwordRecovery.setEmailField(enterValue);
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

    @Test
    public void testValidEmailSubmit() {
        String heading = "Проверка нажатия на кнопку \"" + Finals.VALUE_RECOVERY_PASSWORD_BUTTON + "\" при вводе валидных данных";
        LogUI.startTest(heading);
        passwordRecovery.clickOnPasswordRecoveryText();
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter = isPasswordRecoveryErrorDivNotDisplayed();
        String enterValueEmail = fakerEmail();
        passwordRecovery.setEmailField(enterValueEmail);
        passwordRecovery.clickPasswordRecoveryButton();
        waiting(3);
        Boolean isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter = isPasswordRecoveryErrorDivNotDisplayed();
        assertAll(
                heading,
                () -> assertTrue(isPasswordRecoveryErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"" + Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" не должна отображаться"),
                () -> assertEquals(Finals.VALUE_NOT_SUCH_USER_ERROR_DIV, passwordRecovery.getPasswordRecoveryErrorDivText(), "Текст блока должен быть \"" + Finals.VALUE_NOT_SUCH_USER_ERROR_DIV + "\""),
                () -> assertFalse(isPasswordRecoveryErrorDivIsNotDisplayedAfterEnter, "Кнопка \"" + Finals.VALUE_CHECK_EMAIL_OR_PASSWORD_ERROR_DIV + "\" должна была появиться")
        );
    }
}
