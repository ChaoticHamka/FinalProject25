package by.itacademy.radzetskaya.ria.UI.pages.passwordRecovery;

import by.itacademy.radzetskaya.ria.UI.utils.Base.BaseTest;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.BeforeEach;

public class TestPasswordRecoveryUtils extends BaseTest {

    protected PasswordRecovery passwordRecovery;

    @BeforeEach
    public void openLoginForm() {
        passwordRecovery = new PasswordRecovery();
        passwordRecovery.openAuthorizationForm();
    }

    protected Boolean isPasswordRecoveryFormNotDisplayed() {
        Boolean isFormDisplayed = passwordRecovery.isPasswordRecoveryFormNotDisplayed();
        LogUI.valueInfo("Форма восстановления пароля скрыта - ", isFormDisplayed);
        return isFormDisplayed;
    }

    protected Boolean isAuthFormNotDisplayed() {
        Boolean isFormDisplayed = passwordRecovery.isAuthFormNotDisplayed();
        LogUI.valueInfo("Форма авторизации скрыта - ", isFormDisplayed);
        return isFormDisplayed;
    }

    protected Boolean checkClassOnEmailLabel(String classForCheck) {
        LogUI.actionsInfoCheckClass(classForCheck, " у поля email");
        Boolean isElementHasClass = passwordRecovery.isEmailLabelContainClass(classForCheck);
        LogUI.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isPasswordRecoveryDivNotDisplayed() {
        Boolean isElementDisplayed = passwordRecovery.isPasswordRecoveryDivNotDisplayed();
        LogUI.valueInfo("Блок продолжить скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isPasswordRecoveryErrorDivNotDisplayed() {
        Boolean isElementDisplayed = passwordRecovery.isPasswordRecoveryErrorDivNotDisplayed();
        LogUI.valueInfo("Блок \"Проверьте email\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

}
