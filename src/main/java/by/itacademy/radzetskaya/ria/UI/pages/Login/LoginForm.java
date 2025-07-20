package by.itacademy.radzetskaya.ria.UI.pages.Login;

import by.itacademy.radzetskaya.ria.UI.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;

public class LoginForm extends MainPage {

    //кнопка "Войти"
    public String getAuthButtonText() {
        return Driver.getTextByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
    }
    public void clickAuthButton() {
        Driver.clickButtonByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
        LogUI.testActions("клик на кнопку авторизации");
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

    //Поле Email
    public void clickOnEmailLabel() {
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator());
        LogUI.testActions("клик на email");
    }
    public Boolean isEmailLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator(), class_);
    }
    public void setEmailField(String value) {
        Driver.setValueTextFieldById(LoginFormLocators.INPUT_EMAIL_BYID.getLocator(), value);
        LogUI.setValueEmail(value);
    }

    //Поле Пароль
    public void clickOnPasswordLabel() {
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator());
        LogUI.testActions("клик на пароль");
    }
    public Boolean isPasswordLabelContainClass(String class_) {
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator(), class_);
    }
    public void setPasswordField(String value) {
        Driver.setValueTextFieldById(LoginFormLocators.INPUT_PASSWORD_BYID.getLocator(), value);
        LogUI.setValuePassword(value);
    }

}
