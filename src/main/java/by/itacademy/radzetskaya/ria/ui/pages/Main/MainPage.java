package by.itacademy.radzetskaya.ria.ui.pages.Main;

import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
import by.itacademy.radzetskaya.ria.ui.utils.Base.BaseUI;
import by.itacademy.radzetskaya.ria.ui.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BaseUI {

    private final String LINK_TO_MAIN_PAGE = "https://ria.ru";

    public void openMainPage() {
        LogUi.defaultActions("Открытие главной страницы " + LINK_TO_MAIN_PAGE);
        driver.get(LINK_TO_MAIN_PAGE);
    }

    public void openAuthorizationForm() {
        LogUi.defaultActions("Открытие формы логина");
        Driver.clickButtonByClass(MainPageLocators.BUTTON_TO_LOGIN_FORM_BYCLASS.getLocator());
    }

    public List<String> getArticles() {
        LogUi.defaultActions("Сбор названий статей");
        WebElement divWithArticleNames = Driver.getWebElementByClass(MainPageLocators.DIV_WITH_ARTICLES_BYCLASS.getLocator());
        List<WebElement> listOfArticles = divWithArticleNames.findElements(By.tagName("a"));
        List<String> articleNames = new ArrayList<String>();
        for (WebElement a : listOfArticles) {
            articleNames.add(a.getText());
        }
        LogUi.defaultActions("Сбор завершен");
        return articleNames;
    }

}
