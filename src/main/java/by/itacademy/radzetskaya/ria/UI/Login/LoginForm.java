package by.itacademy.radzetskaya.ria.UI.Login;

import by.itacademy.radzetskaya.ria.UI.BaseUI;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;

public class LoginForm extends BaseUI {

    public LoginForm() {
        this.driver = Driver.getDriver();
    }

    //открыть форму авторизации
    public void openAuthorizationForm(){
        Driver.clickButtonByClass(LoginFormLocators.BUTTON_TO_LOGIN_FORM_BYCLASS.getLocator());
    }

    //кнопка "Войти"
    public String getAuthButtonText(){
        return Driver.getTextByIdByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
    }
    public Boolean isAuthButtonEnabled(){
        return Driver.isWebElementEnabledByXpath(LoginFormLocators.BUTTON_AUTH_SUBMIT_BYXPATH.getLocator());
    }

    //Поле Email
    public void clickOnEmailLabel(){
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator());
    }
    public Boolean isEmailLabelContainClass(String class_){
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_EMAIL_BYXPATH.getLocator(), class_);
    }

    //Поле Пароль
    public void clickOnPasswordLabel(){
        Driver.clickButtonByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator());
    }
    public Boolean isPasswordLabelContainClass(String class_){
        return Driver.isWebElementContainClassByXpath(LoginFormLocators.LABEL_PASSWORD_BYXPATH.getLocator(), class_);
    }

}
