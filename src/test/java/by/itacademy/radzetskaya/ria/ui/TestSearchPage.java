package by.itacademy.radzetskaya.ria.ui;

import by.itacademy.radzetskaya.ria.Base.Articles;
import by.itacademy.radzetskaya.ria.ui.pages.search.TestSearchUtils;
import by.itacademy.radzetskaya.ria.ui.utils.LogUi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSearchPage extends TestSearchUtils {

    @Test
    public void testSearchRandomArticleFormSite() {
        String heading = "Поиск по случайному названию статьи с сайта";
        LogUi.startTest(heading);
        search.clickOnSearchIcon();
        search.setSearchArticle();
        search.clickOnSearchButton();
        search.clickOnSort();
        search.clickOnRelevance();
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
        LogUi.startTest(heading);
        search.clickOnSearchIcon();
        search.setSearchArticle(articles.getRandomArticleName());
        search.clickOnSearchButton();
        search.clickOnSort();
        search.clickOnRelevance();
        String firstArticleTitle = search.getFirstArticleTitle();
        assertAll(
                heading,
                () -> assertTrue(isArticleNameHasSearchArticleName(firstArticleTitle), "Видимо что-то пошло не так и нужная статья не нашлась")
        );
    }
}
