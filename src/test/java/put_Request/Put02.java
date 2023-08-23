package put_Request;

import Utils.ObjectMapperUtils;
import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiRespondPojo;

import static Utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
    Test Case: Type by using Gherkin Language
    Given
       URL: https://dummy.restapiexample.com/api/v1/update/21

       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
                     When
                     kullanıcı put request gonderir
                     HTTP Request Method: PUT Request
       Assert: Then
                i) Status code is 200
                And
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */


    @Test
    public void put02() {

        //set the url
        spec.pathParams("first","update","second",21);

        //set expected data
        DummyRestApiDataPojo expectedData= new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);

        //send req.and get resp.
        Response response= given(spec).body(expectedData).when().put("{first}/{second}");
        System.out.println("response = " + response);

        //do assertion
        DummyRestApiRespondPojo actualData =ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiRespondPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getGetEmployee_age(),actualData.getData().getGetEmployee_age());
        assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getProfile_image(), actualData.getData().getProfile_image());
        assertEquals("Successfully! Record has been updated.",actualData.getMessage());

    }
}
