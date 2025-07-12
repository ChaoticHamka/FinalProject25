package by.itacademy.radzetskaya.ria.UI.Login;

import by.itacademy.radzetskaya.ria.UI.BaseUI;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;

public class LoginForm extends BaseUI {

    public LoginForm() {
        this.driver = Driver.getDriver();
    }

    //локаторы
    private final String BUTTON_TO_LOGIN_FORM = "//div[@class=\"header__menu-left\"]";
    private final String INPUT_LOGIN = "//input[@id=\"modalAuthEmailField\"]";
    private final String BUTTON_LOGIN_ALL_GOOD = "//div[@id=\"modalAuthSubmit\"]/button[@class=\"form__btn\"]";
    private final String BUTTON_LOGIN_WRONG_EMAIL = "//div[@id=\"modalAuthError\"]";

    //действия с локаторами
    public void openAuthorizationForm(){
        Driver.clickButtonByXpath(BUTTON_TO_LOGIN_FORM);
    }

}
