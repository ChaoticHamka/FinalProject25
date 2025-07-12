package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import org.openqa.selenium.WebDriver;

public class BaseUI {

    protected WebDriver driver;

    private final String LINK_TO_MAIN_PAGE = "https://ria.ru";

    public BaseUI() {
        driver = Driver.getDriver();
    }

    public void openMainPage(){
        driver.get(LINK_TO_MAIN_PAGE);
    }

}
