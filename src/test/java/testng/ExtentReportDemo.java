package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentReportDemo extends BaseClass {

    @Test
    public void test1() {
        test.info("Test 1 Method");
    }

    @Test
    public void test2() {
        test.info("Test 2 Method");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"test2"})
    public void test3() {
        test.info("Test 3 Method");
    }

    @BeforeClass
    public void open() {
        System.out.println("Before class ...");
    }

    @AfterClass
    public void close() {
        System.out.println("After class ...");
    }
}
