package exercise.tests.backend.auth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static exercise.endpoints.Routes.BASEPATH;
import static exercise.endpoints.Routes.ME;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetRegisteredUser {
    @Test
    public void singleUser(){
        Map<String, String> tokens = AuthHelper.loginAndGetTokens();
      Response response= given(getRequestSpecBuilder()).basePath(BASEPATH).auth().oauth2(tokens.get("accessToken"))
                .when().get(ME)
                .then().spec(getResponseBuilder())
                .extract().response();
        assertThat(response.jsonPath().getString("data.user.email"),equalTo("test@test.com"));

    }
}
