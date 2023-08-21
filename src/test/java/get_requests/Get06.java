package get_requests;
import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;
public class Get06 extends HerokuAppBaseUrl {
    /*
      Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
      {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01", //////---json icinde json var  yuzden jsonları map a cevirecegiz
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
     */
    @Test
    public void Get(){
        //1.Set the url
        spec.pathParams("first","booking",
                "second",22);
        //2. Set excp data
        //3. Sent rep and get resp
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //4.   Do assertion
        //1. Yol:
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));
        //2. Yol:
        JsonPath json = response.jsonPath(); // response jsonPath() mtd kullanarak JsonPath data çeşidine dönüştürdük
        // jsonpath datasından respons da datalara kolayca ulaşabilirim.
        //System.out.println(json.getString("firstname"));
        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("super bowls",json.getString("additionalneeds"));

        // SoftAssertion 3 adımda yapılır: ---> testng poma eklenmeli
        //1.Adım Softassertion objesi oluşturulur
        SoftAssert softAssert = new SoftAssert();
        //2. Adım Assertion yapılır
        softAssert.assertEquals(json.getString("firstname"),"Josh","first name uyuşmadi ------>");
        softAssert.assertEquals(json.getString("lastname"),"Allen","last name uyuşmadı ------->");
        softAssert.assertEquals(json.getInt("totalprice"),111,"toplam ücret uyuşmadı ------>");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true);
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"),"super bowls");
        //3. softAssert.assertAll anahtar kelimesiyle bitirilir
        softAssert.assertAll();
    }

    @Test
    public void Get01() {
        //  1.Set the Url
        spec.pathParams("first","booking","second",92);


        //set the expected data
        Map<String,String> bookingDatesData =new HashMap<>();//ic ice iki json var bu yuzden 2 map olusturuldu.Bu icteki map
        bookingDatesData.put("checkin","2018-01-01");
        bookingDatesData.put("checkout","2019-01-01") ;

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname" , "Jane");
        expectedData.put("lastname","Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates" , bookingDatesData);

        expectedData.put("additionalneeds","Extra pillows please" );

        System.out.println("expectedData = " + expectedData);



        //send req.and get resp.
        Response response =given(spec).when().get("{first/second}");
        response.prettyPrint();

        //do assertion
        Map<String,Object>actualData =response.as(HashMap.class);//De-Serialization

       assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
       assertEquals(bookingDatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
       assertEquals(bookingDatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));
    }


}