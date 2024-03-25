package org.restassured.testclasses;


import io.restassured.response.Response;
import org.restassured.endpoints.bookingPut;
import org.restassured.endpoints.getBookingIDEndpoint;
import org.testng.annotations.Test;

import java.io.IOException;

public class testClass extends BaseTest {

  //  @Test
    public void testMethod() {
     System.out.println("Hello");
    }
   // @Test
    public void getBookingID() throws IOException {
        getBookingIDEndpoint booking = new getBookingIDEndpoint();
        Response response = booking.getBookingCall(3);
    }
    @Test
    public void putBookingID() throws IOException {
        System.out.println(getAuthentication());
        bookingPut bp = new bookingPut(getAuthentication());
        Response response = bp.putReq(3);
    }
}
