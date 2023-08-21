package Sample.DataProvider;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.sampleUser.PayLoadCreateUser.getCreateUserPayLoad;

public class CreateUserEx {

    @Test (dataProvider = "getData")
    public void createUserAPITest(String name,String job) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                //.body(getCreateUserPayLoad())
                .body(getCreateUserPayLoad(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/MyData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sample");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        for (int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
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
