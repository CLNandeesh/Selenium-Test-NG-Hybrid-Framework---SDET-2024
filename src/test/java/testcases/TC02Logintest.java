package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountRegistrationPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.Utils;

public class TC02Logintest extends  BaseClass{

    @Test(groups = {"sanity"})
    void validateLoginWithValidCredentials() throws InterruptedException {
        try {

            logger.info("validateLoginWithValidCredentials Started");
            LoginPage loginPage=new LoginPage(driver);
            loginPage.enterEmail("nandeesh.apjkalam@gmail.com");
            loginPage.enterPassword("Apjkalam!123");
            loginPage.clickLogin();

            MyAccountPage myAccountPage=new MyAccountPage(driver);
            boolean status=myAccountPage.isMyAcccountTextDisplayed();
            Assert.assertEquals(status,true);
            logger.info("validateLoginWithValidCredentials Ended");

        } catch (Exception e) {
            logger.error("Test case failed");
            logger.debug("Debug Logs");
            Assert.fail();
        }

    }
}
