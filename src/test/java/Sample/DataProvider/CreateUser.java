package Sample.DataProvider;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.sampleUser.PayLoadCreateUser.getCreateUserPayLoad;

public class CreateUser {

    @Test (dataProvider = "getData")
    public void createUserAPITest(String name,String job) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                //.body(getCreateUserPayLoad())
                .body(getCreateUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data = new Object[3][2];

        data[0][0] = "Priya";
        data[0][1] = "Test Engg.";

        data[1][0] = "Vanita";
        data[1][1] = "Soft. Engg.";

        data[2][0] = "Prashant";
        data[2][1] = "Test lead";

        return data;
    }
}
