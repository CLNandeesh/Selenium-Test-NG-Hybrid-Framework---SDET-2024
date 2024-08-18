package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1));

        WebElement userNmeTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        userNmeTextBox.sendKeys("Admin");

        WebElement passwordTextBox = driver.findElement(By.name("password"));
        passwordTextBox.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
