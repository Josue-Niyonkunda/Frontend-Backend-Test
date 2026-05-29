package exercise.tests.backend.spec;

import exercise.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.config;

public class SpecBuilder {

    public static RequestSpecification getRequestSpecBuilder(){
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().backendBaseUrl()).
                setConfig(config.encoderConfig(EncoderConfig.encoderConfig().
                appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    }
    public static ResponseSpecification getResponseBuilder(){
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    }
}
