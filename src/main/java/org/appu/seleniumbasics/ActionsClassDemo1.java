package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsClassDemo1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.opencart.com/");
        WebElement element = driver.findElement(By.xpath("//a[text()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Thread.sleep(5000);
        WebElement element2 = driver.findElement(By.xpath("//a[text()='Mac (1)']"));
        actions.moveToElement(element2).contextClick().build().perform();
        Thread.sleep(5000);
        actions.click(element2).build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}
