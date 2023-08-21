package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */
        @Test //test annatasyonu bize run edebilmeyi saglar
        public void get01(){
            //1. way
            String url = " https://restful-booker.herokuapp.com/booking/1";

            //2. way
            RestAssured.baseURI =  "https://restful-booker.herokuapp.com";
            RestAssured.basePath ="/booking/1";
          Response response = given().when().get();
          response.prettyPrint();

          response.then()
                  .statusCode(200)
                  .contentType("application/json")
                  .statusLine("HTTP/1.1 200 OK");



    }


}
