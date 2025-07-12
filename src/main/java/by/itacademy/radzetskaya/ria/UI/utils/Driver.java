package by.itacademy.radzetskaya.ria.UI.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    public Driver() {
    }

    //методы для работы драйвера
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    //действия с веб-элементами
    public static void clickButtonByXpath(String xpath){
        findElementByXpath(xpath).click();
    }

    //методы для поиска веб-элементов
    private static WebElement findElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
