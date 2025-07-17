package by.itacademy.radzetskaya.ria.UI.utils;

import by.itacademy.radzetskaya.ria.UI.pages.Main.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest{

    @BeforeEach
    public void setUp(){
        MainPage basePage = new MainPage();
        basePage.openMainPage();
    }

    @AfterEach
    public void tearDown(){
        Driver.quit();
    }

}
