package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountRegistrationPage;
import utilities.Utils;

public class TC01AccountRegistrationtest extends BaseClass {
    @Test
    void validateAccountRegistration() throws InterruptedException {
        try {
            logger.info("********Stared executing validateAccountRegistration test case ********* ");
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            accountRegistrationPage.setFirstName(Utils.randomString());
            logger.info("Entered FN");
            accountRegistrationPage.setLastName("cl");
            logger.info("Entered LN");
            accountRegistrationPage.setEmail(Utils.randomString() + "@gmail.com");
            logger.info("Entered Email");
            accountRegistrationPage.setPassword("Apjkalam!123");
            logger.info("Entered Password");
            accountRegistrationPage.agreePolicy();
            Thread.sleep(2000);
            accountRegistrationPage.clickContinue();
            logger.info("Cicked Cntinue");
            Thread.sleep(2000);
            String actualMessage = accountRegistrationPage.getConfirmationMessage();
            logger.info("Actual Message: " + actualMessage);
            Assert.assertEquals(actualMessage, "Your Account Has Been Created!");
            logger.info("********Ended executing validateAccountRegistration test case ********* ");
        } catch (Exception e) {
            logger.error("Test case failed");
            logger.debug("Debug Logs");
            Assert.fail();
        }

    }
}
