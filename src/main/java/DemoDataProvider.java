import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {

    @Test (dataProvider = "getData")
    public void demo(String name,String number,String email)
    {
       /* String name = "Amol";
        String number = "78787877";
        String email = "amol@gmail.com";*/

        System.out.println("name="+name);
        System.out.println("number="+number);
        System.out.println("email="+email);
    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data = new Object[3][3];

        data[0][0] = "Amol";
        data[0][1] = "188787";
        data[0][2] = "amol@gmail.com";

        data[1][0] = "vanita";
        data[1][1] = "288787";
        data[1][2] = "vanita@gmail.com";

        data[2][0] = "kumar";
        data[2][1] = "388787";
        data[2][2] = "kumar@gmail.com";

        return data;

    }

}
