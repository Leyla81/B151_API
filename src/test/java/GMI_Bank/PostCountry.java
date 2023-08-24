package GMI_Bank;

import base_urls.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GMIBankPojo.CountryPojo;
import pojos.GMIBankPojo.StatesPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCountry extends GMIBankBaseUrl {
     /*
        https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak en az 3 "state"
        içeren bir "country" oluşturan bir otomasyon testi yazınız.
        Not : Autherization için headers'a "Authorization" = ""Bearer abc123"  şeklinde Bearer token giriniz.
     */
    /*
    Given
    https://gmibank.com/api/tp-countries
    And
    body
    {
  "name": "Muz Cumhuriyeti",
  "states": [
    {
      "id": 1,
      "name": "Elma"
    },
    {
      "id": 2,
      "name": "Armut"
    },
    {
      "id": 3,
      "name": "Portakal"
    }
  ]
}
When
kullanıcı pst request gonderir
Then
status code=201

{
    "id": 191785,
    "name": "Muz Cumhuriyeti",
    "states": [
        {
            "id": 1,
            "name": "Elma",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Armut",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "Portakal",
            "tpcountry": null
        }
    ]
}
     */

    @Test
    public void postGMI() {
        //Set the url --->base url class olusturuldu
        spec.pathParams("first","api","second","tp-countries");

        //set the expected data---->pojo class olusturulur
        StatesPojo states1 =new StatesPojo(1,"Elma");
        StatesPojo states2 =new StatesPojo(2,"Armut");
        StatesPojo states3 =new StatesPojo(3,"Portakal");
        List <StatesPojo> statesList = new ArrayList<>();
        statesList.add(states1);
        statesList.add(states2);
        statesList.add(states3);
        //List<StatesPojo> stateList = new ArrayList<>(Arrays.asList(state1,state2,state3));---> seklinde de yapılır

        System.out.println(statesList.size());
        System.out.println(statesList);

        CountryPojo expectedData= new CountryPojo("Muz Cumhuriyet",statesList);
        System.out.println(expectedData);
        //Send the request and get the response
        Response response=  given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();



    }
}
