package Sample;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {
    public static void main(String[] args) {

        RestAssured.baseURI ="https://reqres.in";

        given().log().all().contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"Amol\",\n" +
                        "    \"job\": \"Tester\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);

    }
}
