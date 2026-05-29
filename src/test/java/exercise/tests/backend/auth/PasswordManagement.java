package exercise.tests.backend.auth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static exercise.data.RandomDataGenerator.password;
import static exercise.endpoints.Routes.*;
import static exercise.tests.backend.auth.AuthHelper.accessToken;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PasswordManagement {
    @Test
    public void forgotPassword(){
        Map<String,String>email= new HashMap<>();
        email.put("email","josueniyonkunda55@gmail.com");
        Response response=given(getRequestSpecBuilder()).basePath(BASEPATH).
                body(email).
                when().post(FORGOT_PASSWORD).then().spec(getResponseBuilder()).extract().response();
       String pathString= response.jsonPath().getString("message");
       assertThat(pathString,equalTo("If an account with that email exists, a reset link has been sent."));
    }
    @Test
    public void passwordNotReset(){
        Map<String,String>password= new HashMap<>();
        password.put("password",password());
       String acc=accessToken();

        Response response= given(getRequestSpecBuilder()).basePath(BASEPATH).pathParam("token",acc)      .
                body(password).
                when().post(PASSWODRESET).then().spec(getResponseBuilder()).extract().response();
        assertThat(response.jsonPath().getString("message"),equalTo("Invalid or expired reset token"));
    }
}
