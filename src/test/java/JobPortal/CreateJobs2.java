package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateJobs2 {

    @Test
    public void createJobs() throws IOException {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body(new String(Files.readAllBytes(Paths.get("JsonFiles/CreateJob.json"))))
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
