package GoRest.POJO;

import POJO.GoRest.GoRestCreateUserPOJO;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void getAllUsers()
    {
        RestAssured.baseURI = "https://gorest.co.in/";

        GoRestCreateUserPOJO ob = new GoRestCreateUserPOJO();
        ob.setName("Rohit2");
        ob.setEmail("rohit1@gmail.com");
        ob.setGender("male");
        ob.setStatus("active");

        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(ob)
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201);
    }
}
