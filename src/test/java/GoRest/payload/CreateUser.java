package GoRest.payload;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static payload.GoRest.PayloadCreateUserGoRest.getGoRestCreateUerPayload;

public class CreateUser {

    @Test
    public void getAllUsers()
    {
        RestAssured.baseURI = "https://gorest.co.in/";
        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
             //   .body(getGoRestCreateUerPayload())
                .body(getGoRestCreateUerPayload("Hemant1","hemant1@gmail.com","male","active"))
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201);
    }
}
