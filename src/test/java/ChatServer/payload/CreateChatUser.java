package ChatServer.payload;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static payload.ChatServer.PayloadCreateUserChatServer.getChatServerCreateUerPayload;

public class CreateChatUser {

    @Test
    public void createChatUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
               // .body(getChatServerCreateUerPayload())
                .body(getChatServerCreateUerPayload("parmeshwari","par1234","parmeshwari@gmail.com",
                        "parmeshwari","XYZ","PAR111"))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
