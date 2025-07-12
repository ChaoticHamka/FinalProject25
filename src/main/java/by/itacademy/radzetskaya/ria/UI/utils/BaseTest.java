package by.itacademy.radzetskaya.ria.UI.utils;

import by.itacademy.radzetskaya.ria.UI.BaseUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest{
    @BeforeEach
    public void setUp(){
        BaseUI basePage = new BaseUI();
        basePage.openMainPage();
    }

    @AfterEach
    public void tearDown(){
        Driver.quit();
    }
}
