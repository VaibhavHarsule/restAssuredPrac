package org.restassured.testclasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restassured.Constants.endPointConstants;
import org.restassured.endpoints.payloadAuth;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    endPointConstants eb = new endPointConstants();
    private final String authentication; // Changed from static

    public BaseTest() {
        this.authentication = generateTokenFromAPI(); // Changed from Authentication
    }

    private String generateTokenFromAPI() {
        ObjectMapper objectMapper = new ObjectMapper(); // Renamed from ob

        payloadAuth auth = new payloadAuth("admin", "password123");
        String payloadAuthJson;
        try {
            payloadAuthJson = objectMapper.writeValueAsString(auth);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RequestSpecification reqSpec = RestAssured.given()
                .filter(new RequestLoggingFilter())
                .baseUri(eb.baseURL)
                .contentType("application/json")
                .body(auth); // Changed from auth
        Response response = reqSpec.when()
                .post(eb.auth)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .prettyPeek();

        return response.jsonPath().get("token").toString();
    }

    @BeforeMethod
    public void beforeTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
