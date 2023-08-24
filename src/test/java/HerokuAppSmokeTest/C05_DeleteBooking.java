package HerokuAppSmokeTest;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static HerokuAppSmokeTest.C01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C05_DeleteBooking extends HerokuAppBaseUrl {
    /*
    Gİven
    https://restful-booker.herokuapp.com/booking/1
    When
    kullanıcı delete request gnderir
    Then
    status code=200
 And
    body:
    Created
     */

    @Test
    public void delete() {
        //set the url
        spec.pathParams("first","booking","second",bookingId);
        //Set the expected data

        String expectedData ="Created";
        //send the req.and get the resp.
        Response response =given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());
    }
}
