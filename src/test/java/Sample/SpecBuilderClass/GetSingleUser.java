package Sample.SpecBuilderClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUser {

    @Test
    public void getSingleUserTest()
    {
        RequestSpecification getSingleUserRequest = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(getSingleUserRequest);

        Response hitRequest = request.when().get("/api/users/2");

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String responseStr = hitRequest.then().log().all()
                .spec(responseSpec).extract().asString();

        System.out.println(responseStr);
    }
}
