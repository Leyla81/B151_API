package get_requests;

import Utils.ObjectMapperUtils;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get_ObjectMapper_Map extends JsonPlaceHolderBaseUrl {
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
    public void GetObject() {
        
        //set the url
spec.pathParams("first","todos","second",198);

//Set the expected data
        String body =" {\n" +
                "  \"userId\": 10,\n" +
                "   \"id\": 198,\n" +
                "   \"title\": \"quis eius est sint explicabo\",\n" +
                "   \"completed\": true\n" +
                " }";
        Map<String,Object> expectedData = ObjectMapperUtils.convertJsonToJava(body, HashMap.class);//json olan string i map e donusturduk
        System.out.println("expectedData = " + expectedData);
        //expectedData = {id=198, completed=true, title=quis eius est sint explicabo, userId=10} key valu seklinde map e cevirdi
        
     //send the req. get the resp.
     Response response = given().when().get("{first}/{second}");
     response.prettyPrint();

     //Do Assertion
        


    }
}
