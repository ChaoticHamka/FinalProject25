package by.itacademy.radzetskaya.ria.ui.pages.passwordRecovery;

import by.itacademy.radzetskaya.ria.ui.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.ui.utils.Driver;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;

public class PasswordRecovery extends MainPage {

    public void clickOnPasswordRecoveryText() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.DIV_TO_RECOVERY_PASSWORD_FORM_BYXPATH.getLocator());
        LogUi.testActions("клик на текст восстановления пароля");
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public void clickBack() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.DIV_TO_AUTH_FORM_BYXPATH.getLocator());
        LogUi.testActions("возвращение на форму авторизации");
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public void clickOnGetAccessToAccount() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.A_TO_RECOVERY_PASSWORD_FORM_BYXPATH.getLocator());
        LogUi.testActions("клик на получение доступа к аккаунту");
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public Boolean isPasswordRecoveryFormNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_RECOVERY_PASSWORD_FORM_BYID.getLocator());
    }

    public Boolean isAuthFormNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_AUTH_FORM_BYID.getLocator());
    }

    public void clickOnEmailLabel() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.LABEL_EMAIL_BYXPATH.getLocator());
        LogUi.testActions("клик на email");
    }

    public Boolean isEmailLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(PasswordRecoveryLocators.LABEL_EMAIL_BYXPATH.getLocator(), class_);
    }

    public void setEmailField(String value) {
        Driver.setValueTextFieldById(PasswordRecoveryLocators.INPUT_EMAIL_BYID.getLocator(), value);
        LogUi.setValueEmail(value);
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public void clickPasswordRecoveryButton() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.BUTTON_RECOVERY_PASSWORD_SUBMIT_BYXPATH.getLocator());
        LogUi.testActions("клик на кнопку авторизации");
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public Boolean isPasswordRecoveryDivNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_RECOVERY_PASSWORD_SUBMIT_BYID.getLocator());
    }

    public Boolean isPasswordRecoveryErrorDivNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_RECOVERY_PASSWORD_ERROR_BYID.getLocator());
    }

    public String getPasswordRecoveryErrorDivText() {
        return Driver.getTextById(PasswordRecoveryLocators.DIV_RECOVERY_PASSWORD_ERROR_BYID.getLocator());
    }

}
