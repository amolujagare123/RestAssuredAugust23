package JobPortal.POJO;

import POJO.JobPortal.CreateJobPOJO;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateJobs2 {

    @Test
    public void createJobs() throws IOException {
        RestAssured.baseURI = "http://localhost:9897/";

        CreateJobPOJO ob = new CreateJobPOJO();

        ArrayList<String> forExperience = new ArrayList<String>(){{
            add("1 year in manual testing");
            add("1 year in automation testing");
        }};
        ob.setExperience(forExperience);
        ob.setJobDescription("Automation testers with API and manual skills are required");
        ob.setJobId(456);
        ob.setJobTitle("Automation testers with 3 years Experience");

        Project forProject1 = new Project();

        forProject1.setProjectName("Axis Bank finance");
        ArrayList<String> forTechnology1= new ArrayList<String>(){{
            add("Java");
            add("selenium");
            add("sql");
        }};
        forProject1.setTechnology(forTechnology1);

        Project forProject2 = new Project();

        forProject2.setProjectName("SBI Bank finance");
        ArrayList<String> forTechnology2= new ArrayList<String>(){{
            add(".net");
            add("selenium");
            add("sql");
        }};
        forProject2.setTechnology(forTechnology2);


        ArrayList<Project> forProject = new ArrayList<Project>();
        forProject.add(forProject1);
        forProject.add(forProject2);

        ob.setProject(forProject);


        given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
