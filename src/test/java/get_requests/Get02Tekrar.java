package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class Get02Tekrar {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Not Found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Cowboy" olmalı
    */

    @Test
    public void Gwt02() {
        //i: Set The Url
        String url ="https://restful-booker.herokuapp.com/booking/0";

        //ii:Set the expected data
        //iii:Send the request get the response
       Response response= given().when().get(url);

        //iiii: Do assertion

        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");
                //.body(containsString("Not Found")); bu da olabilir alttaki de olabilir
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals("Cowboy",response.header("Server"));
        response
                .then()
                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd")));



















    }
}
