package GoRest;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateComment {

    @Test
    public void createComment()
    {
        RestAssured.baseURI = "https://gorest.co.in/";
        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
                .body("{\n" +
                        "\t\t\"id\": 4602948,\n" +
                        "\t\t\"post_id\":63266,\n" +
                        "\t\t\"name\": \"Rohit\",\n" +
                        "      \t\t\"email\": \"rohit@gmail.com\",\n" +
                        "\t\t\"body\": \"this is my comment\"\n" +
                        "\t}")
                .when().post("/public/v2/comments")
                .then().log().all().statusCode(201);
    }

}
