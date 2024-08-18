package org.appu.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ConditionalMethodsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/en-gb?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstNameTextbox = driver.findElement(By.id("input-firstname"));
        boolean firstNameTextboxStatus = firstNameTextbox.isEnabled();
        System.out.println("Text box is Enabled ? " + firstNameTextboxStatus);

        WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));
        boolean logoStatus = logo.isDisplayed();
        System.out.println("Logo is Displayed ? " + logoStatus);

        System.out.println("Total number of check box: " +
                driver.findElements(By.xpath("//*[@type='checkbox']")).size());

        WebElement subscribeCheckbox = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        boolean subscribeCheckboxStatus = firstNameTextbox.isSelected();
        System.out.println("Subscribe Checkbox Selected - Before ? " + subscribeCheckboxStatus);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        subscribeCheckbox.click();
        System.out.println("Subscribe Checkbox Selected - After ? " + subscribeCheckboxStatus);


        driver.quit();
    }
}
