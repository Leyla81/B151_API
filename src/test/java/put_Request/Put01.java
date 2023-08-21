package put_Request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

/*
Given
      1) https://jsonplaceholder.typicode.com/todos/198
      2) {
          "userId": 21,
          "title": "Wash the dishes",
          "completed": false
         }
     When
     I send PUT Request to the Url
    Then
      Status code is 200
      And response body is like   {
            "userId": 21,
            "title": "Wash the dishes",
            "completed": false
           }
 */

    @Test
    public void put() {

       // 1.Set the url
        spec.pathParams("first","todos","second",198);

        //Set expected data
        Map<String,Object> expectedData = new HashMap<>();// map te veriler "put" ile eklenir
        expectedData.put("userId",21);
        expectedData.put("title","Wash the dishes");
        expectedData.put("completed",false);

        //3. send req. and get resp.
      Response response=  given().body(expectedData).when().put("{first}/{second}");//Serialization

        //4 do Assert
        Map<String,Object> actualData = response.as(HashMap.class);//De-Serialization

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));


    }

    @Test
    public void putWithMethod() {
        // 1.Set the url
        spec.pathParams("first","todos","second",198);

JsonPlaceHolderTestData obj =new JsonPlaceHolderTestData();
       Map<String,Object>expectedData = obj.expectedDataMapper(21,"Wash the dishes",false);

        //3. send req. and get resp.
        Response response=  given(spec).body(expectedData).when().put("{first}/{second}");//Serialization

        //4 do Assert
        Map<String,Object> actualData = response.as(HashMap.class);//De-Serialization

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
/*
    API'lerde en onemli kisim gonderdiginiz veri ile gelen veri birbiri ile ortusup ortusmedigidir.
    Biz farkli yollarla (Hamcrest Matchers,assertion vs.) bunu dogrulariz.

    Swagger Dokumani:
    Api dokumantasyonu icin Swagger i kullaniriz.
    Kullanacagimiz end pointleri, methodlari (get, put, post) bunlari nasil ve hangi petlerle kullanacagimizi anlatir.
    Icine girince testlerimizi orda da yapabiliriz
    Bize gelebilecek ornek response datayi da saglar

    Postman:
    API test araci. Hem manuel hem otomasyon ile test yapilabilir.

    Serialization = Java Map objesinin Json objesine donusturulmesidir.
    Deserialization = Json Objesinin Java Map Objesine donusturulmesidir.

     */