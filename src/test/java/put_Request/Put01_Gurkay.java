package put_Request;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Put01_Gurkay extends JsonPlaceHolderBaseUrl {
    /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
            Kullanıcı URL'e bir PUT request gönderir
        Then
           Status code 200 olmalı
           Response şu şekilde olmalı:
           {
                "userId": 21,
                "title": "Wash the dishes",
                "completed": false
                "id": 198
           }
     */
    @Test
    public void put01() {
        // Set the URL
        spec.pathParams("first", "todos", "second", 198);

        // Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId", 21);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed", false);
        System.out.println("Expected Data: " + expectedData);

        // Send the request and get the response
        Response response = given(spec).body(expectedData).when().put("{first}/{second}"); // Serialization
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualData);

        // Status Code Doğrulaması
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
    @Test
    public void put01withMethod() {
        // Set the URL
        spec.pathParams("first", "todos", "second", 198);
        // Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        //JsonPlaceHolderTestData bu classdaki methodu kullanmak icin obj olusturduk
Map<String,Object> expectedData = obj.expectedDataMapper(21,"Wash the dishes",false);

// Send the request and get the response
        Response response = given(spec).body(expectedData).when().put("{first}/{second}"); // Serialization
        response.prettyPrint();

        // Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualData);

        // Status Code Doğrulaması
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}