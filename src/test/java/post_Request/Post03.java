package post_Request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void post03() {
       //set Url
       spec.pathParam("first","todos") ;

       //set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);

        //send the req. and get resp.
       Response response = given(spec).body(expectedData).when().post("{first}");
       response.prettyPrint();

       //Do assert
       JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
       assertEquals(201,response.statusCode());
       assertEquals(expectedData.getUserId(),actualData.getUserId());
       assertEquals(expectedData.getTitle(),actualData.getTitle());
       assertEquals(expectedData.getCompleted(),actualData.getCompleted());





















    }
}
