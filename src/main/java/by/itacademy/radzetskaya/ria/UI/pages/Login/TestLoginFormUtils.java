package by.itacademy.radzetskaya.ria.UI.pages.Login;

import by.itacademy.radzetskaya.ria.UI.utils.Log;
import by.itacademy.radzetskaya.ria.UI.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;

public class TestLoginFormUtils extends TestUtils {

    protected LoginForm loginForm;

    @BeforeEach
    public void openLoginForm() {
        loginForm = new LoginForm();
        loginForm.openAuthorizationForm();
    }

    protected Boolean checkClassOnEmailLabel(String classForCheck) {
        Log.actionsInfoCheckClass(classForCheck, " у лейбла емейла");
        Boolean isElementHasClass = loginForm.isEmailLabelContainClass(classForCheck);
        Log.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean checkClassOnPasswordLabel(String classForCheck) {
        Log.actionsInfoCheckClass(classForCheck, " у лейбла пароля");
        Boolean isElementHasClass = loginForm.isPasswordLabelContainClass(classForCheck);
        Log.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isAuthDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthDivNotDisplayed();
        Log.valueInfo("Блок \"Войти\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthErrorDivNotDisplayed() {
        Boolean isElementDisplayed = loginForm.isAuthErrorDivNotDisplayed();
        Log.valueInfo("Блок \"Проверьте емейл\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isAuthButtonEnabled() {
        Boolean isElementEnabled = loginForm.isAuthButtonEnabled();
        Log.valueInfo("Кнопка \"Войти\" активна - ", isElementEnabled);
        return isElementEnabled;
    }

}
