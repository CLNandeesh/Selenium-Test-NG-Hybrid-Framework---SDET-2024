package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement msgMyAccount;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;

    public boolean isMyAcccountTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(msgMyAccount));
        return msgMyAccount.isDisplayed();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOf(lnkLogout));
        lnkLogout.click();
    }
}
