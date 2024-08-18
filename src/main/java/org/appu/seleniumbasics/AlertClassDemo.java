package org.appu.seleniumbasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertClassDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Using Switch command
//        driver.findElement(By.xpath("//button[text()='Prompt']")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("appu boss");
//        alert.accept();

        //Using Explicit wait
        driver.findElement(By.xpath("//button[text()='Prompt']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(5000);
        alert.accept();



        driver.quit();


    }
}
