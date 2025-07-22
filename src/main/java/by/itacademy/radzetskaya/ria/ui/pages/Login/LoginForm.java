package by.itacademy.radzetskaya.ria.ui.pages.Login;

import by.itacademy.radzetskaya.ria.ui.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.ui.utils.Driver;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;

public class LoginForm extends MainPage {

    public String getAuthButtonText() {
        return Driver.getTextByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
    }

    public void clickAuthButton() {
        Driver.clickButtonByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
        LogUi.testActions("клик на кнопку авторизации");
        waitSeconds(EXTRA_WAITING_IN_SECONDS);
    }

    public Boolean isAuthButtonEnabled() {
        return Driver.isWebElementEnabledByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
    }

    public Boolean isAuthDivNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(LoginFormLocators.DIV_AUTH_SUBMIT_BYID.getLocator());
    }

    public Boolean isAuthErrorDivNotDisplayed() {
        return Driver.isWebElementHasDisplayNoneById(LoginFormLocators.DIV_AUTH_ERROR_BYID.getLocator());
    }

    public String getAuthErrorDivText() {
        return Driver.getTextById(LoginFormLocators.DIV_AUTH_ERROR_BYID.getLocator());
    }

    public void clickOnEmailLabel() {
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator());
        LogUi.testActions("клик на email");
    }

    public Boolean isEmailLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator(), class_);
    }

    public void setEmailField(String value) {
        Driver.setValueTextFieldById(LoginFormLocators.INPUT_EMAIL_BYID.getLocator(), value);
        LogUi.setValueEmail(value);
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public String getEmailFieldValue() {
        String fieldValue = Driver.getValueById(LoginFormLocators.INPUT_EMAIL_BYID.getLocator());
        LogUi.valueInfo("email", fieldValue);
        return fieldValue;
    }

    public void clickOnPasswordLabel() {
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator());
        LogUi.testActions("клик на пароль");
    }

    public Boolean isPasswordLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator(), class_);
    }

    public void setPasswordField(String value) {
        Driver.setValueTextFieldById(LoginFormLocators.INPUT_PASSWORD_BYID.getLocator(), value);
        LogUi.setValuePassword(value);
        waitSeconds(DEFAULT_WAITING_IN_SECONDS);
    }

    public String getPasswordFieldValue() {
        String fieldValue = Driver.getValueById(LoginFormLocators.INPUT_PASSWORD_BYID.getLocator());
        LogUi.valueInfo("пароля", fieldValue);
        return fieldValue;
    }

    public void clickCloseAuthorizationForm() {
        Driver.clickButtonByClass(LoginFormLocators.DIV_AUTH_CLOSE_BUTTON_BYCLASS.getLocator());
        LogUi.testActions("закрытие формы авторизации");
    }
}
