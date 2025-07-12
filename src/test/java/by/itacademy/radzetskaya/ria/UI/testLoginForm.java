package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.Login.LoginForm;
import by.itacademy.radzetskaya.ria.UI.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public class testLoginForm extends BaseTest {

    LoginForm loginPage;

    @BeforeEach
    public void openLoginForm(){
        loginPage = new LoginForm();
        loginPage.openAuthorizationForm();
    }

}
