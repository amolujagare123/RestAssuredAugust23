package ChatServer.DataProvider;

import io.restassured.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utility.MyDataProvider.getMyData;
import static io.restassured.RestAssured.given;
import static payload.ChatServer.PayloadCreateUserChatServer.getChatServerCreateUerPayload;

public class CreateChatUser {

    @Test (dataProvider = "getData")
    public void createChatUser(String username,String password,String email,String name,String surname,String nickName)
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
               // .body(getChatServerCreateUerPayload())
                .body(getChatServerCreateUerPayload(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/MyData.xlsx","chat server");
    }
}
