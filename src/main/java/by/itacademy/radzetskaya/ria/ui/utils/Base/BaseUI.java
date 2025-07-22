package by.itacademy.radzetskaya.ria.ui.utils.Base;

import by.itacademy.radzetskaya.ria.ui.utils.Driver;
import org.openqa.selenium.WebDriver;

public class BaseUI {

    protected WebDriver driver;
    private final int MILLIS_IN_SECOND = 1000;
    protected final int DEFAULT_WAITING_IN_SECONDS = 2;
    protected final int EXTRA_WAITING_IN_SECONDS = 3;

    public BaseUI() {
        this.driver = Driver.getDriver();
    }

    protected void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * MILLIS_IN_SECOND);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
