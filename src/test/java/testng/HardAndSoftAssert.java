package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {

    SoftAssert s = new SoftAssert();

    @BeforeMethod
    public void beforeMethodMessage() {
        System.out.println("Execution started...");

    }

    @AfterMethod
    public void afterMethodMessage() {
        System.out.println("Execution ended...");

    }

    @Test
    public void createUser() {
        System.out.println("User Created...");
        s.fail();
        System.out.println("After user created"); //Not executed for hard assert, execute for Soft assert
        s.assertAll();
    }

    @Test
    public void deleteUser() {
        System.out.println("User Deleted...");
    }
}
