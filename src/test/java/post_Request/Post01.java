package post_Request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Post01 extends JsonPlaceHolderBaseUrl {
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
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void Post() {
        //1.set the url
        spec.pathParam("first","todos");

        //2.set expected data

        String payLoad = "  {\n" +
                " \"userId\": 55,\n" +
                " \"title\": \"Tidy your room\",\n" +
                " \"completed\": false\n" +
                " }";
        //    spec.pathParam("first","todos").body(payLoad);--->1.adımi burda bu sekilde de yapabiliriz
        //send req and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPath json =response.jsonPath();
        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertFalse(json.getBoolean("completed"));
        assertEquals(201,json.getInt("id"));


    }

    @Test
    public void postWithMap() {
        //1.set the url
        spec.pathParam("first","todos");

        //2.set expected data
        Map<String,Object> expectedData = new HashMap<>();// map te veriler "put" ile eklenir
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your Room");
        expectedData.put("completed",false);

        //sent req and ger resp

       Response response = given(spec).body(expectedData).when().post("{first}");
       //  json' i Mapa cevirmek icin serialize yapmak gerekir pom XML e dependency yuklendi
        //serialize json objesini map e cevir medir

        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData=response.as(HashMap.class);//json map a cevirme. buna Deserialization denir
        //Deserialisation as() methdu ile yapıllır
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(201,actualData.get("id"));





















    }
}
