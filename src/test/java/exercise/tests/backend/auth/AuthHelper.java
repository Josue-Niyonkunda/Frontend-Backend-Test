package exercise.tests.backend.auth;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static exercise.endpoints.Routes.BASEPATH;
import static exercise.endpoints.Routes.LOGIN;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.given;

public class AuthHelper {


    public static Map<String, String> loginAndGetTokens() {

        String requestBody = " {\n" +
                "                  \"email\": \"test@test.com\",\n" +
                "                  \"password\": \"test@test\"\n" +
                "                }";
        Response response= given(getRequestSpecBuilder())
                .body(requestBody).basePath(BASEPATH)
                .when().post(LOGIN)
                .then().spec(getResponseBuilder()).extract().response();

        String accessToken = response.jsonPath().getString("data.token");

        String refreshToken = response.jsonPath().getString("data.refreshToken");

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        System.out.println(refreshToken);
        return tokens;
    }
    public static String accessToken(){
        String requestBody = " {\n" +
                "                  \"email\": \"test@test.com\",\n" +
                "                  \"password\": \"test@test\"\n" +
                "                }";
        Response response= given(getRequestSpecBuilder())
                .body(requestBody).basePath(BASEPATH)
                .when().post(LOGIN)
                .then().spec(getResponseBuilder()).extract().response();

        return response.jsonPath().getString("data.token");

    }
}