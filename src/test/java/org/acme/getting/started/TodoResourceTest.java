package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TodoResourceTest {

    @Test
    void should_add_item_to_list() {
        given()
                .body(new TodoItem("test"))
                .when().post("/todo/item")
                .then()
                .statusCode(200)
                .body(is(any(Integer.class)));
    }
}
