package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
        /*
    Given
        https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET Request to the URL
    Then
        Status code is 200
        And "completed" is false
        And "userId" is 1
        And "title" is "quis ut nam facilis et officia qui"
        And header "Via" is "1.1 vegur"
        And header "Server" is "cloudflare"
        {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
        }
    */

    @Test
    public void get() {


            //1.set the url
            spec.pathParams("first","todos","second",2);

            //2.Set the expected Data
            JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();

            Map<String,Object> expectedData= obj.expectedDataMapper(1,"quis ut nam facilis et officia qui",false);
            expectedData.put("via","1.1 vegur");
            expectedData.put("server","cloudflare");
            System.out.println("expectedData = " + expectedData);
            //send req. and get resp.

            Response response = given(spec).when().get("{first/second}");
            response.prettyPrint();

            //Do Assersion

            Map<String,Object> actualData = response.as(HashMap.class);//De-serialization ile map a donusturduk

            assertEquals(200,response.statusCode());
            assertEquals(expectedData.get("completed"),actualData.get("completed"));
            assertEquals(expectedData.get("UserId"),actualData.get("userId"));
            assertEquals(expectedData.get("title"),actualData.get("title"));

            assertEquals(expectedData.get("via"),response.header("Via"));
            assertEquals(expectedData.get("Server"),response.header("Server"));
            //methodda degil response icinde olduklari icin response dan cagırdık

    }
}
