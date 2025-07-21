package by.itacademy.radzetskaya.ria.UI;

import by.itacademy.radzetskaya.ria.UI.pages.search.Articles;
import by.itacademy.radzetskaya.ria.UI.pages.search.TestSearchUtils;
import by.itacademy.radzetskaya.ria.UI.utils.LogUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSearchPage extends TestSearchUtils {

    @Test
    public void testSearchRandomArticleFormSite() {
        String heading = "Поиск по случайному названию статьи с сайта";
        LogUI.startTest(heading);
        search.clickOnSearchIcon();
        search.setSearchArticle();
        search.clickOnSearchButton();
        search.clickOnSort();
        search.clickOnRelevance();
        waiting(2);
        String firstArticleTitle = search.getFirstArticleTitle();
        assertAll(
                heading,
                () -> assertTrue(isArticleNameHasSearchArticleName(firstArticleTitle), "Видимо что-то пошло не так и нужная статья не нашлась")
        );
    }

    @Test
    public void testSearchRandomArticleFormArticles() {
        Articles articles = new Articles();
        String heading = "Поиск по случайному названию статьи из списка";
        LogUI.startTest(heading);
        search.clickOnSearchIcon();
        search.setSearchArticle(articles.getRandomArticleName());
        search.clickOnSearchButton();
        search.clickOnSort();
        search.clickOnRelevance();
        waiting(2);
        String firstArticleTitle = search.getFirstArticleTitle();
        assertAll(
                heading,
                () -> assertTrue(isArticleNameHasSearchArticleName(firstArticleTitle), "Видимо что-то пошло не так и нужная статья не нашлась")
        );
    }
}
