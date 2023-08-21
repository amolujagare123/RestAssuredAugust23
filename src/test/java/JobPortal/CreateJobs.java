package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJobs {

    @Test
    public void createJobs()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"experience\": [\n" +
                        "    \"Java\",\n" +
                        "\"SQL\",\n" +
                        "\"Selenium\"\n" +
                        "  ],\n" +
                        "  \"jobDescription\": \"Software test engineer with 3 years experience\",\n" +
                        "  \"jobId\": 123,\n" +
                        "  \"jobTitle\": \"Aoutomation Tester\",\n" +
                        "  \"project\": [\n" +
                        "    {\n" +
                        "      \"projectName\": \"Stock Management\",\n" +
                        "      \"Technology\": [\n" +
                        "        \"Java\" , \"SQL\" , \"selenium\"\n" +
                        "       ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
