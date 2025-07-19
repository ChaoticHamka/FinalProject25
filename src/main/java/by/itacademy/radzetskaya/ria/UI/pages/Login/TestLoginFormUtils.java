package by.itacademy.radzetskaya.ria.UI.pages.Login;

import by.itacademy.radzetskaya.ria.UI.utils.Base.BaseTest;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.BeforeEach;

public class TestLoginFormUtils extends BaseTest {

    protected LoginForm loginForm;

    @BeforeEach
    public void openLoginForm() {
        loginForm = new LoginForm();
        loginForm.openAuthorizationForm();
    }

    protected Boolean checkClassOnEmailLabel(String classForCheck) {
        LogUI.actionsInfoCheckClass(classForCheck, " у лейбла емейла");
        Boolean isElementHasClass = loginForm.isEmailLabelContainClass(classForCheck);
        LogUI.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean checkClassOnPasswordLabel(String classForCheck) {
        LogUI.actionsInfoCheckClass(classForCheck, " у лейбла пароля");
        Boolean isElementHasClass = loginForm.isPasswordLabelContainClass(classForCheck);
        LogUI.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isAuthDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthDivNotDisplayed();
        LogUI.valueInfo("Блок \"Войти\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthErrorDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthErrorDivNotDisplayed();
        LogUI.valueInfo("Блок \"Проверьте емейл\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthButtonEnabled() {
        Boolean isElementEnabled = loginForm.isAuthButtonEnabled();
        LogUI.valueInfo("Кнопка \"Войти\" активна - ", isElementEnabled);
        return isElementEnabled;
    }

}
