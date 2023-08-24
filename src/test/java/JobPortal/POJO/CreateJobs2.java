package JobPortal.POJO;

import POJO.JobPortal.CreateJobPOJO;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


        CreateJobPOJO respObj = given().log().all()
                .accept("application/json")
                .contentType("application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201)
                .extract().as(CreateJobPOJO.class);

        // print the list of Project names

        ArrayList<Project> projects = respObj.getProject();

        // get all technologies if it is repeated write it only once
        ArrayList<String> allTechnologies = new ArrayList<>();
        for (Project myProject:projects) // for each loop
        {
            System.out.println(myProject.getProjectName());


            for (int i=0;i<myProject.getTechnology().size();i++)
            {
                allTechnologies.add(myProject.getTechnology().get(i));
            }

        }

        System.out.println(allTechnologies);

        Set<String> uniqueTech = new HashSet<>(allTechnologies);

        System.out.println(uniqueTech);

/*
        for (int i=0;i< projects.size();i++)
        {
            System.out.println(projects.get(i).getProjectName());
        }*/
    }
}
