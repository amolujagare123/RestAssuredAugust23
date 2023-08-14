package ChatServer.BearerToken;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {


    @Test
    public void getAllUsersTest()
    {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .header("Authorization","Bearer YWRtaW46YWRtaW4xMjM=")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200);


    }
}
