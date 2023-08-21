package ComplexJson;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static payload.ComplexJSONPayload.getComplexJson;

public class DemoComplexJson {
    JsonPath js;
    @BeforeClass
    public void setJson()
    {
        String resultJson = getComplexJson();
        js = new JsonPath(resultJson);
    }

    @Test
    public void getCourses()
    {
        //Print No of courses returned by API
        int expected = 4;

        int actualCourses = js.get("courses.size()");
        System.out.println(actualCourses);
        Assert.assertEquals(actualCourses,expected,
                "Number of courses are not 4, they are:"+actualCourses);

    }

    @Test
    public void getPurchaseAmount()
    {
        //Print Purchase Amount
        int expected = 1162;
        int actual = js.get("dashboard.purchaseAmount");
        Assert.assertEquals(actual,expected,
                "purchase amount is not 1163, it is:"+actual);
    }

    @Test
    public void getFirstTitle()
    {
        // Print Title of the first course (Selenium PythonSelenium Python)

        String expected = "Selenium Python";
        String actual = js.get("courses[0].title");
        Assert.assertEquals(actual,expected,
                "Title is not 'Selenium Python', it is:"+actual);
    }

    @Test
    public void getAllTitleAndPrices()
    {
        // Print All course titles and their respective Prices

      /*  LinkedHashMap<String,Integer> expectedBookInfo = new LinkedHashMap<>();
        expectedBookInfo.put("Selenium Python",50);
        expectedBookInfo.put("Cypress",40);
        expectedBookInfo.put("RPA",45);
        expectedBookInfo.put("Appium",36);*/

        LinkedHashMap<String,Integer> expectedBookInfo = new LinkedHashMap() {{
            put("Selenium Python",50);
            put("Cypress",40);
            put("RPA",45);
            put("Appium",36);
        }};


        LinkedHashMap<String,Integer> actualBookInfo = new LinkedHashMap<>();
        int totalCourses = js.get("courses.size()");

        for (int i=0;i<totalCourses;i++)
        {
            String title = js.get("courses["+i+"].title");
           // String title = js.get(String.format("courses[%s].title",i));
            int price = js.get("courses["+i+"].price");
            actualBookInfo.put(title,price);
        }

        System.out.println("expectedBookInfo="+expectedBookInfo);
        System.out.println("actulBookInfo="+actualBookInfo);


        Assert.assertEquals(actualBookInfo,expectedBookInfo,
                "Info not match:");

    }

    @Test
    public void verifyRPACopies()
    {
        // Print no of copies sold by RPA Course
        int expected = 10;
        int actual = 0;
        for (int i=0;i<js.getInt("courses.size()");i++)
        {

          //  if("RPA".equalsIgnoreCase(js.getString("courses["+i+"].title")))
            if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
             {
                actual = js.getInt("courses["+i+"].copies");
                break;
            }
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,
                "Info not match:");
    }

// Verify if Sum of all Course prices matches with Purchase Amount
    @Test
    public void verifyPurchaseAmount()
    {
        int expected = 1162;
        int sum = 0;

        for (int i=0;i<js.getInt("courses.size()");i++) {

            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");
            int totalPrice = price * copies;

            sum = sum + totalPrice;
        }
        int actual = sum;

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,
                "purchase amount not match:");
    }

}
