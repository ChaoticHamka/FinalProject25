package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.utils.Log;
import by.itacademy.radzetskaya.ria.UI.pages.Login.TestLoginFormUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginForm extends TestLoginFormUtils {

    //при открытии формы логина кнопка "Войти" неактивна, текст = "Войти"
    @Test
    public void testOpenLoginForm() {
        Log.startTest("Проверка параметров веб-элементов при открытии формы логина в первый раз");
        assertAll(
                "Проверка параметров веб-элементов при открытии формы логина в первый раз",
                () -> assertFalse(isAuthButtonEnabled(), "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertEquals("Войти", loginForm.getAuthButtonText(), "Текст кнопки должен быть \"Войти\"")
        );
        Log.endTest();
    }

    //проверяем, что поля емейла и пароля меняются при клике на них (OnFocused)
    @Test
    public void testEmailLabelChangeOnFocused() {
        Log.startTest("Проверка поведения поля емейла при клике на него");
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        Log.testActions("клик на емейл");
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поведения поля емейла при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля Емейла нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }
    @Test
    public void testPasswordLabelChangeOnFocused() {
        Log.startTest("Проверка поведения поля пароля при клике на него");
        String classForCheck = "m-focused";
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        Log.testActions("клик на пароль");
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                "Проверка поведения поля пароля при клике на него",
                () -> assertFalse(isLabelHasClassBeforeClick, "По умолчанию у поля пароля нет класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }

    //проверяем, что поля емейла и пароля меняются при изменении фокуса на другое поле при пустом поле (Invalid)
    @Test
    public void testEmptyEmailLabelChangeOnInvalid() {
        Log.startTest("Проверка лейбла емейла на Invalid");
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = checkClassOnEmailLabel(classForCheck);
        loginForm.clickOnEmailLabel();
        loginForm.clickOnPasswordLabel();
        Log.testActions("клик на емейл, клик на пароль");
        Boolean isLabelHasClassAfterClick = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка лейбла емейла на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }
    @Test
    public void testEmptyPasswordLabelChangeOnInvalid() {
        Log.startTest("Проверка лейбла пароля на Invalid");
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeClick = checkClassOnPasswordLabel(classForCheck);
        loginForm.clickOnPasswordLabel();
        loginForm.clickOnEmailLabel();
        Log.testActions("клик на пароль, клик на емейл");
        Boolean isLabelHasClassAfterClick = checkClassOnPasswordLabel(classForCheck);
        assertAll(
                "Проверка поля пароля на Invalid",
                () -> assertFalse(isLabelHasClassBeforeClick, "Сначала у поля пароля не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterClick, "У поля пароль должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }

    //проверяем, что поле емейла имеет класс Invalid, если в него введено что-то кроме емейла
    @Test
    public void testEmailLabelChangeOnInvalidNumber() {
        Log.startTest("Проверка поля емейла на Invalid если ввести число");
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerInt();
        loginForm.setEmailField(enterValue);
        Log.setValue(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести число",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }
    @Test
    public void testEmailLabelChangeOnInvalidFullName() {
        Log.startTest("Проверка поля емейла на Invalid если ввести имя и фамилию");
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerFullName();
        loginForm.setEmailField(enterValue);
        Log.setValue(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести имя и фамилию",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }
    @Test
    public void testEmailLabelChangeOnInvalidLogin() {
        Log.startTest("Проверка поля емейла на Invalid если ввести логин");
        String classForCheck = "m-invalid";
        Boolean isLabelHasClassBeforeEnter = checkClassOnEmailLabel(classForCheck);
        String enterValue = fakerUserName();
        loginForm.setEmailField(enterValue);
        Log.setValue(enterValue);
        waiting(2);
        Boolean isLabelHasClassAfterEnter = checkClassOnEmailLabel(classForCheck);
        assertAll(
                "Проверка поля емейла на Invalid если ввести логин",
                () -> assertFalse(isLabelHasClassBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheck),
                () -> assertTrue(isLabelHasClassAfterEnter, "У поля Емейла должен был появиться класс " + classForCheck)
        );
        Log.endTest();
    }

    //проверка исчезновения кнопки "Войти" и появления блока "Проверьте емейл"
    @Test
    public void testButtonDisplayOnInvalidField() {
        Log.startTest("Проверка исчезновения кнопки \"Войти\" и появления блока \"Проверьте емейл\"");
        Boolean isAuthDivIsNotDisplayedBeforeEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValue = fakerEmail().replace("@", "");
        loginForm.setEmailField(enterValue);
        Log.setValue(enterValue);
        Boolean isAuthDivIsNotDisplayedAfterEnter = isAuthDivNotDisplayed();
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка поведения блоков Div если ввести почти емейл",
                () -> assertFalse(isAuthDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Войти\" должна показываться"),
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Проверьте адрес почты\" не должна отображаться"),
                () -> assertTrue(isAuthDivIsNotDisplayedAfterEnter, "Кнопка \"Войти\" должна была пропасть"),
                () -> assertEquals("Проверьте адрес почты", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Проверьте адрес почты\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Проверьте адрес почты\" должна была появиться")
        );
        Log.endTest();
    }

    //в пароле что-то есть классы - m-notempty m-valid
    @Test
    public void testPasswordLabelChangeOnNotEmptyField() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Log.startTest("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него что-нибудь ввести");
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnPasswordLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnPasswordLabel(classForCheckValid);
        String enterValue = fakerPassword();
        loginForm.setPasswordField(enterValue);
        Log.setValue(enterValue);
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
        Log.endTest();
    }

    //верный емейл - m-notempty m-valid
    @Test
    public void testEmailLabelChangeOnValidEmail() {
        String classForCheckNotEmpty = "m-notempty";
        String classForCheckValid = "m-valid";
        Log.startTest("Проверка поля пароля на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный емейл");
        Boolean isLabelHasClassNotEmptyBeforeEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidBeforeEnter = checkClassOnEmailLabel(classForCheckValid);
        String enterValue = fakerEmail();
        loginForm.setEmailField(enterValue);
        Log.setValue(enterValue);
        waiting(2);
        Boolean isLabelHasClassNotEmptyAfterEnter = checkClassOnEmailLabel(classForCheckNotEmpty);
        Boolean isLabelHasClassValidAfterEnter = checkClassOnEmailLabel(classForCheckValid);
        assertAll(
                "Проверка поля емейла на классы " + classForCheckNotEmpty + " и " + classForCheckValid + ", если в него ввести валидный емейл",
                () -> assertFalse(isLabelHasClassNotEmptyBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckNotEmpty),
                () -> assertFalse(isLabelHasClassValidBeforeEnter, "Сначала у поля емейла не должно быть класса " + classForCheckValid),
                () -> assertTrue(isLabelHasClassNotEmptyAfterEnter, "У поля емейла должен был появиться класс " + classForCheckNotEmpty),
                () -> assertTrue(isLabelHasClassValidAfterEnter, "У поля емейла должен был появиться класс " + classForCheckValid)
        );
        Log.endTest();
    }

    //верный емейл и есть пароль
    @Test
    public void testValidEmailAndPassword() {
        Log.startTest("Проверка изменения кнопки \"Войти\" при вводе валидных данных");
        Boolean isAuthButtonEnabledBeforeEnter = isAuthButtonEnabled();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        Log.setEmailAndPassword(enterValueEmail, enterValuePassword);
        waiting(2);
        Boolean isAuthButtonEnabledAfterEnter = isAuthButtonEnabled();
        assertAll(
                "Проверка изменения кнопки \"Войти\" при вводе валидных данных",
                () -> assertFalse(isAuthButtonEnabledBeforeEnter, "Кнопка \"Войти\" должна быть неактивна"),
                () -> assertTrue(isAuthButtonEnabledAfterEnter, "После ввода валидных данных кнопка \"Войти\" должна быть активна")
        );
        Log.endTest();
    }
    @Test
    public void testValidEmailAndPasswordSubmit() {
        Log.startTest("Проверка нажатия на кнопку \"Войти\" при вводе валидных данных");
        Boolean isAuthErrorDivIsNotDisplayedBeforeEnter = isAuthErrorDivNotDisplayed();
        String enterValueEmail = fakerEmail();
        String enterValuePassword = fakerPassword();
        loginForm.setEmailField(enterValueEmail);
        loginForm.setPasswordField(enterValuePassword);
        Log.setEmailAndPassword(enterValueEmail, enterValuePassword);
        loginForm.clickAuthButton();
        Log.testActions("клик по кнопке \"Войти\"");
        waiting(3);
        Boolean isAuthErrorDivIsNotDisplayedAfterEnter = isAuthErrorDivNotDisplayed();
        assertAll(
                "Проверка нажатия на кнопку \"Войти\" при вводе валидных данных",
                () -> assertTrue(isAuthErrorDivIsNotDisplayedBeforeEnter, "Сначала кнопка \"Неправильный логин или пароль\" не должна отображаться"),
                () -> assertEquals("Неправильный логин или пароль", loginForm.getAuthErrorDivText(), "Текст блока должен быть \"Неправильный логин или пароль\""),
                () -> assertFalse(isAuthErrorDivIsNotDisplayedAfterEnter, "Кнопка \"Неправильный логин или пароль\" должна была появиться")
        );
        Log.endTest();
    }
}
