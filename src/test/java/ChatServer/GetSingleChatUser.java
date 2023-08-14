package ChatServer;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleChatUser {

    @Test
    public void createChatUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
                .when().get("/restapi/user/252")
                .then().log().all().assertThat().statusCode(200);
    }
}
