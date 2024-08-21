package testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Annotations {

    SoftAssert s = new SoftAssert();

    @BeforeSuite
    public void openBrowser() {
        System.out.println("Open browser...");

    }

    @BeforeTest
    public void openApp() {
        System.out.println("Open APP....");

    }

    @BeforeClass
    public void login() {
        System.out.println("Login ...");

    }

    @AfterClass
    public void logout() {
        System.out.println("Logout....");
    }

    @AfterTest
    public void closeApp() {
        System.out.println("Close App...");
    }

    @AfterSuite
    public void closeBrowser() {
        System.out.println("Close browser...");

    }

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
       Assert.fail();
        System.out.println("After user created");
    }

    @Test
    public void deleteUser() {
        System.out.println("User Deleted...");
    }
}
