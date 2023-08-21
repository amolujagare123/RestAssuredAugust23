package GoRest.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static Utility.MyDataProvider.getMyData;
import static io.restassured.RestAssured.given;
import static payload.GoRest.PayloadCreateUserGoRest.getGoRestCreateUerPayload;

public class CreateUser3 {

    @Test(dataProvider = "getData")
    public void getAllUsers(String name,String email,String gender)
    {
        RestAssured.baseURI = "https://gorest.co.in/";
        given().log().all()
                .auth().oauth2("8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .contentType("application/json")
             //   .body(getGoRestCreateUerPayload())
                .body(getGoRestCreateUerPayload(name,email,gender,"active"))
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201);
    }

    @DataProvider
    Object[][] getData() throws IOException {

        return getMyData("Data/MyData.xlsx","GoRest");
    }
}
