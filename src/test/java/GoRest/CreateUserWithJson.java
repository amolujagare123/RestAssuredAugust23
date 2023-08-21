package GoRest;


import io.restassured.RestAssured;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserWithJson {

    @Test
    public void getAllUsers() throws IOException {
        RestAssured.baseURI = "https://gorest.co.in/";
        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(new String(Files.readAllBytes(Paths.get("JsonFiles/GoRest.json"))))
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201);
    }
}
