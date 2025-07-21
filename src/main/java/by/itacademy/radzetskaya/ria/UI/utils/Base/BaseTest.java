package by.itacademy.radzetskaya.ria.UI.utils.Base;

import by.itacademy.radzetskaya.ria.Base.TestUtils;
import by.itacademy.radzetskaya.ria.UI.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest extends TestUtils {

    @BeforeEach
    public void setUp() {
        MainPage basePage = new MainPage();
        basePage.openMainPage();
    }

    @AfterEach
    public void tearDown() {
        LogUI.endTest();
        Driver.quit();
    }

}
