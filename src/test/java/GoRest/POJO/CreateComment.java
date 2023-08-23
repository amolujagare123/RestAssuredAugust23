package GoRest.POJO;

import POJO.GoRest.GoRestCommentPOJO;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateComment {

    @Test
    public void createComment()
    {
        RestAssured.baseURI = "https://gorest.co.in/";

        GoRestCommentPOJO ob = new GoRestCommentPOJO();
        ob.setId(4602948);
        ob.setPost_id(63266);
        ob.setName("Rohit");
        ob.setEmail("rohit@gmail.com");
        ob.setBody("this is a good comment 2");

        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body(ob)
                .when().post("/public/v2/comments")
                .then().log().all().statusCode(201);
    }

}
