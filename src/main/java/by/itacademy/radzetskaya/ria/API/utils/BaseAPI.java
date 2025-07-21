package by.itacademy.radzetskaya.ria.API.utils;

import by.itacademy.radzetskaya.ria.Base.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseAPI extends TestUtils {

    protected Response response;

    public int getResponseStatusCode() {
        return response.statusCode();
    }

    public Response getResponse() {
        return response;
    }

    public JsonPath getResponseAsJSON() {
        String jsonText = response.getBody().asString().replaceAll("<[^>]+>", "").trim();
        JsonPath json = new JsonPath(jsonText);
        return json;
    }

    public void logResponse() {
        response.then().log().all();
    }

}
