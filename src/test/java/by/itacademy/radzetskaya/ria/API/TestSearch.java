package by.itacademy.radzetskaya.ria.API;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestSearch {
    @Test
    public void testSearch(){
        String search = "Союзники, ставшие врагами. Как Русь обороняла южные границы от печенегов";
//        String bodyResponse =
//        given()
//                .queryParam("query", search)
//                .when()
//                .get("https://ria.ru/search/")
//                .then().extract().response().body().asString();

        given()
                .queryParam("query", search)
                .when()
                .get("https://ria.ru/search/")
                .then().log().all();

        given()
                .when()
                .get("https://ria.ru/search/?query=Союзники%2C+ставшие+врагами.+Как+Русь+обороняла+южные+границы+от+печенегов")
                .then().log().all();
//        System.out.println(bodyResponse.contains(search));
//        System.out.println(bodyResponse.contains("Союзники,"));
//        Assertions.assertTrue(bodyResponse.contains(search));

    }
    @Test
    public void testSearch1(){
        String search = "Союзники%2C+ставшие+врагами.+Как+Русь+обороняла+южные+границы+от+печенегов";
        String bodyResponse =
        given()
                .queryParam("query", search)
                .when()
                .get("https://ria.ru/search/")
                .then().extract().body().asString();

//        given()
//                        .queryParam("query", search)
//                        .when()
//                        .get("https://ria.ru/search/")
//                        .then().log().all();
        System.out.println(bodyResponse.contains(search));
        System.out.println(bodyResponse.contains("Союзники,"));
        Assertions.assertTrue(bodyResponse.contains(search));

    }
}
