package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {
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

    @Test
    public void Get() {
        //1.set Base url
        //Base url= her sorgulda tekrarlana kısım
        //path parametresi "/"den sonra gelen base url e eklene kısım
        spec.pathParam("first","todos");//

       // String url ="https://jsonplaceholder.typicode.com/todos";//tercih edilmeyen yontem

        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
//given on kosul. body  content type -----pathParam
// ------when () action-------



        //do Assertion
        response.then() //assertion then()ile baslar
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",hasSize(200),//hasSize() methdu listteki Size ı control etmek icin
                        "title",hasItem("quis ut nam facilis et officia qui")//
                        ,"userId",hasItems(2,7,9));
        // hasSize: listenin boyutunu sorgular
        // hasItem() --> contais() mtd gibi çalışır
        // hasItems() --> containsAll() gibi çalışır
    }
}
