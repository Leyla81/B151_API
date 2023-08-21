package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

public class Get04RevisionQ6 {



    /*
    Given  https://jsonplaceholder.typicode.com/todos
    When   I send a GET request to the Url
    And    Accept type is "application/json"
    Then   HTTP Status Code should be 200
    And    Response format should be "application/ison"
    And    200 adet todos olmalı
    And    başlıklarından birisi  "quis eius est sint explicabo" olmalı
    And    userIds ler arasında 2, 7, and 9 bulunmalı
     */


    //i: Set The Url

    @Test
    public void name() {
        RestAssured.baseURI =  "https://jsonplaceholder.typicode.com";
        RestAssured.basePath ="/todos/23";
    }


    //ii:Set the expected data
    //iii:Send the request get the response
    //iiii: Do assertion





}
