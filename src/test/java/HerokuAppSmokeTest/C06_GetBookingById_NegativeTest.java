package HerokuAppSmokeTest;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static HerokuAppSmokeTest.C01_CreateBooking.bookingId;
import static Utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C06_GetBookingById_NegativeTest extends HerokuAppBaseUrl {


  /*
        Given
            https://restful-booker.herokuapp.com/booking/:id
        When
            Kullanıcı GET request gönderir
        Then
            Status Code =404
        And
            Body:
                Not Found
     */

    @Test
    public void getBookingById() {
        // Set the URL
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected data

        String expectedData ="Method Not Allowed";
        //send the req.and get the resp.
        Response response =given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        assertEquals(405,response.statusCode());
        assertEquals(expectedData,response.asString());


    }
}

