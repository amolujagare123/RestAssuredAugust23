package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetALLJobs {

    @Test
    public void getAllJobs()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .accept("application/json")
                //.contentType("application/xml")
                .when().get("/normal/webapi/all")
                .then().log().all().assertThat().statusCode(200);
    }
}
