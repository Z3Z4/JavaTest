package App.PostmanTest;


import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanTest {

    @Test
    public void GETRequestTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(emptyString()))
                .body("url", equalTo("https://postman-echo.com/get"));
    }
    @Test
    public void GETRequestWoops() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .header("User-Agent", "PostmanRuntime/7.6.1")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "5c27cd7d-6b16-4e5a-a0ef-191c9a3a275f")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip, deflate"))
                .body("headers.cache-control", equalTo("no-cache"))
                .body("headers.postman-token", equalTo("5c27cd7d-6b16-4e5a-a0ef-191c9a3a275f"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.6.1"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void POSTRawTextTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .body("{\"test\": \"value\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo("{\"test\": \"value\"}"))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("17"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(emptyString()))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", anything())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void POSTFormDataTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.30.1")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(""))
                .body("files", anEmptyMap()) //
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("19"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.30.1"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", not(emptyString()))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void PUTRequestTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .header("Content-Type", "text/plain; charset=ISO-8859-1")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", matchesPattern("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(emptyString()))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void PATCHRequestTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .header("Content-Type", "text/plain;charset=ISO-8859-1")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain;charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(emptyString()))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    public void DELETERequestTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.39.0"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(emptyString()))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", not(emptyString()))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}




