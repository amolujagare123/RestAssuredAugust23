package ChatServer.specBulider;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUserBearer {

    @Test
    public void getSingleUserTest()
    {
       /* PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");*/



        RequestSpecification getUserRequest = new RequestSpecBuilder()
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin/")
                .addHeader("Authorization","Bearer "+"YWRtaW46YWRtaW4xMjM=")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(getUserRequest);

        Response hitRequest = request.when().get("/restapi/user/261");

        ResponseSpecification getUserResponse = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        hitRequest.then().log().all().spec(getUserResponse);
    }
}
