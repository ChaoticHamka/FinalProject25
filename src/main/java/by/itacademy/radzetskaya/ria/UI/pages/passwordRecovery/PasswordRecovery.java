package by.itacademy.radzetskaya.ria.UI.pages.passwordRecovery;

import by.itacademy.radzetskaya.ria.UI.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;

public class PasswordRecovery extends MainPage {

    public void clickOnPasswordRecoveryText() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.DIV_TO_RECOVERY_PASSWORD_FORM_BYXPATH.getLocator());
        LogUI.testActions("клик на текст восстановления пароля");
    }

    public void clickBack() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.DIV_TO_AUTH_FORM_BYXPATH.getLocator());
        LogUI.testActions("Возвращение на форму авторизации");
    }

    public void clickOnGetAccessToAccount() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.A_TO_RECOVERY_PASSWORD_FORM_BYXPATH.getLocator());
        LogUI.testActions("клик на получение доступа к аккаунту");
    }

    public Boolean isPasswordRecoveryFormNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_RECOVERY_PASSWORD_FORM_BYID.getLocator());
    }

    public Boolean isAuthFormNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(PasswordRecoveryLocators.DIV_AUTH_FORM_BYID.getLocator());
    }

    public void clickOnEmailLabel() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.LABEL_EMAIL_BYXPATH.getLocator());
        LogUI.testActions("клик на email");
    }

    public Boolean isEmailLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(PasswordRecoveryLocators.LABEL_EMAIL_BYXPATH.getLocator(), class_);
    }

    public void setEmailField(String value) {
        Driver.setValueTextFieldById(PasswordRecoveryLocators.INPUT_EMAIL_BYID.getLocator(), value);
        LogUI.setValueEmail(value);
    }

    public void clickPasswordRecoveryButton() {
        Driver.clickButtonByXpath(PasswordRecoveryLocators.BUTTON_RECOVERY_PASSWORD_SUBMIT_BYXPATH.getLocator());
        LogUI.testActions("клик на кнопку авторизации");
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
