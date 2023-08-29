package ChatServer.POJO;

import POJO.chatServer.Response.AllUsersPOJO;
import POJO.chatServer.Response.Result;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetAllUsers {


    @Test
    public void getAllUsersTest()
    {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        AllUsersPOJO allUsersResponse = given().log().all()
                .auth().preemptive().basic("admin", "admin123")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(AllUsersPOJO.class);

       // print all first names

        ArrayList<Result> allResult = allUsersResponse.getResult();

    /*    for (int i=0;i< allResult.size();i++)
        {
        //    System.out.println(allResult.get(i).getName());
            System.out.println(allResult.get(i).getEmail());
        }
*/

        for (Result myResult:allResult)
        {
            //    System.out.println(allResult.get(i).getName());
           // System.out.println(myResult.getEmail());
            System.out.println(myResult.getId() +" "+myResult.getUsername());
        }
    }
}
