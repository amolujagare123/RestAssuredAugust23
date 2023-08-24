package Sample.POJOExamples;

import POJO.SampleUser.SampleCreateUserPOJO;
import POJO.SampleUser.SampleCreateUserResponsePOJO;
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

        SampleCreateUserResponsePOJO responseObj = given().log().all().header("Content-Type", "application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .extract().as(SampleCreateUserResponsePOJO.class);

        System.out.println("Created AT = "+responseObj.getCreatedAt());
        System.out.println("id = "+responseObj.getId());
    }
}
