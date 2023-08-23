package ChatServer.POJO;

import POJO.chatServer.CreateChatUserPOJO;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateChatUser {

    @Test
    public void createChatUser()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        CreateChatUserPOJO ob = new CreateChatUserPOJO();
        ob.setUsername("priya555");
        ob.setPassword("p1234");
        ob.setEmail("priya@gmail.com");
        ob.setName("Priya");
        ob.setSurname("Joshi");
        ob.setChat_nickname("PR321");

        ArrayList<Integer> forDept = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};
        ob.setDepartments(forDept);
        ArrayList<Integer> forDeptRead = new ArrayList<Integer>(){{
            add(2);
        }};
        ob.setDepartments_read(forDeptRead);
        ArrayList<Integer> forGroups = new ArrayList<Integer>(){{
            add(1);
        }};
        ob.setDepartment_groups(forGroups);
        ob.setUser_groups(forGroups);


        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
