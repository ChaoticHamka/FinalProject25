package by.itacademy.radzetskaya.ria.UI.utils;

import org.openqa.selenium.WebDriver;

public class BaseUI {

    protected WebDriver driver;

    public BaseUI() {
        this.driver = Driver.getDriver();
    }

}
