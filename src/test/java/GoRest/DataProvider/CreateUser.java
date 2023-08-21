package GoRest.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.GoRest.PayloadCreateUserGoRest.getGoRestCreateUerPayload;

public class CreateUser {

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

        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("GoRest");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
        }

       /* data[0][0] = "Priya";
        data[0][1] = "Test Engg.";

        data[1][0] = "Vanita";
        data[1][1] = "Soft. Engg.";

        data[2][0] = "Prashant";
        data[2][1] = "Test lead";*/

        return data;
    }
}
