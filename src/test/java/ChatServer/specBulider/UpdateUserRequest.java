package ChatServer.specBulider;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateUserRequest {

    @Test
    public void updateUserTest()
    {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification updateUserRequest = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin/")
                .setAuth(auth)
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(updateUserRequest)
                .body("{\n" +
                        "  \"username\": \"sneha1\",\n" +
                        "  \"password\": \"sneha123\",\n" +
                        "  \"email\": \"sneha@gmail.com\",\n" +
                        "  \"name\": \"Sneha\",\n" +
                        "  \"surname\": \"More\",\n" +
                        "  \"chat_nickname\": \"s1234\",\n" +
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
                        "}");

        Response hitRequest = request.when().put("/restapi/user/262");

        ResponseSpecification updateUserResponse = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("result.username", equalTo("sneha1"))
                .build();

        hitRequest.then().log().all().spec(updateUserResponse);
    }
}
