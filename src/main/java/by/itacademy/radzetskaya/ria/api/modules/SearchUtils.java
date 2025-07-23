package by.itacademy.radzetskaya.ria.api.modules;

import by.itacademy.radzetskaya.ria.Base.Articles;
import by.itacademy.radzetskaya.ria.api.utils.BaseApi;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchUtils extends BaseApi {

    private final String GET_SEARCH_LINK = "https://ria.ru/search/";
    private String articleForSearch;

    private Map<String, String> setQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        Articles articles = new Articles();
        articleForSearch = articles.getRandomArticleName();
        queryParams.put("query", articleForSearch);
        return queryParams;
    }

    private void setResponse() {
        response = given()
                .queryParams(setQueryParams())
                .when()
                .get(GET_SEARCH_LINK);
    }

    public String getBodyResponse(){
        setResponse();
        return response.then().extract().body().asString();
    }

    public String getArticleForSearch(){
        return articleForSearch;
    }
}
