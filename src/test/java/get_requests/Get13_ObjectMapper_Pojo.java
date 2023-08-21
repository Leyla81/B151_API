package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static Utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static test_data.JsonPlaceHolderTestData.convertJsonToString;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

           /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send GET Request to the URL
        Then
            Status code is 200
        And response body is like
            {
                "userId": 10,
                "id": 198,
                "title": "quis eius est sint explicabo",
                "completed": true
            }
    */
        @Test
        public void GetPojo() {
            //set the url
            spec.pathParams("first","todos","second",198);

//Set the expected data
            String body = convertJsonToString(10,"quis eius est sint explicabo",true);
//JsonPlaceHolderTestData clasındaki convertJsonToString() methodunu kullandık.
            JsonPlaceHolderPojo expectedData = convertJsonToJava(body,JsonPlaceHolderPojo.class);
            System.out.println("expectedData = " + expectedData);
//Send req. and get resp.
            Response response = given(spec).when().get("{first}/{second}");
            response.prettyPrint();
            //Do Assertion
            JsonPlaceHolderPojo actualData = convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
            System.out.println("actualData = " + actualData);

            assertEquals(200,response.statusCode());
            assertEquals(expectedData.getUserId(),actualData.getUserId());
            assertEquals(expectedData.getTitle(), actualData.getTitle());
            assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }
}







