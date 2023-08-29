package Sample.SpecBuilderClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void deleteUserTest()
    {
        RequestSpecification deleteUserRequest = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();

        RequestSpecification deleteRequest = given().log().all().spec(deleteUserRequest);

        Response hitDeleteRequest = deleteRequest.when().delete("/api/users/2");

        ResponseSpecification deleteUserResponse = new ResponseSpecBuilder()
                                .expectStatusCode(204).build();

        hitDeleteRequest.then().log().all().spec(deleteUserResponse);
    }
}
