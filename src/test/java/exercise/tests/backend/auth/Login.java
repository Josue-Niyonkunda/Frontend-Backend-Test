package exercise.tests.backend.auth;


import exercise.tests.backend.spec.SpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;

import static exercise.endpoints.Routes.BASEPATH;
import static exercise.endpoints.Routes.LOGIN;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Login {
    @Test
    public void login(){
        String requestBody = " {\n" +
                "                  \"email\": \"test@test.com\",\n" +
                "                  \"password\": \"test@test\"\n" +
                "                }";
     Response response= given(getRequestSpecBuilder())
                .body(requestBody).basePath(BASEPATH)
                .when().post(LOGIN)
                .then().spec(getResponseBuilder()).extract().response();
     assertEquals(response.statusCode(),200);
        assertThat(response.jsonPath().getString("message"),
                equalTo("Login successful"));


    }
}
