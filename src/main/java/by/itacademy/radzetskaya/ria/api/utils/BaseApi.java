package by.itacademy.radzetskaya.ria.api.utils;

import by.itacademy.radzetskaya.ria.Base.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;

public class BaseApi extends TestUtils {

    protected Response response;

    public int getResponseStatusCode() {
        return response.statusCode();
    }

    public JsonPath getResponseAsJSON() {
        String jsonText = response.getBody().asString().replaceAll("<[^>]+>", "").trim();
        return new JsonPath(jsonText);
    }

    @AfterEach
    public void tearDown(){
        LogApi.endTest();
    }

}
