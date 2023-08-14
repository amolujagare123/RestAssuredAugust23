package Sample.withPayLoad;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.sampleUser.PayLoadCreateUser.getCreateUserPayLoad;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(getCreateUserPayLoad())
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
