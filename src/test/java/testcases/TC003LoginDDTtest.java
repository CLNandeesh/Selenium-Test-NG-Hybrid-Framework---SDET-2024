package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class TC003LoginDDTtest extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    void validateLoginDDT(String email, String password, String exp) throws InterruptedException {
        try {
            logger.info("**********validateLoginDDT Started************************");
            System.out.println(email);
            System.out.println(password);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean status = myAccountPage.isMyAcccountTextDisplayed();

        /*
        Valid data: Login success    PASS
                    Login fail       FAIL
        In Valid data: Login success FAIL
                       Login fail    PASS
        */

            if (exp.equalsIgnoreCase("valid")) {
                if (status == true) {
                    Assert.assertTrue(true);
                    myAccountPage.clickLogout();
                } else {
                    Assert.assertTrue(false);
                }
            } else if (exp.equalsIgnoreCase("invalid")) {
                if (status == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            logger.error("Test case failed");
            logger.debug("Debug Logs");
            Assert.fail();
        }
        logger.info("******************validateLoginDDT Ended***********************");
    }
}
