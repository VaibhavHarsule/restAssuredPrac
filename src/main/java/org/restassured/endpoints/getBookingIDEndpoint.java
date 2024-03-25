package org.restassured.endpoints;

import com.github.fge.jsonschema.main.JsonSchema;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.restassured.Constants.endPointConstants;

import java.io.File;
import java.io.IOException;

public class getBookingIDEndpoint {
    endPointConstants eb = new endPointConstants();
    public Response getBookingCall(int id) throws IOException {
        String jsonVal = FileUtils.readFileToString(new File(eb.jsonSchema),"UTF-8");
        RequestSpecification respec = RestAssured.given().baseUri(eb.baseURL).filter(new RequestLoggingFilter()).contentType(ContentType.JSON).pathParam("id",id);
        System.out.println(jsonVal);
        Response response = respec.get(eb.GetBookingIds + "/{id}").then().assertThat().statusCode(200).extract().response().prettyPeek();
        return response;
    }

}
