package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static Utils.AuthenticationHerokuApp.generateToken;

public class GMIBankBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gmibank.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjkyOTA2MDU3fQ.OwaqxhqKTHT_ae4HIXrAwDUzzXtRVUqHz_t0ZVCc5JK2qhw3EgTBvliT_QxC7W8w40SvCL1-mNXmUn_PMueOxA")
                .build();
    }
}

