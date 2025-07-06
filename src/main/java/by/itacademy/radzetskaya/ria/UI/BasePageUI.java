package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.utils.Driver;
import org.openqa.selenium.WebDriver;

public class BasePageUI {

    protected WebDriver driver;

    public BasePageUI() {
        driver = Driver.getDriver();
    }

    public void openMainPage(){
        driver.get("https://ria.ru");
    }

}
