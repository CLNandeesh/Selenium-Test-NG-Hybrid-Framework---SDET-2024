package testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager extends BaseClass implements ITestListener {


    public void onStart(ITestContext context) {

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extentreportstemp/myReport.html");//specify location of the report

        sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Nandeesh");
        extent.setSystemInfo("os", "Windows10");
        extent.setSystemInfo("Browser name", "Chrome");

    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName()); // create a new enty in the report
    }

    public void onTestSuccess(ITestResult result) {


        test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

    }

    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

    }


    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
