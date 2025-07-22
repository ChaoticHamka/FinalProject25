package by.itacademy.radzetskaya.ria.ui.pages.Login;

import by.itacademy.radzetskaya.ria.ui.utils.Base.BaseTest;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
import org.junit.jupiter.api.BeforeEach;

import java.util.PrimitiveIterator;

public class TestLoginFormUtils extends BaseTest {

    protected LoginForm loginForm;

    @BeforeEach
    public void openLoginForm() {
        loginForm = new LoginForm();
        loginForm.openAuthorizationForm();
    }

    private void logCheckClass(String classForCheck, String message, Boolean isElementHasClass) {
        LogUi.actionsInfoCheckClass(classForCheck, message);
        LogUi.valueInfo(isElementHasClass);
    }

    protected Boolean checkClassOnEmailLabel(String classForCheck) {
        Boolean isElementHasClass = loginForm.isEmailLabelContainClass(classForCheck);
        logCheckClass(classForCheck, " у поля email", isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean checkClassOnPasswordLabel(String classForCheck) {
        Boolean isElementHasClass = loginForm.isPasswordLabelContainClass(classForCheck);
        logCheckClass(classForCheck, " у поля пароля", isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isAuthDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthDivNotDisplayed();
        LogUi.valueInfo("Блок авторизации скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthErrorDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthErrorDivNotDisplayed();
        LogUi.valueInfo("Блок \"Проверьте email\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthButtonEnabled() {
        Boolean isElementEnabled = loginForm.isAuthButtonEnabled();
        LogUi.valueInfo("Кнопка авторизации активна - ", isElementEnabled);
        return isElementEnabled;
    }

}
