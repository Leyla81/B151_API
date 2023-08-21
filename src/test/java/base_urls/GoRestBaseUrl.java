package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {
    protected RequestSpecification spec;

    @Before//her class dan once calısmasını istiyorum
    public void setUp() {
        spec = new RequestSpecBuilder()//RequestSpecBuilder() bu class dan imlement yaptık
                .setBaseUri("https://gorest.co.in/public/v1")
                .setContentType(ContentType.JSON)
                .build();
    }
}