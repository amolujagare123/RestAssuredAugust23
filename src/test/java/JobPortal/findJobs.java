package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class findJobs {

    @Test

    public void getAllJobs()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .accept("application/json")
                //.contentType("application/xml")
                .queryParam("id","123")
                .queryParam("jobTitle","Aoutomation Tester")
                .when().get("/normal/webapi/find")
                .then().log().all().assertThat().statusCode(200);
    }
}
