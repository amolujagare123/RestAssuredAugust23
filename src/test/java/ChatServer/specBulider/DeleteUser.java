package ChatServer.specBulider;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void deleteUserTest()
    {
        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification deleteUserRequest = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin/")
                .setAuth(auth)
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(deleteUserRequest);

        Response hitRequest = request.when().delete("/restapi/user/262");

        ResponseSpecification deleteUserResponse = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        hitRequest.then().log().all().spec(deleteUserResponse);
    }
}
