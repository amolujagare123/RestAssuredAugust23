package ChatServer.BearerToken;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateChatUser {

    @Test
    public void createChatUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                .header("Authorization","Bearer YWRtaW46YWRtaW4xMjM=")
                .contentType("application/json")
                .body("{\n" +
                        "  \"username\": \"kumar1\",\n" +
                        "  \"password\": \"kumar123\",\n" +
                        "  \"email\": \"kumar@example.org\",\n" +
                        "  \"name\": \"kumar\",\n" +
                        "  \"surname\": \"xyz\",\n" +
                        "  \"chat_nickname\": \"k123\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
