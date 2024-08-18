package testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties properties;


    @BeforeClass(groups = {"sanity"})
    @Parameters({"os", "browser"})
    void setup(String osName, String browserName) throws InterruptedException, IOException {
        //Logging
        logger = LogManager.getLogger(this.getClass());

        //Properties file reading
        FileReader fileReader = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(fileReader);
        String loginURL = properties.getProperty("url");

        //Configuration for remote selenum grid execution
        //String hubURL = "http://192.168.1.4:4444/wd/hub";
        String hubURL = "http://192.168.1.4:4444/wd/hub";

        String executionPlatform = properties.getProperty("execution_env");
        System.out.println("EXECUTION PLATFORM:" + executionPlatform);

        if (executionPlatform.equalsIgnoreCase("remote")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            //OS
            if (osName.equalsIgnoreCase("windows")) {
                desiredCapabilities.setPlatform(Platform.WIN11);
            } else if (osName.equalsIgnoreCase("mac")) {
                desiredCapabilities.setPlatform(Platform.IOS);
            } else if (osName.equalsIgnoreCase("linux")) {
                desiredCapabilities.setPlatform(Platform.LINUX);
            } else {
                System.out.println("Invalid OS");
                return;
            }

            //Browser
            if (browserName.equalsIgnoreCase("chrome")) {
                desiredCapabilities.setBrowserName("chrome");
            } else if (browserName.equalsIgnoreCase("firefox")) {
                desiredCapabilities.setBrowserName("Firefox");
            } else if (browserName.equalsIgnoreCase("edge")) {
                desiredCapabilities.setBrowserName("MicrosoftEdge");
            } else {
                System.out.println("Invalid BROWSER");
                return;
            }

            driver = new RemoteWebDriver(new URL(hubURL), desiredCapabilities);
        } else if (executionPlatform.equalsIgnoreCase("local")) {
            switch (browserName.toLowerCase()) {
                case "chrome": {
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    System.out.println("Invalid Browser");
                    return;
                }
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("URL is:" + loginURL);
        driver.get(loginURL);
    }

    @AfterClass(groups = {"sanity"})
    void tearDown() {
        driver.quit();
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}
