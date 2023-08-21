package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    notlar:
    1- Manuel testler icin postman kullanacagız
    2- Apı otomasyon testleri iciin REST ASSURED kutuphanesini indirdik
    3-otomasyon kodları yazarken su adımlar takip edilir.
       a. Gereksinimleri anlama
       b. test senaryolarını yazma
          i: Test senaryolarını yazarken Gherkin dilini kullanırız
           -Given : On kosullar :Endpoint, body...
           -When: İslemler : GET,PUT,POST,,DELETE..
           -And: Coklu islemleerin papılacagı zaman kullanılır
       c.otomasyon kodlarını yazarken su adımları takip ederiz
           i: Set The Url
           ii:Set the expected data
           iii:Send the request get the response
           iiii: Do assertion

    API de ilk test edilecek sey status 200,300,400...
     */
    //i: Set The Url
    //ii:Set the expected data
    //iii:Send the request get the response
    //iiii: Do assertion

    public static void main(String[] args) {
         String url ="https://petstore.swagger.io/v2/pet/3435";

         Response response = given().when().get(url);
         response.prettyPrint(); //sadece body kısmı yazdırılır

         //status kod nasıl yazdırılır
        System.out.println("Status Code = "+response.statusCode());

        //ContentType nasıl yazdırılır.
        System.out.println("Content Type = "+response.contentType());

        //Status Line nasıl yazdırılır.
        System.out.println("Status Line =" +response.statusLine());

        //Header bolumundeki bir veri nasıl yazdırılır.
        System.out.println("Header|| Server = " +response.header("server"));

        //Headers bolumundeki butun  veriler nasıl yazdırılır.
        System.out.println("HEADERS = "+response.headers());
        //Time bilgisini yazdirma
        System.out.println("Time = "+response.time());
    }




















}
