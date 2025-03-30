package org.example.PostmanTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get("/get?param1=value1&param2=value2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.param1", equalTo("value1"))
                .body("args.param2", equalTo("value2"));
    }

    @Test
    public void testPostRawTextRequest() {
        given()
                .contentType(ContentType.TEXT)
                .body("funny body")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("funny body"));
    }

        @Test
        public void testPostFormDataRequest() {
            given()
                    .contentType(ContentType.URLENC)
                    .formParam("foo1", "bar1")
                    .formParam("foo2", "bar2")
                    .when()
                    .post("/post")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("form.foo1", equalTo("bar1"))
                    .body("form.foo2", equalTo("bar2"));
        }



    @Test
    public void testPutRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"city\": \"Gomel\", \"bus\": 17}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("json.city", equalTo("Gomel"))
                .body("json.bus", equalTo(17));
    }

    @Test
    public void testPatchRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Anna\", \"age\": 27 }")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("json.name", equalTo("Anna"))
                .body("json.age", equalTo(27));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
