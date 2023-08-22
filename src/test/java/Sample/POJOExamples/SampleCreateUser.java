package Sample.POJOExamples;

import POJO.SampleUser.SampleCreateUserPOJO;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleCreateUser {

    @Test
    public void createUserTest()
    {
        RestAssured.baseURI = "https://reqres.in";

        SampleCreateUserPOJO ob = new SampleCreateUserPOJO();
        ob.setName("Vanita");
        ob.setJob("Test Manager");

        String createUserRequest = given().log().all().header("Content-Type", "application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201).extract().asString();
    }
}
