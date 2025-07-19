package by.itacademy.radzetskaya.ria.UI.pages.Main;

import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import by.itacademy.radzetskaya.ria.UI.utils.Base.BaseUI;
import by.itacademy.radzetskaya.ria.UI.pages.Login.LoginFormLocators;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;

public class MainPage extends BaseUI {

    private final String LINK_TO_MAIN_PAGE = "https://ria.ru";

    public void openMainPage() {
        LogUI.defaultActions("Открытие главной страницы " + LINK_TO_MAIN_PAGE);
        driver.get(LINK_TO_MAIN_PAGE);
    }

    //открыть форму авторизации
    public void openAuthorizationForm() {
        LogUI.defaultActions("Открытие формы логина");
        Driver.clickButtonByClass(LoginFormLocators.BUTTON_TO_LOGIN_FORM_BYCLASS.getLocator());
    }
}
