package by.itacademy.radzetskaya.ria.UI.pages.Main;

import by.itacademy.radzetskaya.ria.UI.BaseUI;
import by.itacademy.radzetskaya.ria.UI.pages.Login.LoginFormLocators;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;

public class MainPage extends BaseUI {

    private final String LINK_TO_MAIN_PAGE = "https://ria.ru";

    public void openMainPage(){
        driver.get(LINK_TO_MAIN_PAGE);
    }

    //открыть форму авторизации
    public void openAuthorizationForm(){
        Driver.clickButtonByClass(LoginFormLocators.BUTTON_TO_LOGIN_FORM_BYCLASS.getLocator());
    }
}
