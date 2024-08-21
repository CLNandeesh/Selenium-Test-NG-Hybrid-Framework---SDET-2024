package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting {

    @BeforeMethod
    @Parameters({"browser","os"})
    public void beforeMessage(String br,String os) {
        System.out.println("Test started in " + br.toUpperCase() + " browser and "+os.toUpperCase()+" OS");
    }

    @AfterMethod
    public void afterMessage() {
        System.out.println("Test ended");
    }

    @Test()
    public void login1() {
        System.out.println("Test method1...");
    }

    @Test()
    public void login2() {
        System.out.println("Test method2...");
    }
}
