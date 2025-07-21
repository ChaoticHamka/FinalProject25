package by.itacademy.radzetskaya.ria.API.modules;

import by.itacademy.radzetskaya.ria.API.utils.BaseAPI;
import by.itacademy.radzetskaya.ria.API.utils.LogAPI;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Login extends BaseAPI {

    private final String POST_LOGIN_LINK = "https://ria.ru/services/id/login/";

    private Map<String, String> setHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return headers;
    }

    public void setResponseDefault() {
        response = given()
                .headers(setHeaders())
                .body(setBodyDefault())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseWithEmail() {
        response = given()
                .headers(setHeaders())
                .body(setBodyWithEmail())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseDefaultWithoutHeaders() {
        response = given()
                .body(setBodyDefault())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseEmptyPassword() {
        response = given()
                .headers(setHeaders())
                .body(setBodyEmptyPassword())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseEmptyLogin() {
        response = given()
                .headers(setHeaders())
                .body(setBodyEmptyEmail())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseEmptyLoginAndPassword() {
        response = given()
                .headers(setHeaders())
                .body(setBodyEmptyEmailAndPassword())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseLoginNotEmail() {
        response = given()
                .headers(setHeaders())
                .body(setBodyEmailName())
                .when()
                .post(POST_LOGIN_LINK);
    }

    public void setResponseEmptyBody() {
        response = given()
                .headers(setHeaders())
                .when()
                .post(POST_LOGIN_LINK);
    }

    private String setBodyDefault() {
        return "login=" +
                setFakerEmail() +
                "&password=" +
                setFakerPassword();
    }

    private String setBodyWithEmail() {
        String fakeEmail = "e@mail.ru";
        LogAPI.setValue("login", fakeEmail);
        return "login=" +
                fakeEmail +
                "&password=" +
                setFakerPassword();
    }

    private String setBodyEmptyPassword() {
        return "login=" +
                setFakerEmail() +
                "&password="
                ;
    }

    private String setBodyEmptyEmail() {
        return "login=" +
                "&password=" +
                setFakerPassword()
                ;
    }

    private String setBodyEmptyEmailAndPassword() {
        return "login=" +
                "&password="
                ;
    }

    private String setBodyEmailName() {
        return "login=" +
                setFakerName() +
                "&password=" +
                setFakerPassword();
    }

    private String setFakerEmail() {
        String fakeEmail = fakerEmail();
        LogAPI.setValue("login", fakeEmail);
        return fakeEmail;
    }

    private String setFakerPassword() {
        String fakePassword = fakerPassword();
        LogAPI.setValue("password", fakePassword);
        return fakePassword;
    }

    private String setFakerName() {
        String fakeName = fakerUserName();
        LogAPI.setValue("login", fakeName);
        return fakeName;
    }

}
