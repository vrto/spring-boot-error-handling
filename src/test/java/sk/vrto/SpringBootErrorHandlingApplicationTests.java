package sk.vrto;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootErrorHandlingApplicationTests {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldReportInternalServerError() {
        get("/internal-server-error").then()
            .statusCode(INTERNAL_SERVER_ERROR.value())
            .body("code", equalTo(500))
            .body("status", equalTo("Internal-Server-Error"))
            .body("message", equalTo("Oops! Something went wrong!"));
    }

    @Test
    public void shouldReportUnknownPath() {
        get("/bogus-path").then()
            .statusCode(NOT_FOUND.value())
            .body("code", equalTo(404))
            .body("status", equalTo("Not-Found"))
            .body("message", equalTo("Unknown path: /bogus-path"));
    }

    @Test
    public void shouldReportWrongPayload_OnInvalidMarshalling() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"foo\": \"error\"}") // foo should be an integer
        .when()
            .post("/consume-payload")
        .then()
            .statusCode(BAD_REQUEST.value())
            .body("code", equalTo(400))
            .body("status", equalTo("Bad-Request"))
            .body("message", equalTo("Failure parsing request body!"));

    }
}
