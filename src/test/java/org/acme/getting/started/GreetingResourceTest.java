package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    @Test
    void testGreetingEndpoint() {
        UUID uuid = UUID.randomUUID();
        given()
                .when().get("/hello/greeting/" + uuid)
                .then()
                .statusCode(200)
                .body(is("hello " + uuid + " you quarkus"));
    }
}