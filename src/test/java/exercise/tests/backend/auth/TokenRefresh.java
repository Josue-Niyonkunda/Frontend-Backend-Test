package exercise.tests.backend.auth;

import groovy.lang.GString;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static exercise.endpoints.Routes.*;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class TokenRefresh {

            @Test
            public void refreshTokenTest() {

                Map<String, String> tokens = AuthHelper.loginAndGetTokens();

                String refreshToken = tokens.get("refreshToken");
                Map<String, String> body = new HashMap<>();
                body.put("refreshToken", refreshToken);
                Response response = given(getRequestSpecBuilder()).basePath(BASEPATH)
                        .body(body)
                        .when()
                        .post(REFRESH_TOKEN)
                        .then()
                        .spec(getResponseBuilder())
                        .extract()
                        .response();
                assertEquals(200, response.statusCode());

                assertThat(
                        response.jsonPath().getString("message"),
                        equalTo("Success")
                );
                assertNotNull(response.jsonPath().getString("data.token"));
            }
        }


