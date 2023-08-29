package Sample.SpecBuilderClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class UpdateUser {
    public static void main(String[] args) {

        /*RestAssured.baseURI ="https://reqres.in";

        given().log().all().contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"Amol\",\n" +
                        "    \"job\": \"Tester\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);*/

        RequestSpecification updateUserRequest = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType("application/json")
                .build();

        RequestSpecification userRequest = given().log().all().spec(updateUserRequest)
                .body("{\n" +
                        "    \"name\": \"Amol\",\n" +
                        "    \"job\": \"Tester\"\n" +
                        "}");

        Response hitUpdateRequest = userRequest.when().put("/api/users/2");


        ResponseSpecification updateUserResponse = new ResponseSpecBuilder()
                              .expectStatusCode(200).build();


        hitUpdateRequest.then().log().all().spec(updateUserResponse);
    }
}
