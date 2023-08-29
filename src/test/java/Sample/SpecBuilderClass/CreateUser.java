package Sample.SpecBuilderClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

      /*  RestAssured.baseURI = "https://reqres.in";

      given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);*/

        RequestSpecification requestCreateUser = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestCreateUser).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

        Response hitRequest = request.when().post("/api/users");

        ResponseSpecification responseCreateUser = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();

        String myResponse = hitRequest.then().log().all().spec(responseCreateUser).extract().asString();
    }
}
