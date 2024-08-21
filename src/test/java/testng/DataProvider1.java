package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider1 {
    @BeforeMethod
    public void beforeMessage() {
        System.out.println("Test started");
    }

    @AfterMethod
    public void afterMessage() {
        System.out.println("Test ended");
    }

    @Test(dataProvider = "dp", dataProviderClass = DataProviderClass.class)
    public void login(String un, String pw,String status) {
        System.out.println("User name:" + un);
        System.out.println("Password:" + pw);
        System.out.println("Status:" + status);
    }
}
