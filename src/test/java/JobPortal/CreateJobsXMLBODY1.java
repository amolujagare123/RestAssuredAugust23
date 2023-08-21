package JobPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJobsXMLBODY1 {

    @Test
    public void createJobs()
    {
        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .accept("application/xml")
                .contentType("application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                        "<root>\n" +
                        "  <experience>Java</experience>\n" +
                        "  <experience>SQL</experience>\n" +
                        "  <experience>Selenium</experience>\n" +
                        "  <jobDescription>Software test engineer with 3 years experience</jobDescription>\n" +
                        "  <jobId>125</jobId>\n" +
                        "  <jobTitle>Manual Tester</jobTitle>\n" +
                        "  <project>\n" +
                        "    <projectName>Stock Management</projectName>\n" +
                        "    <Technology>Java</Technology>\n" +
                        "    <Technology>SQL</Technology>\n" +
                        "    <Technology>selenium</Technology>\n" +
                        "  </project>\n" +
                        "</root>")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
