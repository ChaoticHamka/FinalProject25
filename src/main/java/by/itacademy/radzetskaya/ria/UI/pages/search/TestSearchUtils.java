package by.itacademy.radzetskaya.ria.UI.pages.search;

import by.itacademy.radzetskaya.ria.UI.utils.Base.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public class TestSearchUtils extends BaseTest {

    protected Search search;

    @BeforeEach
    public void initialisation() {
        search = new Search();
        search.setArticle(search.getArticles());
    }

    protected Boolean isArticleNameHasSearchArticleName(String title) {
        return title.contains(search.getArticle());
    }
}
