package Sample;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        String createUserRequest = given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201).extract().asString();
        System.out.println("The string out put ===== >>");
        System.out.println(createUserRequest);

        JsonPath jsonPath = new JsonPath(createUserRequest);
        String name = jsonPath.getString("name");
        System.out.println("name="+name);
    }
}
