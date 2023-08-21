package Sample;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserWithJson {

    @Test
    public  void myTest() throws IOException {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("JsonFiles/SampleCreateUser.json"))))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
