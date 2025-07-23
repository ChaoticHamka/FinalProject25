package by.itacademy.radzetskaya.ria.api;

import by.itacademy.radzetskaya.ria.api.modules.SearchUtils;
import by.itacademy.radzetskaya.ria.api.utils.LogApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSearch extends SearchUtils {

    @Test
    @DisplayName("Отправка запроса на поиск")
    public void testSearch() {
        LogApi.startTest("Отправка запроса на поиск");
        String bodyResponse = getBodyResponse();
        Assertions.assertTrue(bodyResponse.contains(getArticleForSearch()), "В возвращаемом body должно быть искомое название статьи");
    }

}
