package by.itacademy.radzetskaya.ria.api;

import by.itacademy.radzetskaya.ria.api.utils.BaseApi;
import by.itacademy.radzetskaya.ria.api.utils.LogApi;
import by.itacademy.radzetskaya.ria.Base.Articles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestSearch extends BaseApi {

    @Test
    @DisplayName("Отправка запроса на поиск")
    public void testSearch() {
        LogApi.startTest("Отправка запроса на поиск");
        Articles articles = new Articles();
        String search = articles.getRandomArticleName();
        String bodyResponse =
                given()
                        .queryParam("query", search)
                        .when()
                        .get("https://ria.ru/search/")
                        .then().extract().body().asString();
        Assertions.assertTrue(bodyResponse.contains(search), "В возвращаемом body должно быть искомое название статьи");
    }

}
