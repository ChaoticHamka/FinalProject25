package by.itacademy.radzetskaya.ria.ui.utils.Base;

import by.itacademy.radzetskaya.ria.Base.TestUtils;
import by.itacademy.radzetskaya.ria.ui.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.ui.utils.Driver;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
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
        LogUi.endTest();
        Driver.quit();
    }

}
