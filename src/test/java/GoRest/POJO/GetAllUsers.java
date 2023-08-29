package GoRest.POJO;

import POJO.JobPortal.AllUsers;
import POJO.JobPortal.IndividualUser;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    @Test
    public void getAllUsers()
    {
        RestAssured.baseURI = "https://gorest.co.in/";
        IndividualUser allUsers = given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .when().get("/public/v2/users")
                .then().log().all().statusCode(200)
                .extract().as(IndividualUser.class);
        // print all users with their id


       // ArrayList<IndividualUser> myUsers = allUsers;



    }
}
