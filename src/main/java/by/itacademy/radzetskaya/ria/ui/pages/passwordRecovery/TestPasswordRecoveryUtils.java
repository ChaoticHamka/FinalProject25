package by.itacademy.radzetskaya.ria.ui.pages.passwordRecovery;

import by.itacademy.radzetskaya.ria.ui.utils.Base.BaseTest;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
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
        LogUi.valueInfo("Форма восстановления пароля скрыта - ", isFormDisplayed);
        return isFormDisplayed;
    }

    protected Boolean isAuthFormNotDisplayed() {
        Boolean isFormDisplayed = passwordRecovery.isAuthFormNotDisplayed();
        LogUi.valueInfo("Форма авторизации скрыта - ", isFormDisplayed);
        return isFormDisplayed;
    }

    protected Boolean checkClassOnEmailLabel(String classForCheck) {
        LogUi.actionsInfoCheckClass(classForCheck, " у поля email");
        Boolean isElementHasClass = passwordRecovery.isEmailLabelContainClass(classForCheck);
        LogUi.valueInfo(isElementHasClass);
        return isElementHasClass;
    }

    protected Boolean isPasswordRecoveryDivNotDisplayed() {
        Boolean isElementDisplayed = passwordRecovery.isPasswordRecoveryDivNotDisplayed();
        LogUi.valueInfo("Блок продолжить скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

    protected Boolean isPasswordRecoveryErrorDivNotDisplayed() {
        Boolean isElementDisplayed = passwordRecovery.isPasswordRecoveryErrorDivNotDisplayed();
        LogUi.valueInfo("Блок \"Проверьте email\" скрыт - ", isElementDisplayed);
        return isElementDisplayed;
    }

}
