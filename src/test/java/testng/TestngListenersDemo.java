package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testng.ListenerInterface.class)
public class TestngListenersDemo {
    @Test
    public void test1() {
        System.out.println("Test 1...");
    }

    @Test
    public void test2() {
        //System.out.println("Test2...");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"test2"})
    public void test3() {
        System.out.println("Test3...");
    }

    @BeforeClass
    public void open()
    {
        System.out.println("Before class ...");
    }

    @AfterClass
    public void close()
    {
        System.out.println("After class...");
    }
}
