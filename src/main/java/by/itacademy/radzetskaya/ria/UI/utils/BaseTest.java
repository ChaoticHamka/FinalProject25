package by.itacademy.radzetskaya.ria.UI.utils;

import by.itacademy.radzetskaya.ria.UI.BaseUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest{

    private final int MILLIS_IN_SECOND = 1000;

    @BeforeEach
    public void setUp(){
        BaseUI basePage = new BaseUI();
        basePage.openMainPage();
    }

    @AfterEach
    public void tearDown(){
        Driver.quit();
    }

    protected void waiting(int seconds){
        try {
            Thread.sleep(seconds * MILLIS_IN_SECOND);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
