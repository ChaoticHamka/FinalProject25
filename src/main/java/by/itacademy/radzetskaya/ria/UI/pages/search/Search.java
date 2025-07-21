package by.itacademy.radzetskaya.ria.UI.pages.search;

import by.itacademy.radzetskaya.ria.UI.pages.Main.MainPage;
import by.itacademy.radzetskaya.ria.UI.utils.Driver;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;

import java.util.List;
import java.util.Random;

public class Search extends MainPage {

    private String article;

    public String getArticle() {
        return article;
    }

    protected void setArticle(List<String> articleNames) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(articleNames.size());
        String articleName = articleNames.get(randomNumber);
        LogUI.setArticle(articleName);
        this.article = articleName;
    }

    protected void setArticle(String articleName) {
        LogUI.setArticle(articleName);
        this.article = articleName;
    }

    public void clickOnSearchIcon() {
        Driver.clickButtonByXpath(SearchLocators.A_TO_SEARCH_BYXPATH.getLocator());
    }

    public void clickOnSearchButton() {
        Driver.clickButtonByXpath(SearchLocators.BUTTON_SEARCH_BYXPATH.getLocator());
    }

    public void clickOnSort() {
        Driver.clickButtonByXpath(SearchLocators.DIV_SORT_BYXPATH.getLocator());
    }

    public void clickOnRelevance() {
        Driver.clickButtonByXpath(SearchLocators.LI_RELEVANCE_BYXPATH.getLocator());
    }

    public void setSearchArticle() {
        Driver.setValueTextFieldByXpath(SearchLocators.INPUT_SEARCH_BYXPATH.getLocator(), article);
    }

    public void setSearchArticle(String articleName) {
        setArticle(articleName);
        Driver.setValueTextFieldByXpath(SearchLocators.INPUT_SEARCH_BYXPATH.getLocator(), articleName);
    }

    public String getFirstArticleTitle() {
        return Driver.getTextByXpath(SearchLocators.DIV_FIRST_ARTICLE_BYXPATH.getLocator());
    }

}
