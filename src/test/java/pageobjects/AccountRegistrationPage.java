package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    WebElement txtLastName;

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkPolicy;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement msgConformation;

    public void setFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void agreePolicy()  {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", chkPolicy);
        // chkPolicy.click();
    }

    public void clickContinue() throws  InterruptedException{
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(btnContinue)));
        // btnContinue.click();
        Thread.sleep(10000);
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(msgConformation));
        return msgConformation.getText();
    }

}
