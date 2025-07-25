package by.itacademy.radzetskaya.ria.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Driver {
    private static WebDriver driver;
    private static final int DEFAULT_DURATION_IN_SECONDS = 3;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_DURATION_IN_SECONDS));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void clickButtonByXpath(String xpath) {
        findElementByXpath(xpath).click();
    }

    public static void clickButtonByClass(String class_) {
        findElementByClass(class_).click();
    }

    public static String getTextByXpath(String xpath) {
        return findElementByXpath(xpath).getText();
    }

    public static String getTextById(String id) {
        return findElementById(id).getText();
    }

    public static String getValueById(String id) {
        return findElementById(id).getAttribute("value");
    }

    public static void setValueTextFieldById(String id, String value) {
        findElementById(id).sendKeys(value);
    }

    public static void setValueTextFieldByXpath(String xpath, String value) {
        findElementByXpath(xpath).sendKeys(value);
    }

    public static Boolean isWebElementEnabledByXpath(String xpath) {
        return findElementByXpath(xpath).isEnabled();
    }

    public static Boolean isWebElementHasDisplayNoneById(String id) {
        return findElementById(id).getAttribute("style").contains("display: none;");
    }

    public static Boolean isWebElementContainClassByXpath(String xpath, String class_) {
        WebElement webElement = findElementByXpath(xpath);
        String classAttribute = webElement.getAttribute("class");
        if (classAttribute == null || classAttribute.isEmpty()) {
            return false;
        }
        List<String> classes = Arrays.asList(classAttribute.split(" "));
        return classes.contains(class_);
    }

    public static WebElement getWebElementByClass(String class_) {
        return findElementByClass(class_);
    }

    private static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    private static WebElement findElementByClass(String class_) {
        return driver.findElement(By.className(class_));
    }

    private static WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }
}
