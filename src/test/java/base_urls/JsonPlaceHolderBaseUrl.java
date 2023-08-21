package base_urls;

import get_requests.RequestResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class JsonPlaceHolderBaseUrl {


       //   RequestSpecification  bir interface oldugu icin obje olustururken
    //   RequestSpecBuilder() clasından faydalanarak obje olustururuz.

   protected  RequestSpecification spec;
    @Before//her class dan once calısmasını istiyorum
    public void setUp() {
           spec = new RequestSpecBuilder()//RequestSpecBuilder() bu class dan imlement yaptık
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }

   //her sorguda tekrar eden datalar bu classda ye alır












}
