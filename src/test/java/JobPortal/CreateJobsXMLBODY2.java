package JobPortal;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateJobsXMLBODY2 {

    @Test
    public void createJobs() throws IOException {
        RestAssured.baseURI = "http://localhost:9897/";

        String body = new String(Files.readAllBytes(Paths.get("JsonFiles/JobPortalCreateUser.xml")));
        System.out.println("body="+body);

        given().log().all()
                .accept("application/xml")
                .contentType("application/xml")
           //    .body(new String(Files.readAllBytes(Paths.get("JsonFiles/JobPortalCreateUser.xml"))))
                .body("<?xml version=\"1.0\"?>\n" +
                        "<Job>\n" +
                        "  <experience>string</experience>\n" +
                        "  <jobDescription>string</jobDescription>\n" +
                        "  <jobId>"+1+"</jobId>\n" +
                        "  <jobTitle>string</jobTitle>\n" +
                        "  <project>\n" +
                        "    <projectName>string</projectName>\n" +
                        "    <technology>string</technology>\n" +
                        "  </project>\n" +
                        "</Job>\n")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
