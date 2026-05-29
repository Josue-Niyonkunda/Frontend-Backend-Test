package exercise.tests.backend.auth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import static exercise.data.RandomDataGenerator.*;
import static exercise.endpoints.Routes.*;
import static exercise.tests.backend.spec.SpecBuilder.getRequestSpecBuilder;
import static exercise.tests.backend.spec.SpecBuilder.getResponseBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Registration {
    @Test
    public void registrationWithRegisteredEmailTest(){
        String requestBody="{\n" +
                "  \"email\": \"john@example.com\",\n" +
                "  \"password\": \"MyPass@123\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"phone\": \"+250788123456\"\n" +
                "}";
        Response response= given(getRequestSpecBuilder())
                .body(requestBody).basePath(BASEPATH)
                .when().post(REGISTER)
                .then().spec(getResponseBuilder()).extract().response();
        assertThat(response.jsonPath().getString("message"),
                equalTo("Email already registered"));

    }
    @Test
    public void registerNewUserTest(){
        Map<String,String>requestBody=new HashMap<>();
        requestBody.put("email",email());
        requestBody.put("password",password());
        requestBody.put("firstName",firstName());
        requestBody.put("lastName",lastName());
        requestBody.put("phone",phone());

        Response response= given(getRequestSpecBuilder())
                .body(requestBody).basePath(BASEPATH)
                .when().post(REGISTER)
                .then().spec(getResponseBuilder()).extract().response();
        assertThat(response.jsonPath().getString("message"),
                equalTo("Registration successful. Check your email to verify."));

    }
}
