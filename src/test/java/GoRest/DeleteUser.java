package GoRest;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void getAllUsers()
    {
        RestAssured.baseURI = "https://gorest.co.in/";
        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .when().delete("/public/v2/users/4427881")
                .then().log().all().statusCode(204);
    }
}
