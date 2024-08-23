package testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

    public static ExtentSparkReporter sparkReporter;  // UI of the report
    public static ExtentReports extent;  //populate common info on the report
    public static ExtentTest test; // creating test case entries in the report and update status of the test methods

}
