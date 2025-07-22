package by.itacademy.radzetskaya.ria.api.modules;

import by.itacademy.radzetskaya.ria.api.utils.BaseApi;
import by.itacademy.radzetskaya.ria.api.utils.LogApi;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Login extends BaseApi {

    private final String POST_LOGIN_LINK = "https://ria.ru/services/id/login/";
    private final String DEFAULT_EMAIL = "e@mail.ru";

    private Map<String, String> setHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return headers;
    }

    private void setResponse(Map<String, String> headers, String body){
        response = given()
                .headers(headers)
                .body(body)
                .when()
                .post(POST_LOGIN_LINK);
    }

    private void setResponse(String body){
        response = given()
                .body(body)
                .when()
                .post(POST_LOGIN_LINK);
    }

    private void setResponse(Map<String, String> headers){
        response = given()
                .headers(headers)
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseDefault() {
        setResponse(setHeaders(), setBodyDefault());
    }

    public void setResponseWithEmail() {
        setResponse(setHeaders(), setBodyWithEmail());
    }

    public void setResponseDefaultWithoutHeaders() {
        setResponse(setBodyDefault());
    }

    public void setResponseEmptyPassword() {
        setResponse(setHeaders(), setBodyEmptyPassword());
    }

    public void setResponseEmptyLogin() {
        setResponse(setHeaders(), setBodyEmptyEmail());
    }

    public void setResponseEmptyLoginAndPassword() {
        setResponse(setHeaders(), setBodyEmptyEmailAndPassword());
    }

    public void setResponseLoginNotEmail() {
        setResponse(setHeaders(), setBodyEmailName());
    }

    public void setResponseEmptyBody() {
        setResponse(setHeaders());
    }

    private String setBody(String login, String password){
        return String.format("login=%s&password=%s", login, password);
    }

    private String setBodyDefault() {
        return setBody(setRandomEmail(), setRandomPassword());
    }

    private String setBodyWithEmail() {
        return setBody(setDefaultEmail(), setRandomPassword());
    }

    private String setBodyEmptyPassword() {
        return setBody(setRandomEmail(), "");
    }

    private String setBodyEmptyEmail() {
        return setBody("", setRandomPassword());
    }

    private String setBodyEmptyEmailAndPassword() {
        return setBody("", "");
    }

    private String setBodyEmailName() {
        return setBody(setRandomName(), setRandomPassword());
    }

    private String setDefaultEmail() {
        return setValue("login", DEFAULT_EMAIL);
    }

    private String setRandomEmail() {
        return setValue("login", fakerEmail());
    }

    private String setRandomPassword() {
        return setValue("password", fakerPassword());
    }

    private String setRandomName() {
        return setValue("login", fakerUserName());
    }

    private String setValue(String field, String value){
        LogApi.setValue(field, value);
        return value;
    }

}
