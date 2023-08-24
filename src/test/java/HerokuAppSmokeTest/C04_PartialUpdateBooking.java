package HerokuAppSmokeTest;

import Utils.ObjectMapperUtils;
import base_urls.HerokuAppBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static HerokuAppSmokeTest.C01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C04_PartialUpdateBooking extends HerokuAppBaseUrl {

    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
    And
    {
    "firstname" : "Ali",
    "lastname" : "Can"
}
when
Kullanıcı Patch request gnderir
Then
status code =200
And
{
    "firstname" : "Ali",
    "lastname" : "Can",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
     */

    @Test
    public void patch() {

        //Set the url
        spec.pathParams("first","booking","second",bookingId);

        //Set the expected data
        HerokuAppTestData obj =new HerokuAppTestData();
        Map<String,Object> expectedData =  obj.expectedDataMapper("Ali","Can",null,null,null,null);
        System.out.println("expectedData = " + expectedData);
        //send the request
      Response response= given(spec).body(expectedData).when().patch("{first}/{second}");
      response.prettyPrint();

      //Do Assertion
       Map <String,String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
       assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
       assertEquals(expectedData.get("lastname"),actualData.get("lastname"));


    }
}
