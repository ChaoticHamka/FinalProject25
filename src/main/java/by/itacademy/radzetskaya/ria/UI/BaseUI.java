package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import org.openqa.selenium.WebDriver;

public class BaseUI {

    protected WebDriver driver;

    public BaseUI() {
        this.driver = Driver.getDriver();
    }

}
