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
        LogUI.actionsInfoCheckClass(classForCheck, " у поля email");
        Boolean isElementHasClass = loginForm.isEmailLabelContainClass(classForCheck);
        LogUI.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean checkClassOnPasswordLabel(String classForCheck) {
        LogUI.actionsInfoCheckClass(classForCheck, " у поля пароля");
        Boolean isElementHasClass = loginForm.isPasswordLabelContainClass(classForCheck);
        LogUI.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isAuthDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthDivNotDisplayed();
        LogUI.valueInfo("Блок авторизации скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthErrorDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthErrorDivNotDisplayed();
        LogUI.valueInfo("Блок \"Проверьте email\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthButtonEnabled() {
        Boolean isElementEnabled = loginForm.isAuthButtonEnabled();
        LogUI.valueInfo("Кнопка авторизации активна - ", isElementEnabled);
        return isElementEnabled;
    }

}
