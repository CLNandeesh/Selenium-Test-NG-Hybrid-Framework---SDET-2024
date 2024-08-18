package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    public void enterEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        // executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOf(btnLogin)));
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.visibilityOf(btnLogin)).submit();
        WebElement element = wait.until(ExpectedConditions.visibilityOf(btnLogin));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
}
