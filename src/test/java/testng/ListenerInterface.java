package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerInterface implements ITestListener {
    //Invoked before running all the test methods [test tag of xml file] belonging to the classes
    public void onStart(ITestContext context) {
        System.out.println("Before test tag in xml file");
    }

    //Invoked after all the test methods [test tag of xml file] belonging to the classes
    public void onFinish(ITestContext context) {
        System.out.println("After test tag in xml file");
    }

    //Invoked each time before a test method will be invoked
    public void onTestStart(ITestResult result) {
        System.out.println("Before each test method starts");
    }

    //Invoked each time a test succeeds.
    public void onTestSuccess(ITestResult result) {
        System.out.println("After each test method PASS");
    }

    //Invoked each time a test fails.
    public void onTestFailure(ITestResult result) {
        System.out.println("After each test method FAIL");
    }

    //Invoked each time a test is skipped.
    public void onTestSkipped(ITestResult result) {
        System.out.println("After each test method SKIPPED");
    }

    //Invoked each time a method fails but has been annotated with successPercentage and this failure
    //still keeps it within the success percentage requested.
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    //Invoked each time a test fails due to a timeout.
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}


