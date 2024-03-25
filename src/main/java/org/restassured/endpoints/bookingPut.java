package org.restassured.endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restassured.Constants.endPointConstants;

public class bookingPut {
    public final String auth;
    endPointConstants eb = new endPointConstants();
    public bookingPut(String auth)
    {
        this.auth = auth;
        System.out.println("this is auth " + auth);
    }
    public Response putReq(int id)
    {
        RequestSpecification reqspec = RestAssured.given()
                .baseUri(eb.baseURL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .cookie("token:" + auth)
                .filter(new RequestLoggingFilter())
                .pathParams("id",id);
        Response response = reqspec.
                put(eb.GetBookingIds+"{id}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
        return response;
    }

}
