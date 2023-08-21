package base_urls;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppBaseUrl {
    protected RequestSpecification spec ;
    @Before
    public void Setup(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
               // .setAccept(ContentType.JSON)
                //.setContentType(ContentType.JSON)
                .build();


    }
}