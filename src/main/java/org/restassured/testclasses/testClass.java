package org.restassured.testclasses;


import io.restassured.response.Response;
import org.restassured.endpoints.getBookingIDEndpoint;
import org.testng.annotations.Test;

import java.io.IOException;

public class testClass extends BaseTest {

 //@Test
    public void testMethod() {

        // Your test code goes here
    }
    @Test
    public void getBookingID() throws IOException {
        getBookingIDEndpoint booking = new getBookingIDEndpoint();
        Response response = booking.getBookingCall(1);
    }
}
