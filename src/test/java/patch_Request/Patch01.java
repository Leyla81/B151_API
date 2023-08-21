package patch_Request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
              "title": "Wash the dishes"
           }
    When
      I send PATCH Request to the Url
    Then
          Status code is 200
          And response body is like
              {
                "userId": 10,
                "title": "Wash the dishes",
                "completed": true,
                "id": 198
              }
     */

    @Test
    public void patch01() {

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data

        JsonPlaceHolderTestData obj =new JsonPlaceHolderTestData();
       Map<String,Object>payLoad= obj.expectedDataMapper(null,"Wash the dishes",null);
       Map<String,Object>expectedData= obj.expectedDataMapper(10,"Wash the dishes",true);


       //send req.and get the resp.

       Response response= given(spec).body(payLoad).when().patch("{first}/{second}");
       response.prettyPrint();

       //Do Assertion

        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));

    }
}
